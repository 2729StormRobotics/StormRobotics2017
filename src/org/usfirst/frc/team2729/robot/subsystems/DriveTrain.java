package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.commands.TankDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private final CANTalon _left1 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_1),
			_left2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_2),
			_left3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_LEFT_3),
			_right1 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_1),
			_right2 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_2),
			_right3 = new CANTalon(RobotMap.PORT_MOTOR_DRIVE_RIGHT_3);
	private final Encoder _leftEncoder = new Encoder(RobotMap.PORT_ENCODER_DRIVE_LEFT_1, RobotMap.PORT_ENCODER_DRIVE_LEFT_2),
			_rightEncoder = new Encoder(RobotMap.PORT_ENCODER_DRIVE_RIGHT_1, RobotMap.PORT_ENCODER_DRIVE_RIGHT_2);
			private final DoubleSolenoid _shifter = new DoubleSolenoid(RobotMap.PORT_SHIFT_DRIVE_HIGH, RobotMap.PORT_SHIFT_DRIVE_LOW);

			private boolean _halfOne = false, _halfTwo = false;
			private boolean _isHighGear = false;
			private boolean _isPTOEnabled = false;

			
			public DriveTrain(){
				_shifter.set(DoubleSolenoid.Value.kForward);
				_isHighGear = false;
			}

			@Override
			public void initDefaultCommand() {
				setDefaultCommand(new TankDrive());
			}

			public void halveOne(boolean half){
				_halfOne = half;
			}

			public void halveTwo(boolean half){
				_halfTwo = half;
			}

			public void halt() {
				_left1.set(0);
				_right1.set(0);
				_left2.set(0);
				_right2.set(0);
				_left3.set(0);
				_right3.set(0);
			}

			public void tankDrive(double left, double right){
			//	_left1.set((left) - (_halfOne ? (left/3) : 0) - (_halfTwo ? (left/3) : 0));
				_left1.set(left);
				_left2.set(left);
				_left3.set(left);
				_right1.set(right);
				_right2.set(right);
				_right3.set(right);
			//	_right.set((right) - (_halfOne ? (right/3) : 0) - (_halfTwo ? (right/3) : 0));
			}

			public double getLeftDistance(){
				return _leftEncoder.get();
			}

			public double getRightDistance(){
				return -_rightEncoder.get();
			}

			public double getLeftSpeedEnc() {
				return _leftEncoder.getRate();
			}

			public void resetLeftEnc() {
				_leftEncoder.reset();
			}

			public void resetRightEnc() {
				_rightEncoder.reset();
			}

			public double getRightSpeedEnc() {
				return -_rightEncoder.getRate();
			}

			public double getLeftSpeed() {
				return _left1.get();
			}

			public double getRightSpeed() {
				return _right1.get();
			}

			public void setHighGear(boolean enabled) {
				_isHighGear  = enabled;
				_shifter.set(enabled ? DoubleSolenoid.Value.kReverse
						: DoubleSolenoid.Value.kForward);
			}
			public boolean getHighGear(){
				return _isHighGear;
			}

			public boolean getPTO(){
				return _isPTOEnabled;
			}
}