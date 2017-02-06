package org.usfirst.frc.team2729.robot;

public class RobotMap {
	public static final int
	PORT_JOYSTICK_DRIVE 			= 4,
	PORT_JOYSTICK_ARMS  			= 3,
	PORT_JOYSTICK_DEBUG 			= 2;

	//Buttons
	public static final int
	JOYDRIVE_BUTTON_HALVE_1			   = 8,
	JOYDRIVE_BUTTON_HALVE_2			   = 7,
	JOYDRIVE_BUTTON_SHIFT_DRIVE_HIGH   = 12,
	JOYDRIVE_BUTTON_SHIFT_DRIVE_LOW    = 2,
	JOYARM_BUTTON_SHOOT_SPIN_ON		   = 3,
	JOYARM_BUTTON_SHOOT_SPIN_OFF	   = 2,
	JOYARM_BUTTON_SHOOT_FIRE		   = 6,
	JOYARM_BUTTON_SHOOT_FIRE_OFF	   = 8,
	JOYARM_BUTTON_SHIFT_GEAR_ON		   = 5,
	JOYARM_BUTTON_SHIFT_GEAR_OFF	   = 7; 
	
	//Axes
	public static final int
	JOYDRIVE_AXIS_DRIVE_LEFT		 = 1,
	JOYDRIVE_AXIS_DRIVE_RIGHT		 = 5,
	JOYAXIS_AXIS_INTAKE				 = 1,
	JOYAXIS_AXIS_HANG				 = 5;

	//CAN Ports
	public static final int
	PORT_MOTOR_DRIVE_LEFT_MAIN 			= 20,
	PORT_MOTOR_DRIVE_LEFT_2 			= 21,
	PORT_MOTOR_DRIVE_LEFT_3 			= 22,
	PORT_MOTOR_DRIVE_RIGHT_MAIN 		= 10,
	PORT_MOTOR_DRIVE_RIGHT_2 			= 11,
	PORT_MOTOR_DRIVE_RIGHT_3 			= 12,
	PORT_MOTOR_HANG 					= 1,//Ambiguous port numbers
	PORT_MOTOR_INTAKE		 			= 2,
	PORT_MOTOR_SHOOT_FIRE		 		= 30,
	PORT_MOTOR_SHOOT_SPIN				= 0;
	// Analog ports
	public static final int  PORT_STRINGPOT		  = 0;

	//Digital I/O Ports
	public static final int
	PORT_ENCODER_SHOOT_FIRE	        =  30,
	PORT_ENCODER_DRIVE_RIGHT_2      =  7,
	PORT_ENCODER_DRIVE_LEFT_1       =  4,
	PORT_ENCODER_DRIVE_LEFT_2       =  5;

	//Relay
	public static final int
	PORT_RELAY_COMPRESSOR = 0;

	//Solenoids
	public static final int
    PORT_SHIFT_DRIVE_HIGH			= 0,
    PORT_SHIFT_DRIVE_LOW			= 1,
	PORT_SHIFT_GEAR_ON		  		= 2,
	PORT_SHIFT_GEAR_OFF				= 3;

}