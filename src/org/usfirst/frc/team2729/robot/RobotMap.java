package org.usfirst.frc.team2729.robot;

public class RobotMap {
	
	public static final int
	PORT_JOYSTICK_DRIVE 			= 4,
	PORT_JOYSTICK_ARMS  			= 0,
	PORT_JOYSTICK_DEBUG 			= 2;

	//Buttons
	public static final int
	JOYDRIVE_BUTTON_HALVE_1			   = 8,
	JOYDRIVE_BUTTON_HALVE_2			   = 7,
	JOYDRIVE_BUTTON_CENTERTURN		   = 3,
	JOYDRIVE_BUTTON_VISIONALIGN		   = 1,
	JOYDRIVE_BUTTON_FULLAUTO		   = 4,
	JOYARM_BUTTON_SHOOT_SPIN_ON		   = 4,
	JOYARM_BUTTON_SHOOT_SPIN_OFF	   = 3,
	JOYARM_BUTTON_SHOOT_SPIN_LOW	   = 7,
	JOYARM_BUTTON_SHOOT_FIRE		   = 6,
	JOYARM_BUTTON_SHOOT_FIRE_OFF	   = 5,
	JOYARM_BUTTON_SHIFT_GEAR_ON		   = 2,
	JOYARM_BUTTON_LIGHT_ON	  		   = 10,
	JOYARM_BUTTON_SHIFT_GEAR_OFF	   = 1,
	JOYARM_BUTTON_SHIFT_ONE_GEAR	   = 8;
	
	//Axes
	public static final int
	JOYDRIVE_AXIS_DRIVE_LEFT		 = 5,
	JOYDRIVE_AXIS_DRIVE_RIGHT		 = 1,
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
	PORT_MOTOR_HANG 					= 42,//Ambiguous port numbers
	PORT_MOTOR_INTAKE		 			= 30,
	PORT_MOTOR_SHOOT_FIRE		 		= 13,
	PORT_MOTOR_SHOOT_SPIN				= 0;

	// Analog ports
	public static final int
	PORT_STRINGPOT		  = 0;

	//Digital I/O Ports
	public static final int
	PORT_ENCODER_SHOOT_FIRE	        =  30,
	PORT_SENSOR_GYRO				=  1,
	PORT_MAJOR_LASER				=  0;

	//Relay
	public static final int
	PORT_RELAY_COMPRESSOR = 0;

	//Solenoids
	public static final int
	PORT_SHIFT_GEAR_ON_1		  	= 4,
	PORT_SHIFT_GEAR_OFF_1			= 5,
	PORT_SHIFT_GEAR_ON_2		  	= 6,
	PORT_SHIFT_GEAR_OFF_2			= 7;
	//PORT_SHIFT_GEAR_ON_3		  	= 4,
	//PORT_SHIFT_GEAR_OFF_3			= 5;
	
}