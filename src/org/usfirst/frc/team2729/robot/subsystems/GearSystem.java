package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.RobotMap;
import org.usfirst.frc.team2729.robot.commands.Gear;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSystem extends Subsystem {
	
	private final DoubleSolenoid _gearShifter = new DoubleSolenoid(RobotMap.PORT_SHIFT_GEAR_ON, RobotMap.PORT_SHIFT_GEAR_OFF);
	
	private boolean _isHighGear = false;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Gear(false));
	}
	
	public GearSystem(){
		_gearShifter.set(DoubleSolenoid.Value.kReverse);
		_isHighGear = false;
	}
	
	public void setHighGear(boolean enabled) {
		_isHighGear  = enabled;
		_gearShifter.set(enabled ? DoubleSolenoid.Value.kForward
				: DoubleSolenoid.Value.kReverse);
	}
	
	public boolean getHighGear(){
		return _isHighGear;
	}
	
}