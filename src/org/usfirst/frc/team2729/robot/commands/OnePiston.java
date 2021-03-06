package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OnePiston extends Command{

	private final boolean _on;
	
	public OnePiston(boolean on) {
		requires(Robot.gear);
		_on = on;
	}

	@Override
	protected void initialize() {
		Robot.gear.setOneGear(_on);

	}

	@Override
	protected void execute() {
		Robot.gear.setOneGear(_on);
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
		end();
	}

}
