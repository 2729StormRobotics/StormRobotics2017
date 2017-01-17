package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSystem extends Subsystem {

	private final CANTalon _intake = new CANTalon(RobotMap.PORT_MOTOR_INTAKE);
	
	@Override
	protected void initDefaultCommand() {
		
	}

	public IntakeSystem() {
		
	}
}
