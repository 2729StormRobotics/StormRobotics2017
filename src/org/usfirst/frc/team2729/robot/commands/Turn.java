package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turn extends Command {

	double _leftSpeed;
	double _rightSpeed;
	double _distanceL;
	double _distanceR;

	public Turn(double speed, double degrees) {
		requires(Robot.driveTrain);
		_leftSpeed = speed;
		_rightSpeed = speed;
		_distanceL = degrees/360*(-6361);
		_distanceR = degrees/360*(6383);
	}
	
	@Override
	protected void initialize() {
		System.err.println("Init turn");
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.speedControl();
	}
	
	protected void execute() {
		System.err.println("Execute turn");
		Robot.driveTrain.tankDrive(-_leftSpeed, _rightSpeed);//negative sign for turning
		SmartDashboard.putNumber("distance traveled",
				Math.max(Robot.driveTrain.getLeftDistance(), Robot.driveTrain.getRightDistance()));
		SmartDashboard.putNumber("Distance", _distanceL);

		// theoretically, this should print out current velocity of both wheels
		SmartDashboard.putNumber("LeftEncVelocity", Robot.driveTrain.getLeftSpeedEnc());
		SmartDashboard.putNumber("RightEncVelocity", Robot.driveTrain.getRightSpeedEnc());

		SmartDashboard.putNumber("LeftSpeed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("RightSpeed", Robot.driveTrain.getRightSpeed());		
		
		if (Math.abs(Robot.driveTrain.getLeftDistance()) >= Math.abs(_distanceL)) {
			System.err.println("Done left!");
			_leftSpeed = 0;
		}
		if (Math.abs(Robot.driveTrain.getRightDistance()) >= Math.abs(_distanceR)) {
			System.err.println("Done right!");
			_rightSpeed = 0;
		}

	}
	@Override
	protected boolean isFinished() {

		if (Math.abs(Robot.driveTrain.getLeftDistance()) >= Math.abs(_distanceL) && 
				Math.abs(Robot.driveTrain.getRightDistance()) >= Math.abs(_distanceR)) {
			System.err.println("Done turn!");
			return true;
		} else {
			return false;
		}

	}

	protected void end() {
		System.err.println("End turn");
		Robot.driveTrain.tankDrive(0, 0);
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
	}

	protected void interrupted() {
		System.err.println("Interrupted turn");
		end();
	}
}
