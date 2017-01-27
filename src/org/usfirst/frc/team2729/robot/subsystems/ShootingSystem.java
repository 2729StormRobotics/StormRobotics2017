package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ShootingSystem extends Subsystem {

	private final CANTalon _spin = new CANTalon(RobotMap.PORT_MOTOR_SHOOT_SPIN);	
	private final CANTalon _fire = new CANTalon(RobotMap.PORT_MOTOR_SHOOT_FIRE);
	
	public ShootingSystem() {
		_fire.changeControlMode(TalonControlMode.Speed);
		_fire.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public void halt(){
		_spin.set(0);
		_fire.set(0);
	}
	
	public void shootFire(double speed){
		_fire.set(speed);
	}
	
	public void shootSpin(double power) {
		_spin.set(power);
	}
	
}
