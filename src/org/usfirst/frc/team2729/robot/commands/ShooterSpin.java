package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterSpin extends Command {

	private final double _power;
	
	public ShooterSpin(double power) {
		_power = power;
		requires(Robot.shoot);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.shoot.shootSpin(_power);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
