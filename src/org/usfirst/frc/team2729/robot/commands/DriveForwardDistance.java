package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardDistance extends Command {

	double _leftSpeed;
	double _rightSpeed;
	final double _distanceL;
	final double _distanceR;

	public DriveForwardDistance(double speed, double distanceL, double distanceR) {
		requires(Robot.driveTrain);
		_leftSpeed = speed;
		_rightSpeed = speed;
		_distanceL = distanceL;
		_distanceR = distanceR;
	}

	@Override
	protected void initialize() {
		System.err.println("Init drive forward distance");
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.speedControl();
	}

	protected void execute() {
		System.err.println("Execute drive forward distance");
		// Robot.driveTrain.tankDrive(_powerLeft*1.1, _powerRight*1.05);
		Robot.driveTrain.tankDrive(_leftSpeed, _rightSpeed);
		SmartDashboard.putNumber("distance traveled",
				Math.max(Robot.driveTrain.getLeftDistance(), Robot.driveTrain.getRightDistance()));
		SmartDashboard.putNumber("Distance", _distanceL);

		// theoretically, this should print out current velocity of both wheels
		SmartDashboard.putNumber("LeftEncVelocity", Robot.driveTrain.getLeftSpeedEnc());
		SmartDashboard.putNumber("RightEncVelocity", Robot.driveTrain.getRightSpeedEnc());
		SmartDashboard.putNumber("LeftSpeed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("RightSpeed", Robot.driveTrain.getRightSpeed());

		
		if (Robot.driveTrain.getLeftDistance() >= _distanceL) {
			System.err.println("Done left!");
			_leftSpeed = 0;
		}
		if (Robot.driveTrain.getRightDistance() >= _distanceR) {
			System.err.println("Done right!");
			_rightSpeed = 0;
		}

	}

	protected boolean isFinished() {

		if (Robot.driveTrain.getLeftDistance() >= _distanceL && Robot.driveTrain.getRightDistance() >= _distanceR) {
			System.err.println("Done auto!");
			return true;
		} else {
			return false;
		}

	}

	protected void end() {
		System.err.println("End drive forward distance");
		Robot.driveTrain.tankDrive(0, 0);
		Robot.driveTrain.percentVbusControl();
	}

	protected void interrupted() {
		System.err.println("Interrupted drive forward distance");
		end();
	}

}
