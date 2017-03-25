package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Hang extends Command{
	
	public Hang() {
		requires(Robot.hang);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		double power = Robot.oi.getHang();
		Robot.hang.hang(power);
		if(power != 0) {
			Robot.leds.setLedHang(true);
		}
		else {
			Robot.leds.setLedHang(false);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.hang.halt();
	}
	
	@Override
	protected void interrupted() {
		Robot.hang.halt();
	}
}
