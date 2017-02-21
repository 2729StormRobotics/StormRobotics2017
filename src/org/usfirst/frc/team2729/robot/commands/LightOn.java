package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LightOn extends Command {
	
	public LightOn() {
		requires(Robot.shoot);
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.shoot.lightOn();
	}
	
	@Override
	protected boolean isFinished() {
		
		return true;
	}

}
