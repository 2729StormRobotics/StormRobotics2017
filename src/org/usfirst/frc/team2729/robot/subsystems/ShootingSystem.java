package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ShootingSystem extends Subsystem {

	private final CANTalon _shoot = new CANTalon(RobotMap.PORT_MOTOR_SHOOT);
	
	@Override
	protected void initDefaultCommand() {
		
	}

	public ShootingSystem() {
		
	}
}
