package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {
	
	final double _power;
	final double _time;
	Timer _timer;

	public DriveForward(double power, double time) {
		requires(Robot.driveTrain);
		_timer = new Timer();
		_power = power;
		_time = time;
		
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.resetLeftEnc();
		Robot.driveTrain.resetRightEnc();
		_timer.start();
		
	}
	
	protected void execute() {
		Robot.driveTrain.tankDrive(_power*1.1, _power);
		SmartDashboard.putDouble("Timer", _timer.get());
		SmartDashboard.putDouble("Time", _time);
	}
	
	protected boolean isFinished() {

		if (_timer.get() > _time) {
			return true;
		}
		else {return false;}
	}
	
	protected void end() {
		Robot.driveTrain.tankDrive(0, 0);
	}
	
	protected void interrupted() {
		end();
	}

}
