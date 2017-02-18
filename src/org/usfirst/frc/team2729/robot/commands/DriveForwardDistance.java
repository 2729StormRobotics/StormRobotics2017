package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardDistance extends Command {

	volatile double  _leftSpeed;
	volatile double _rightSpeed;
	volatile double _distanceL;
	volatile double _distanceR;
	private static final double TICKSPERMETER = 3260;
	NetworkTable table;

	
	public DriveForwardDistance(double speed, double distanceL, double distanceR) {
		requires(Robot.driveTrain);
		_leftSpeed = speed*1.15;
		_rightSpeed = speed;
		_distanceL = distanceL*TICKSPERMETER;
		_distanceR = distanceR*TICKSPERMETER;
//		Robot.driveTrain.speedControl();
		Robot.driveTrain.percentVbusControl();
	}

	@Override
	protected void initialize() {
		table = NetworkTable.getTable("Console");
		table.putBoolean("Forward", true);
		System.err.println("Init drive forward distance");
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.resetGyro();
		Robot.driveTrain.percentVbusControl();
	}

	@Override
	protected void execute() {
		System.err.println("Execute drive forward distance");
		// Robot.driveTrain.tankDrive(_powerLeft*1.1, _powerRight*1.05);
		//if (!Robot.driveTrain.isDriveTrainPID()) {
		//	Robot.driveTrain.speedControl();
		//}
		Robot.driveTrain.tankDrive(_leftSpeed, _rightSpeed);//negative sign for turning
		SmartDashboard.putNumber("distance traveled",
				Math.max(Robot.driveTrain.getLeftDistance(), Robot.driveTrain.getRightDistance()));
		SmartDashboard.putNumber("Distance", _distanceL);

		// theoretically, this should print out current velocity of both wheels
		SmartDashboard.putNumber("LeftEncVelocity", Robot.driveTrain.getLeftSpeedEnc());
		SmartDashboard.putNumber("RightEncVelocity", Robot.driveTrain.getRightSpeedEnc());

		SmartDashboard.putNumber("LeftSpeed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("RightSpeed", Robot.driveTrain.getRightSpeed());		
		table.putNumber("_leftSpeed", _leftSpeed);
		table.putNumber("_rightSpeed", _rightSpeed);
		table.putNumber("_distanceLimitLeft", _distanceL);
		table.putNumber("_distanceLimitRight", _distanceR);
		table.putNumber("_encoderDistanceLeft", Robot.driveTrain.getLeftDistance());
		table.putNumber("_encoderDistanceRight", Robot.driveTrain.getRightDistance());
		
		if (Math.abs(Robot.driveTrain.getLeftDistance()) >= 0.5*Math.abs(_distanceL)) {
			if (_leftSpeed > 0) {
				_leftSpeed = 0.1;
			}
			if (_leftSpeed < 0) {
				_leftSpeed = -0.1;
			}
		}
		
		if (Math.abs(Robot.driveTrain.getRightDistance()) >= 0.5*Math.abs(_distanceR)) {
			if (_rightSpeed > 0) {
				_rightSpeed = 0.1;
			}
			if (_rightSpeed < 0) {
				_rightSpeed = -0.1;
			}
		}
		
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
			table.putBoolean("Forward", false);
			System.err.println("Done drive forward!");
			Robot.driveTrain.percentVbusControl();
			Robot.driveTrain.tankDrive(0, 0);
			_leftSpeed = 0;
			_rightSpeed = 0;
			SmartDashboard.putNumber("LeftEncVelocity", Robot.driveTrain.getLeftSpeedEnc());
			SmartDashboard.putNumber("RightEncVelocity", Robot.driveTrain.getRightSpeedEnc());

			SmartDashboard.putNumber("LeftSpeed", Robot.driveTrain.getLeftSpeed());
			SmartDashboard.putNumber("RightSpeed", Robot.driveTrain.getRightSpeed());		
			table.putNumber("_leftSpeed", _leftSpeed);
			table.putNumber("_rightSpeed", _rightSpeed);
			table.putNumber("_distanceLimitLeft", _distanceL);
			table.putNumber("_distanceLimitRight", _distanceR);
			table.putNumber("_encoderDistanceLeft", Robot.driveTrain.getLeftDistance());
			table.putNumber("_encoderDistanceRight", Robot.driveTrain.getRightDistance());
			return true;
		} else {
			return false;
		}

	}

	@Override
	protected void end() {
		System.err.println("End drive forward distance");
		
		Robot.driveTrain.tankDrive(0, 0);
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
	}

	@Override
	protected void interrupted() {
		System.err.println("Interrupted drive forward distance");
		end();
	}

}