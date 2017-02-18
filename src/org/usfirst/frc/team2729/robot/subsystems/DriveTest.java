package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTest extends Subsystem{
	private final CANTalon _leftMain = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_MAIN);
	private final CANTalon _left2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_2);
	private final CANTalon _left3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_3);
	private final CANTalon _rightMain = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_MAIN);
	private final CANTalon _right2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_2);
	private final CANTalon _right3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_3);
	
	private boolean _halfOne = false;
	private boolean _halfTwo = false;
public DriveTest() {
		
		_leftMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_leftMain.set(0);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_rightMain.set(0);
		_left2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_left2.set(0);
		_right2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_right2.set(0);
		_left3.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_left3.set(0);
		_right3.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_right3.set(0);
		
		_leftMain.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		_rightMain.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
}
@Override
public void initDefaultCommand() {
	setDefaultCommand(new TankDrive());
}

public void halveOne(boolean half) {
	_halfOne = half;
}

public void halveTwo(boolean half) {
	_halfTwo = half;
}

public void halt() {
	_leftMain.set(0);
	_rightMain.set(0);
}

public void tankDrive(double left, double right) {
	_leftMain.set(-((left) - (_halfOne ? (left / 3) : 0) - (_halfTwo ? (left / 3) : 0)));
	_rightMain.set((right) - (_halfOne ? (right / 3) : 0) - (_halfTwo ? (right / 3) : 0));
	_left2.set(-((left) - (_halfOne ? (left / 3) : 0) - (_halfTwo ? (left / 3) : 0)));
	_right2.set((right) - (_halfOne ? (right / 3) : 0) - (_halfTwo ? (right / 3) : 0));
	_left3.set(-((left) - (_halfOne ? (left / 3) : 0) - (_halfTwo ? (left / 3) : 0)));
	_right3.set((right) - (_halfOne ? (right / 3) : 0) - (_halfTwo ? (right / 3) : 0));
}

public double getLeftDistance() {
	return -_leftMain.getEncPosition();
}

public double getRightDistance() {
	return _rightMain.getEncPosition();
}

public int getLeftSpeedEnc() {
	return -_leftMain.getEncVelocity();
}

public int getRightSpeedEnc() {
	return _rightMain.getEncVelocity();
}

public double getLeftSpeed() {
	return -_leftMain.getSpeed();
}

public double getRightSpeed() {
	return _rightMain.getSpeed();
}


}
