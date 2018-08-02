package org.usfirst.frc.team5518.robot.subsystems;

import org.usfirst.frc.team5518.robot.Robot;
import org.usfirst.frc.team5518.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrainSub extends Subsystem {
	
	private double speedlim = 0.5;
	private double turnlim = 0.7;
	private double shootlim = 1.0;
	
    private VictorSP frontLeftMotor = new VictorSP(RobotMap.FRONT_LEFT_MTR);
    private VictorSP backLeftMotor = new VictorSP(RobotMap.REAR_LEFT_MTR);
    private VictorSP frontRightMotor = new VictorSP(RobotMap.FRONT_RIGHT_MTR);
    private VictorSP backRightMotor = new VictorSP(RobotMap.REAR_RIGHT_MTR);

    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    
    private DifferentialDrive driveTrain = new DifferentialDrive(leftGroup, rightGroup);
    
    private VictorSP intakeMotor = new VictorSP(RobotMap.INTAKE_MTR);
    private VictorSP upperShootMotor = new VictorSP(RobotMap.TOP_SHOOT_MTR);
    private VictorSP lowerShootMotor = new VictorSP(RobotMap.BTM_SHOOT_MTR);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(Robot.driveCommand);
    }
    
    public void arcadeDrive(double drive, double turn) {
    	driveTrain.arcadeDrive(drive*speedlim*-1, turn*turnlim, true);
    }
    
    public void shoot(double speed) {
    	upperShootMotor.set(speed*shootlim);
    	lowerShootMotor.set(-speed*shootlim);
    }
    
    public void intake(double speed) {
    	intakeMotor.set(-speed);
    }
    
}

