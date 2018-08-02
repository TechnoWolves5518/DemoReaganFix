package org.usfirst.frc.team5518.robot.commands;

import org.usfirst.frc.team5518.robot.OI;
import org.usfirst.frc.team5518.robot.Robot;
import org.usfirst.frc.team5518.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCom extends Command {

	private double driveSpeed, turnSpeed;
	private double intakeSpeed, shooterSpeed;
	private boolean revIntake, revShooter;
	
	private boolean isA, wasA, driveEnabled;
	
    public DriveCom() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrainSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		isA = false; wasA = false; driveEnabled = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	isA = OI.xboxController.getRawButton(RobotMap.XBOX_ABUTTON);
    	
    	if (isA != wasA && isA == true) {
    		driveEnabled = !driveEnabled;
    	}
    	
    	if (driveEnabled) {
    		driveSpeed = OI.xboxController.getRawAxis(RobotMap.XBOX_LSTICKY);
        	turnSpeed = OI.xboxController.getRawAxis(RobotMap.XBOX_RSTICKX);
    	}
    	else {
    		driveSpeed = 0;
    		turnSpeed = 0;
    	}
    	
    	intakeSpeed = OI.xboxController.getRawAxis(RobotMap.XBOX_LTRIGGER);
    	shooterSpeed = OI.xboxController.getRawAxis(RobotMap.XBOX_RTRIGGER);
    	
    	revIntake = OI.xboxController.getRawButton(RobotMap.XBOX_LBUMPER);
    	revShooter = OI.xboxController.getRawButton(RobotMap.XBOX_RBUMPER);
    	
    	Robot.driveTrainSub.arcadeDrive(driveSpeed, turnSpeed);
    	
    	if (intakeSpeed > 0.1) {
    		Robot.driveTrainSub.intake(0.8);
    	}
    	else {
    		Robot.driveTrainSub.intake(0);
    	}
    	
    	if (shooterSpeed > 0.1) {
    		Robot.driveTrainSub.shoot(shooterSpeed);
    	}
    	else {
    		Robot.driveTrainSub.shoot(0);
    	}
    	
    	if (revIntake) {
    		Robot.driveTrainSub.intake(-0.8);
    	}
//    	else {
//    		Robot.driveTrainSub.intake(0);
//    	}
    	
    	if (revShooter) {
    		Robot.driveTrainSub.shoot(-0.3);
    	}
//    	else {
//    		Robot.driveTrainSub.shoot(0);
//    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
