package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainPID extends Subsystem {

	private final CANTalon _leftMain = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_MAIN);
	private final CANTalon _left2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_2);
	private final CANTalon _left3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_3);
	private final CANTalon _rightMain = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_MAIN);
	private final CANTalon _right2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_2);
	private final CANTalon _right3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_3);

	private final AnalogGyro _gyro = new AnalogGyro(RobotMap.PORT_SENSOR_GYRO);

	public DriveTrainPID() {
		
		double valueP = 0.2,
				valueI = 0.001,
				valueD = 0,
				valueF = 1;
		
		_leftMain.changeControlMode(CANTalon.TalonControlMode.Speed);
		_leftMain.set(0);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.Speed);
		_rightMain.set(0);
		_left2.changeControlMode(CANTalon.TalonControlMode.Follower);
		_left2.set(_leftMain.getDeviceID());
		_left3.changeControlMode(CANTalon.TalonControlMode.Follower);
		_left3.set(_leftMain.getDeviceID());		
		_right2.changeControlMode(CANTalon.TalonControlMode.Follower);
		_right2.set(_rightMain.getDeviceID());		
		_right3.changeControlMode(CANTalon.TalonControlMode.Follower);
		_right3.set(_rightMain.getDeviceID());

		_leftMain.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		_rightMain.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		_leftMain.configNominalOutputVoltage(+0.0f, -0.0f);
		_leftMain.configPeakOutputVoltage(+12.0f, -12.0f);
		_leftMain.setProfile(0);
		_leftMain.setF(valueF);
		_leftMain.setP(valueP);
		_leftMain.setI(valueI);
		_leftMain.setD(valueD);
		_rightMain.configNominalOutputVoltage(+0.0f, -0.0f);
		_leftMain.configEncoderCodesPerRev(256);
		_rightMain.configEncoderCodesPerRev(256);		
		_rightMain.configPeakOutputVoltage(+12.0f, -12.0f);
		_rightMain.setProfile(0);
		_rightMain.setF(valueF);
		_rightMain.setP(valueP);
		_rightMain.setI(valueI);
		_rightMain.setD(valueD);
		_leftMain.setVoltageRampRate(6.0);
		_rightMain.setVoltageRampRate(5.0);		
		resetLeftEnc();
		resetRightEnc();
		_gyro.initGyro();
		resetGyro();
		
	}

	@Override
	public void initDefaultCommand() {
	}

/*	public void halveOne(boolean half) {
		_halfOne = half;
	}

	public void halveTwo(boolean half) {
		_halfTwo = half;
	}
*/
	public void halt() {
		_leftMain.set(0);
		_rightMain.set(0);
	}

	public void tankDrive(double left, double right) {
//		_leftMain.set(-((left) - (_halfOne ? (left / 3) : 0) - (_halfTwo ? (left / 3) : 0)));
//		_rightMain.set((right) - (_halfOne ? (right / 3) : 0) - (_halfTwo ? (right / 3) : 0));
		_leftMain.set(-left);
		_rightMain.set(right);
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
	
	public double getGyroAngle() {
		return _gyro.getAngle();
	}

	
	public void resetGyro() {
		_gyro.reset();
	}

	public void resetLeftEnc() {
		_leftMain.setEncPosition(0);
	}

	public void speedControl() {
		_leftMain.changeControlMode(CANTalon.TalonControlMode.Speed);
		_leftMain.set(0);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.Speed);
		_rightMain.set(0);
	}

	public void percentVbusControl() {
		_leftMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_leftMain.set(0);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_rightMain.set(0);
	}

	public void resetRightEnc() {
		_rightMain.setEncPosition(0);
	}

	// public boolean getPTO(){
	// return _isPTOEnabled;
	// }
}