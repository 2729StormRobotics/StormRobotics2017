package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardPosition extends Command {

	private double _initLeftSpeed;
	private double _initRightSpeed;
	private double _initDistanceL;
	private double _initDistanceR;
	volatile double _leftSpeed;
	volatile double _rightSpeed;
	volatile double _distanceL;
	volatile double _distanceR;
	private static final double TICKSPERMETER = 3260;
	NetworkTable table;

	
	public DriveForwardPosition(double speed, double distanceL, double distanceR) {
		requires(Robot.driveTrainPID);
		_initLeftSpeed = speed*1.15;
		_initRightSpeed = speed;
		_initDistanceL = distanceL*TICKSPERMETER;
		_initDistanceR = distanceR*TICKSPERMETER;
		Robot.driveTrainPID.percentVbusControl();
		table = NetworkTable.getTable("Console");
	}

	@Override
	protected void initialize() {
		_leftSpeed = _initLeftSpeed;
		_rightSpeed = _initRightSpeed;
		_distanceL = _initDistanceL;
		_distanceR = _initDistanceR;
		
		table.putString("Done left", "No");
		table.putString("Done right", "No");
		table.putBoolean("Forward", true);
		System.err.println("Init drive forward distance");
		Robot.driveTrain.resetEnc();
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
				_leftSpeed = 0.15;
			}
			if (_leftSpeed < 0) {
				_leftSpeed = -0.15;
			}
		}
		
		if (Math.abs(Robot.driveTrain.getRightDistance()) >= 0.5*Math.abs(_distanceR)) {
			if (_rightSpeed > 0) {
				_rightSpeed = 0.15;
			}
			if (_rightSpeed < 0) {
				_rightSpeed = -0.15;
			}
		}
		
		if (Math.abs(Robot.driveTrain.getLeftDistance()) >= Math.abs(_distanceL)) {
			table.putString("Done left", "Yes");
			System.err.println("Done left!");
			_leftSpeed = 0;
		}
		if (Math.abs(Robot.driveTrain.getRightDistance()) >= Math.abs(_distanceR)) {
			table.putString("Done right", "Yes");
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