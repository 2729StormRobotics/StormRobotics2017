package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class MovingVisionAlignment extends Command{
	NetworkTable table;
	double left = 0.2;
	double right = 0.2;
	
	public MovingVisionAlignment() {
		requires(Robot.driveTrain);
		table = NetworkTable.getTable("Vision");
		
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		if(table.getNumber("p_angle", 0) > 1) {
			left +=0.01;
			right -= 0.01;
		}
		else if(table.getNumber("p_angle", 0) < -1) {
			right += 0.01;
			left -= 0.01;
		}
			
		Robot.driveTrain.tankDrive(left, right);
		
	}
	
	@Override
	protected boolean isFinished() {
		if(table.getNumber("est_distance", 0) < 0.5)
			return true;
		return false;
	}

}
