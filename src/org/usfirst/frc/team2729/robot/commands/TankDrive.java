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
		if (Robot.driveTrain.isDriveTrainPID()) {
			Robot.driveTrain.percentVbusControl();
		}
		double left = Robot.oi.getLeftDrive(),
				right = Robot.oi.getRightDrive();
		if(Math.abs(left - right) < 0.3) {
			left = (left + right)/2;
			right = left;
		}
		Robot.driveTrain.tankDrive(left * Math.abs(left), right * Math.abs(right));
		//Robot.leds.turnOn(Robot.leds.ledShoot);
	
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
