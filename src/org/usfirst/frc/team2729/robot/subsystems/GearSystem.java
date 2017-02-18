package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.commands.GearOn;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSystem extends Subsystem {
	
	private static final DoubleSolenoid _gearShifter1 = new DoubleSolenoid(RobotMap.PORT_SHIFT_GEAR_ON_1, RobotMap.PORT_SHIFT_GEAR_OFF_1);
	private final DoubleSolenoid _gearShifter2 = new DoubleSolenoid(RobotMap.PORT_SHIFT_GEAR_ON_2, RobotMap.PORT_SHIFT_GEAR_OFF_2);
	//private final DoubleSolenoid _gearShifter3 = new DoubleSolenoid(RobotMap.PORT_SHIFT_GEAR_ON_3, RobotMap.PORT_SHIFT_GEAR_OFF_3);
	
	private static boolean _isGearOn;

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public GearSystem(){
		_gearShifter1.set(DoubleSolenoid.Value.kReverse);
		_gearShifter2.set(DoubleSolenoid.Value.kReverse);
		//_gearShifter3.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void setHighGear(boolean enabled) {
		_isGearOn = enabled;
		_gearShifter1.set(enabled ? DoubleSolenoid.Value.kForward
				: DoubleSolenoid.Value.kReverse);
		_gearShifter2.set(enabled ? DoubleSolenoid.Value.kForward
				: DoubleSolenoid.Value.kReverse);
	//	_gearShifter3.set(enabled ? DoubleSolenoid.Value.kForward
				//: DoubleSolenoid.Value.kReverse);
	}
	
	public boolean getHighGear(){
		return _isGearOn;
	}
	
}