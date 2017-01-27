package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		double left = Robot.oi.getLeftDrive()*1000,
				right = Robot.oi.getRightDrive()*1000;
		Robot.driveTrain.tankDrive(left, right);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrain.halt();
	}

	@Override
	protected void interrupted() {
		Robot.driveTrain.halt();
	}
}
