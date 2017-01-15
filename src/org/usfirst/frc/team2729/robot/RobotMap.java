package org.usfirst.frc.team2729.robot;

public class RobotMap {
	public static final int
	PORT_JOYSTICK_DRIVE 			= 4,
	PORT_JOYSTICK_ARMS  			= 1,
	PORT_JOYSTICK_DEBUG 			= 2;

	//Buttons
	public static final int
	JOYDRIVE_BUTTON_HALVE_1			   = 8,
	JOYDRIVE_BUTTON_HALVE_2			   = 7,
	JOYDRIVE_BUTTON_SHIFT_DRIVE_HIGH   = 4,
	JOYDRIVE_BUTTON_SHIFT_DRIVE_LOW    = 2,
	JOYDRIVE_BUTTON_FORWARD			   = 9,
	JOYDRIVE_BUTTON_BACKWARDS		   = 10;

	//Axes
	public static final int
	JOYDRIVE_AXIS_DRIVE_LEFT		 = 1,
	JOYDRIVE_AXIS_DRIVE_RIGHT		 = 5;


	//PWM Ports
	public static final int
	PORT_MOTOR_DRIVE_LEFT_1 			= 20,
	PORT_MOTOR_DRIVE_LEFT_2 			= 21,
	PORT_MOTOR_DRIVE_LEFT_3 			= 22,
	PORT_MOTOR_DRIVE_RIGHT_1 			= 10,
	PORT_MOTOR_DRIVE_RIGHT_2 			= 11,
	PORT_MOTOR_DRIVE_RIGHT_3 			= 12;
	// Analog ports
	public static final int  PORT_STRINGPOT		  = 0;

	//Digital I/O Ports
	public static final int
	PORT_ENCODER_DRIVE_RIGHT_1      =  6,
	PORT_ENCODER_DRIVE_RIGHT_2      =  7,
	PORT_ENCODER_DRIVE_LEFT_1       =  4,
	PORT_ENCODER_DRIVE_LEFT_2       =  5;

	//Relay
	public static final int PORT_RELAY_COMPRESSOR = 0;

	//Solenoids
	public static final int
	PORT_SHIFT_DRIVE_HIGH	  		= 0,
	PORT_SHIFT_DRIVE_LOW			= 1,
	PORT_SHIFT_HANG_ON		 	 	= 2,
	PORT_SHIFT_HANG_OFF				= 3;

}