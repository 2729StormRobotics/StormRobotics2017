package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CenterTurn extends Command{
	public CenterTurn() {
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.speedControl();
	}
	
	@Override
	protected void execute() {
		final int RESOLUTION = 544;
		NetworkTable table;
		table = NetworkTable.getTable("Vision");
		int leftSpeed = 0;
		int rightSpeed = 0;
		while(true) {
			int shift = (int) table.getNumber("shift", 0); // (+) = left shifted (-) = right shifted
			int centerX = (int) table.getNumber("midpoint_x", RESOLUTION/2); //half of x res
			requires(Robot.driveTrain);
			
			if(centerX < (RESOLUTION/2) + 10 && centerX > (RESOLUTION/2) - 10) {
				leftSpeed = 0;
				rightSpeed = 0;
			}
			else if(centerX > RESOLUTION/2 && leftSpeed < 300) {
				leftSpeed+=10;
				rightSpeed -=10;
			}
			else if(centerX < RESOLUTION/2 && rightSpeed < 300) {
				rightSpeed +=10;
				leftSpeed -=10;
			}
			Robot.driveTrain.tankDrive(leftSpeed, rightSpeed); //1500 max
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.tankDrive(0, 0); //1500 max
	}
	
	@Override
	protected void interrupted() {
		Robot.driveTrain.tankDrive(0, 0); //1500 max
	}
}
