package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CenterTurn extends Command{
	public CenterTurn() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		
		Robot.driveTrain.speedControl();
		
	}
	
	@Override
	protected void execute() {
		GyroTurn x = new GyroTurn();
		
		final int RESOLUTION = 320;
		NetworkTable table;
		table = NetworkTable.getTable("Vision");
		int leftSpeed = 0;
		int rightSpeed = 0;
		int rotation = (int) table.getNumber("p_angle", 0);
		while(Math.abs(rotation) > 2) {
			int shift = (int) table.getNumber("shift", 0); // (+) = left shifted (-) = right shifted
			x.turn(.10, rotation);
			rotation = (int) table.getNumber("p_angle", 0);
			//Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed); //1500 max
		}
		

		/*
		if(centerX < (RESOLUTION/2) + 10 && centerX > (RESOLUTION/2) - 10) {
			leftSpeed = 0;
			rightSpeed = 0;
		}
		else if(centerX > RESOLUTION/2 && leftSpeed < 30) {
			leftSpeed+=1;
			rightSpeed -=1;
		}
		else if(centerX < RESOLUTION/2 && rightSpeed < 30) {
			rightSpeed +=1;
			leftSpeed -=1;
		}
		*/
	}
	
	@Override
	protected boolean isFinished() {
		return true;
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
