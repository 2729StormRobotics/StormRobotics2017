package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.util.HallEffectSensor;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShootingSystem extends Subsystem {
	
	//private FeedbackDevice _fireSensor = new FeedbackDevice(RobotMap.PORT_ENCODER_SHOOT_FIRE);
	private final CANTalon _spin = new CANTalon(RobotMap.PORT_MOTOR_SHOOT_SPIN);	
	private final CANTalon _fire = new CANTalon(RobotMap.PORT_MOTOR_SHOOT_FIRE);
	private final Relay light = new Relay(0, Relay.Direction.kForward);
	
	//Encoder enc;
	//enc = new Encoder(0,1,false,Encoder.EncodingType,k4x);
	
	public ShootingSystem() {
//		_fire.changeControlMode(CANTalon.TalonControlMode.Speed);
//		_fire.set(0);
//		_fire.reverseSensor(false);
//		_fire.setFeedbackDevice(FeedbackDevice.EncRising);
//	
//		_fire.configEncoderCodesPerRev(4);
//		resetEnc();
//		_fire.configPeakOutputVoltage(+12.0f, -12.0f);
//		_fire.configNominalOutputVoltage(+0.0f, -0.0f);		
//		double  valueF = 1,
//				valueP = 0.2,
//				valueI = 0.001,
//				valueD = 0;
//		_fire.setProfile(0);
//		_fire.setF(valueF);
//		_fire.setP(valueP);
//		_fire.setI(valueI);
//		_fire.setD(valueD);
//		_fire.setVoltageRampRate(6.0);
		lightOff();
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public void halt(){
		_spin.set(0);
		_fire.set(0);
	}
	
	public void shootFire(double speed){
		
		_fire.changeControlMode(CANTalon.TalonControlMode.Speed);
		_fire.set(0);
		_fire.reverseSensor(false);
		_fire.setFeedbackDevice(FeedbackDevice.EncRising);
		_fire.configEncoderCodesPerRev(4);
		resetEnc();
		_fire.configPeakOutputVoltage(+12.0f, -12.0f);
		_fire.configNominalOutputVoltage(+0.0f, -0.0f);		
//		double  valueF = 1,
//				//valueP = 90,
//				valueP = 90,
//				valueI = 0,
//				valueD = 2;
		
		double valueP,
				valueI,
				valueD,
				valueF;
		
		valueP = Preferences.getInstance().getDouble("Shooter P", 90);
		valueI = Preferences.getInstance().getDouble("Shooter I", 0);
		valueD = Preferences.getInstance().getDouble("Shooter D", 2);
		valueF = Preferences.getInstance().getDouble("Shooter F", 1);
		
		_fire.setProfile(0);
		_fire.setF(valueF);
		_fire.setP(valueP);
		_fire.setI(valueI);
		_fire.setD(valueD);
		
//		_fire.setVoltageRampRate(6.0);
//		double P;
//		double I;
//		double D;
//		double F;
		
//		P = Preferences.getInstance().getDouble("Shooter P", .2);
//		I = Preferences.getInstance().getDouble("Shooter I", .0015);
//		D = Preferences.getInstance().getDouble("Shooter D", 0);
//		F = Preferences.getInstance().getDouble("Shooter F", 1);
//		
//		if((P < 0) || (P > 1)) {
//			P = .2;
//		}
//		
//		if((I < 0) || (I > 1)) {
//			I = .001;
//		}
//		
//		if((D < 0) || (D > 1)) {
//			D = 0;
//		}
//		
//		if((F < 0) || (F > 1)) {
//			F = 1;
//		}
		
//		P = .2;
//		I = .0015;
//		D = 0;
//		F = 1;
//		
//		_fire.setF(F);
//		_fire.setP(P);
//		_fire.setI(I);
//		_fire.setD(D);
//		
		_fire.set(speed);
	}
	
	public void shootSpin(double power) {
		_spin.set(power);
	}
	
	public int getShootFireDistance() {
		return _fire.getEncPosition();
	}
	
	public int getShootFireSpeedEnc() {
		return _fire.getEncVelocity();
	}
	
	public double getShootFireSpeed() {
		return _fire.getSpeed();
	}
	
	public void resetEnc() {
		_fire.setEncPosition(0);
	}
	
	public String getShootFireMode() {
		return _fire.getControlMode().name();
	}
	
	public boolean isShootFirePID() {
		return _fire.getControlMode().isPID();
	}
	
	public void lightOn() {
		light.set(Relay.Value.kForward);
	}
	
	public void lightOff() {
		light.set(Relay.Value.kOff);
	}
}
