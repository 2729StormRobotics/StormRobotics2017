package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Gear extends Command {
	
	private boolean _on;

	public Gear(boolean on) {
		requires(Robot.gear);
		_on = on;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		if (Robot.gear.getHighGear() != _on) {
			Robot.gear.setHighGear(_on);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		
	}
	
	@Override
	protected void interrupted() {
		
	}
	
}
