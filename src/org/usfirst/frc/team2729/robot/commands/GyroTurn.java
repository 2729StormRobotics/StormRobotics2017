package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command {
	double gyroInitAngle;

	public GyroTurn () {
		requires(Robot.driveTrainPID);
	}
	public void turn(double turnPower, double targetAngle) {
		initialize();
		execute(turnPower, targetAngle);
		end();
	}
	@Override
	protected void initialize() {
		System.err.println("Init Gyro turn");
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.percentVbusControl();
		Robot.driveTrain.resetGyro();
		gyroInitAngle = Robot.driveTrain.getGyroAngle();
		//targetAngle += gyroInitAngle;
	}
	
	protected void execute(double turnPower, double targetAngle) {
		System.err.println("Execute Gyro turn");
		if (targetAngle > 0) {			
			while(Robot.driveTrain.getGyroAngle() <= targetAngle) {
			
				System.err.println("Execute Gyro turn");

				Robot.driveTrain.tankDrive(-turnPower, turnPower);//negative sign for turning
			}
			
		}
		
		if (targetAngle < 0) {			
			while(Robot.driveTrain.getGyroAngle() >= targetAngle) {
			
				System.err.println("Execute Gyro turn");

				Robot.driveTrain.tankDrive(turnPower, -turnPower);//negative sign for turning
			}
		}
	}
	protected void end() {
		System.err.println("End Gyro turn");
		Robot.driveTrain.tankDrive(0, 0);
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		Robot.driveTrain.resetGyro();
	}

	protected void interrupted() {
		System.err.println("Interrupted turn");
		end();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
}