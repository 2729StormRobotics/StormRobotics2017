package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command {

	double _degrees;

	public Turn(double degrees) {
		requires(Robot.driveTrain);
		_degrees = degrees;
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
