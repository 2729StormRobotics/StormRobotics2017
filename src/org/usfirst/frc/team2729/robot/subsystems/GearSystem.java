package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSystem extends Subsystem {
	
	private final CANTalon _gear = new CANTalon(RobotMap.PORT_MOTOR_GEAR);
	private final DoubleSolenoid _gearShifter = new DoubleSolenoid(RobotMap.PORT_SHIFT_GEAR_ON, RobotMap.PORT_SHIFT_GEAR_OFF);
	
	private boolean _isHighGear = false;

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public GearSystem(){
		_gearShifter.set(DoubleSolenoid.Value.kForward);
		_isHighGear = false;
	}
	
	public void setHighGear(boolean enabled) {
		_isHighGear  = enabled;
		_gearShifter.set(enabled ? DoubleSolenoid.Value.kReverse
				: DoubleSolenoid.Value.kForward);
	}
	
	public boolean getHighGear(){
		return _isHighGear;
	}
	
}