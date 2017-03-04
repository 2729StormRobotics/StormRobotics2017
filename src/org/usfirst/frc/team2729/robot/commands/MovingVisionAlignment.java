package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class MovingVisionAlignment extends Command{
	NetworkTable table;
	double left = 0;
	double right = 0;
	double base = -150;
	
	public MovingVisionAlignment() {
		requires(Robot.driveTrain);
		
		table = NetworkTable.getTable("Vision");
		
	}
	
	protected void initialize() {
		Robot.driveTrain.speedControl();
	}
	
	protected void execute() {
		
		if(table.getNumber("p_angle", 0) > 1 && Math.abs(right - left) < 20) {
			left +=5;
			right -= 5;
		}
		else if(table.getNumber("p_angle", 0) < 1 && Math.abs(right - left) < 20) {
			left -= 5;
			right += 5;
		}
		else {
			left = 0;
			right = 0;
		}
		
		if(table.getNumber("est_distance", 0) < 0.75)
			base =-75;
		
		Robot.driveTrain.tankDrive(left + base, right + base);
		
	}
	@Override
	protected void end() {
		//Robot.driveTrain.percentVbusControl();
		//Robot.driveTrain.tankDrive(0, 0);
	}
	
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		if(table.getNumber("est_distance", 0) < 0.5 || Math.abs(Robot.driveTrain.getRightSpeedEnc()) < 10){
			
			return true;
		}

		return false;
	}

}
