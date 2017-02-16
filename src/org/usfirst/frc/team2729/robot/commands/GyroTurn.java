package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command {
	
	double _turnPower;
	double _targetAngle;
	double gyroInitAngle;

	public GyroTurn (double turnPower, double targetAngle) {
		requires(Robot.driveTrain);
		_turnPower = turnPower;
		_targetAngle = targetAngle;
	}
	
	@Override
	protected void initialize() {
		System.err.println("Init Gyro turn");
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.speedControl();
		Robot.driveTrain.resetGyro();
		gyroInitAngle = Robot.driveTrain.getGyroAngle();
		_targetAngle += gyroInitAngle;
	}
	
	protected void execute() {
		System.err.println("Execute Gyro turn");
		if (_targetAngle > 0) {			
				System.err.println("Execute Gyro turn");

				Robot.driveTrain.tankDrive(-_turnPower, _turnPower);//negative sign for turning
		}
		
		if (_targetAngle < 0) {
				System.err.println("Execute Gyro turn");

				Robot.driveTrain.tankDrive(_turnPower, -_turnPower);//negative sign for turning
		}
	}
	
	protected void end() {
		System.err.println("End Gyro turn");
		Robot.driveTrain.tankDrive(0, 0);
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.resetGyro();
		Robot.driveTrain.percentVbusControl();
	}

	protected void interrupted() {
		System.err.println("Interrupted turn");
		end();
	}
	
	@Override
	protected boolean isFinished() {
		if(Math.abs(Robot.driveTrain.getGyroAngle() - _targetAngle) <= 1) {
			return true;}
		return false;
	}
	
}