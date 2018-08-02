/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5518.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static int XBOX_CONTROLLER = 0;

	// Xbox 360/One controller mapping
	// controller axis
	public static int XBOX_LSTICKX = 0;
	public static int XBOX_LSTICKY = 1; 
	public static int XBOX_RSTICKX = 4;
	public static int XBOX_RSTICKY = 5;
	public static int XBOX_LTRIGGER = 2;
	public static int XBOX_RTRIGGER = 3;

	// controller buttons
	public static int XBOX_YBUTTON = 4;
	public static int XBOX_XBUTTON = 3;
	public static int XBOX_ABUTTON = 1;
	public static int XBOX_BBUTTON = 2; 
	public static int XBOX_RBUMPER = 6;
	public static int XBOX_LBUMPER = 5;
	public static int XBOX_LSTICK = 9;
	public static int XBOX_RSTICK = 10;
	public static int XBOX_START = 8;
	public static int XBOX_BACK = 7;

	// Drive Train (PWM)
	public static int FRONT_LEFT_MTR = 5;
	public static int REAR_LEFT_MTR = 1;
	public static int FRONT_RIGHT_MTR = 2;
	public static int REAR_RIGHT_MTR = 3;

	// Special functions (PWM)
	public static int BTM_SHOOT_MTR = 8; // 4 -> 0
	public static int TOP_SHOOT_MTR = 4; // 0 -> 4
	public static int INTAKE_MTR = 7;

}
