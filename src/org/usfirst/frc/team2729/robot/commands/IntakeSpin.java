package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeSpin extends Command {

	public IntakeSpin() {
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		double power = Robot.oi.getIntake();
		Robot.intake.intakeSpinner(power);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.intake.halt();
	}
	
	@Override
	protected void interrupted() {
		Robot.intake.halt();
	}

}
