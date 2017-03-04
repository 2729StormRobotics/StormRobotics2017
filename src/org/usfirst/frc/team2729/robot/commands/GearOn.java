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
			Robot.leds.ledGearOn = 0;
		}
		else {
			Robot.leds.ledGearOn = 1;
		}
	}
	
	@Override
	protected boolean isFinished() {
		if(Robot.gear.getHaltGear()){
			return true;
		}
		return false;
	}
	
	@Override
	protected void end() {
		
	}
	
	@Override
	protected void interrupted() {
		
	}
	
}
