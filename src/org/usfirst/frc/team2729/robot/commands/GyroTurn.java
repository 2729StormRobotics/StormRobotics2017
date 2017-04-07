package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GyroTurn extends Command {
	
	double _turnPower;
	double _targetAngle;
	double _initTurnPower;
	double _initTargetAngle;
	double gyroInitAngle;
	NetworkTable table;

	public GyroTurn (double turnPower, double targetAngle) {
		requires(Robot.driveTrain);
//		table = NetworkTable.getTable("Vision");
		
		_initTurnPower = turnPower;
		_initTargetAngle = targetAngle;
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.resetGyro();
		
	}
	
	@Override
	protected void initialize() {
//		_targetAngle = table.getNumber("p_angle", 0);
		_turnPower = _initTurnPower;
		_targetAngle = _initTargetAngle;
		System.err.println("Init Gyro turn");
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.resetGyro();
		gyroInitAngle = Robot.driveTrain.getGyroAngle();
		
		_targetAngle += gyroInitAngle;
		Robot.driveTrain.speedControl();
	}
	
	protected void execute() {
		System.err.println("Execute Gyro turn");
		if (Math.abs(Robot.driveTrain.getGyroAngle() - _targetAngle) <= 10) {
			if (_turnPower > 0) {
				_turnPower = 100;
			}
			if (_turnPower < 0) {
				_turnPower = -100;
			}
		}
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
		//if(Math.abs(Robot.driveTrain.getGyroAngle() - _targetAngle) <= 5) {
			//return true;}
		if(_targetAngle > 0) {
			if(Robot.driveTrain.getGyroAngle() >=  _targetAngle) {
				Robot.driveTrain.tankDrive(0, 0);
				return true;
			}
		}
		else {
			if(Robot.driveTrain.getGyroAngle() <=  _targetAngle) {
				Robot.driveTrain.tankDrive(0, 0);
				return true;
			}
		}
		return false;
	}
	
}