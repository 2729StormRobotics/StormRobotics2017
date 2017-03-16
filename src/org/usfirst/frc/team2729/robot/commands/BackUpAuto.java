package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BackUpAuto extends Command{

	public BackUpAuto() {		
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.tankDrive(0.3, 0.3);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		System.err.println("End backup");
		
		Robot.driveTrain.tankDrive(0, 0);
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
	}

	@Override
	protected void interrupted() {
		System.err.println("Interrupted backup");
		end();
	}
	
}
