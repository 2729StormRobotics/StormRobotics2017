package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HangingSystem extends Subsystem {

	private final CANTalon _hang = new CANTalon(RobotMap.PORT_MOTOR_HANG);
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public HangingSystem() {
		
	}
}
