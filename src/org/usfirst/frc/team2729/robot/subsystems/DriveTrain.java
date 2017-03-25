package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private static final CANTalon _leftMain = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_MAIN);
	private static final CANTalon _left2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_2);
	private static final CANTalon _left3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_3);
	private static final CANTalon _rightMain = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_MAIN);
	private static final CANTalon _right2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_2);
	private static final CANTalon _right3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_3);

	private static final AnalogGyro _gyro = new AnalogGyro(RobotMap.PORT_SENSOR_GYRO);
	
//	private static final double valueP = 1.0; //used to be 0.02
//	private static final double valueI = 0.001;
//	private static final double valueD = 2.0;
//	private static final double valueF = 1;
	
//	private static final double LvalueP = Preferences.getInstance().getDouble("LDriveTrain P", 0); //used to be 0.02
//	private static final double LvalueI = Preferences.getInstance().getDouble("LDriveTrain I", 0);
//	private static final double LvalueD = Preferences.getInstance().getDouble("LDriveTrain D", 0);
//	private static final double LvalueF = Preferences.getInstance().getDouble("LDriveTrain F", 0);
//	
//	private static final double RvalueP = Preferences.getInstance().getDouble("RDriveTrain P", 0); //used to be 0.02
//	private static final double RvalueI = Preferences.getInstance().getDouble("RDriveTrain I", 0);
//	private static final double RvalueD = Preferences.getInstance().getDouble("RDriveTrain D", 0);
//	private static final double RvalueF = Preferences.getInstance().getDouble("RDriveTrain F", 0);
	
	private static double LvalueP = 0.504; //used to be 0.02
	private static double LvalueI = 0;
	private static double LvalueD = 0;
	private static double LvalueF = 0;
	
	private static double RvalueP = 0.48; //used to be 0.02
	private static double RvalueI = 0;
	private static double RvalueD = 0;
	private static double RvalueF = 0;

	private boolean _halfOne = false;
	private boolean _halfTwo = false;
	
	private double mult = 2.5;
	// private boolean _isPTOEnabled = false;

	public DriveTrain() {		
		_leftMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_leftMain.set(0);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
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
		
		resetLeftEnc();
		resetRightEnc();
		_gyro.initGyro();
		resetGyro();
		
	}

	public static double getLvalueP() {
		return _leftMain.getP();
		//return LvalueP;
	}

	public static double getLvalueI() {
		return _leftMain.getI();
	}

	public static double getLvalueD() {
		return _leftMain.getD();
	}

	public static double getRvalueP() {
		return _rightMain.getP();
	}

	public static double getRvalueI() {
		return _rightMain.getI();
	}

	public static double getRvalueD() {
		return _rightMain.getD();
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
	
	public boolean getHalfOne() {
		return _halfOne;
	}
	
	public boolean getHalfTwo() {
		return _halfTwo;
	}

	public void tankDrive(double left, double right) {
		_leftMain.set(((left) - (_halfOne ? (left / 3) : 0) - (_halfTwo ? (left / 3) : 0)) * mult);
		_rightMain.set((-(right) - (_halfOne ? (right / 3) : 0) - (_halfTwo ? (right / 3) : 0)) * mult);
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
	
	
	public static void setLvalueP(double lvalueP) {
		LvalueP = lvalueP;
		_leftMain.setP(LvalueP);
	}

	public static void setLvalueI(double lvalueI) {
		LvalueI = lvalueI;
		_leftMain.setI(LvalueI);
	}

	public static void setLvalueD(double lvalueD) {
		LvalueD = lvalueD;
		_leftMain.setD(LvalueD);
	}

	public static void setRvalueP(double rvalueP) {
		RvalueP = rvalueP;
		_rightMain.setP(RvalueP);
	}

	public static void setRvalueI(double rvalueI) {
		RvalueI = rvalueI;
		_rightMain.setI(RvalueI);
	}

	public static void setRvalueD(double rvalueD) {
		RvalueD = rvalueD;
		_rightMain.setD(RvalueD);
	}

	public void resetGyro() {
		_gyro.reset();
	}
	
	public void resetEnc() {
		_leftMain.setEncPosition(0);
		_rightMain.setEncPosition(0);
	}

	public void resetLeftEnc() {
		_leftMain.setEncPosition(0);
	}
	
	public boolean encoderEnabledRight() {
		if(Math.abs(_rightMain.getEncVelocity()) > 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean encoderEnabledLeft() {
		if(Math.abs(_leftMain.getEncVelocity()) > 10) {
			return true;
		}
		else {
			return false;
		}
	}

	public void speedControl() {
		System.err.println("Speed Control!");
		
		_leftMain.changeControlMode(CANTalon.TalonControlMode.Speed);
		_leftMain.set(0);
		_leftMain.reverseSensor(true);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.Speed);
		_rightMain.set(0);
		_rightMain.reverseSensor(true);
		
		// speed control is being weird. Uncomment one at a time
		//_leftMain.configNominalOutputVoltage(+0.0f, -0.0f);
		//_leftMain.configPeakOutputVoltage(+12.0f, -12.0f);
		_leftMain.setProfile(0);
		_leftMain.setF(LvalueF);
		_leftMain.setP(LvalueP);
		_leftMain.setI(LvalueI);
		_leftMain.setD(LvalueD);
		//_rightMain.configNominalOutputVoltage(+0.0f, -0.0f);
		_leftMain.configEncoderCodesPerRev(256);
		_rightMain.configEncoderCodesPerRev(256);		
		//_rightMain.configPeakOutputVoltage(+12.0f, -12.0f);
		_rightMain.setProfile(0);
		_rightMain.setF(RvalueF);
		_rightMain.setP(RvalueP);
		_rightMain.setI(RvalueI);
		_rightMain.setD(RvalueD);
		//_leftMain.setVoltageRampRate(6.0);
		//_rightMain.setVoltageRampRate(6.0);
	}

	public void percentVbusControl() {
		System.err.println("VBus Control!");
		_leftMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_leftMain.set(0);
		_rightMain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_rightMain.set(0);
	}
	
	public void resetRightEnc() {
		_rightMain.setEncPosition(0);
	}
	
	public String getDriveTrainControlMode() {
		return _leftMain.getControlMode().name();
	}
	
	public boolean isDriveTrainPID() {
		return _leftMain.getControlMode().isPID();
	}
	
	public void setBrakeMode() {
		_leftMain.enableBrakeMode(true);
		_rightMain.enableBrakeMode(true);
	}
	
	public void setCoastMode() {
		_leftMain.enableBrakeMode(false);
		_rightMain.enableBrakeMode(false);
	}


	// public boolean getPTO(){
	// return _isPTOEnabled;
	// }
}