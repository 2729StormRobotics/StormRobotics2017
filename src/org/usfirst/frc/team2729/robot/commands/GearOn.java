package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GearOn extends Command {

	private boolean _on;
	private boolean _autonomous;
	NetworkTable table;

	public GearOn(boolean on, boolean autonomous) {
		table = NetworkTable.getTable("GearOn");
		requires(Robot.gear);
		_on = on;
		_autonomous = autonomous;
	}

	@Override
	protected void initialize() {
		//if (Robot.gear.getHighGear() != _on) {
			if (_autonomous) {
				if (!Robot.gear.getHaltGear()) {
					Robot.gear.setHighGear(_on);
				}
			} else {
				Robot.gear.setHighGear(_on);
			}
	//	}
	}

	@Override
	protected void execute() {
		table.putBoolean("Robot.gear.getHighGear()", Robot.gear.getHighGear());
		table.putBoolean("_on", _on);
		table.putBoolean("Robot.gear.getHaltGear()", Robot.gear.getHaltGear());
		table.putNumber("Robot.leds.ledGearOn", Robot.leds.getLedGearOn());
	//	if (Robot.gear.getHighGear() != _on) {
			if (_autonomous) {
				if (!Robot.gear.getHaltGear()) {
					Robot.gear.setHighGear(_on);
				}
			} else {
				Robot.gear.setHighGear(_on);
			}
	//	}

		if (_on) {
			Robot.leds.setLedGearOn(0);
		} else {
			Robot.leds.setLedGearOn(1);
		}
		table.putBoolean("Robot.gear.getHighGear()", Robot.gear.getHighGear());
		table.putBoolean("_on", _on);
		table.putBoolean("Robot.gear.getHaltGear()", Robot.gear.getHaltGear());
		table.putNumber("Robot.leds.ledGearOn", Robot.leds.getLedGearOn());
	}

	@Override
	protected boolean isFinished() {
		table.putBoolean("Robot.gear.getHighGear()", Robot.gear.getHighGear());
		table.putBoolean("_on", _on);
		table.putBoolean("Robot.gear.getHaltGear()", Robot.gear.getHaltGear());
		table.putNumber("Robot.leds.ledGearOn", Robot.leds.getLedGearOn());
		if (Robot.gear.getHaltGear()) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		table.putBoolean("Robot.gear.getHighGear()", Robot.gear.getHighGear());
		table.putBoolean("_on", _on);
		table.putBoolean("Robot.gear.getHaltGear()", Robot.gear.getHaltGear());
		table.putNumber("Robot.leds.ledGearOn", Robot.leds.getLedGearOn());
	}

	@Override
	protected void interrupted() {
		table.putBoolean("Robot.gear.getHighGear()", Robot.gear.getHighGear());
		table.putBoolean("_on", _on);
		table.putBoolean("Robot.gear.getHaltGear()", Robot.gear.getHaltGear());
		table.putNumber("Robot.leds.ledGearOn", Robot.leds.getLedGearOn());
	}

}
