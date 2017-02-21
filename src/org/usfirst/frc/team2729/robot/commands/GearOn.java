package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearOn extends Command {
	
	private final boolean _on;

	public GearOn(boolean on) {
		requires(Robot.gear);
		_on = on;
	}
	
	@Override
	protected void initialize() {
		Robot.gear.setHighGear(_on);
		
	}
	
	@Override
	protected void execute() {
		if (Robot.gear.getHighGear() != _on) {
			Robot.gear.setHighGear(_on);
		}
		if(_on) {
			Robot.leds.ledGearOn = true;
		}
		else {
			Robot.leds.ledGearOn = false;
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
