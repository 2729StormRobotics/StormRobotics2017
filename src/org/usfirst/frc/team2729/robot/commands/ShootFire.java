package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootFire extends Command {
	
	private final double _fireRate;

	public ShootFire(double fireRate) {
		requires(Robot.shoot);
		_fireRate = fireRate;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.shoot.shootFire(_fireRate);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.shoot.shootFire(0);
	}
	
	@Override
	protected void interrupted() {
		Robot.shoot.shootFire(0);
	}

}
