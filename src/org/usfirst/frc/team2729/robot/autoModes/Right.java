package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Right extends CommandGroup{
	

	public Right() {
		//addSequential(DriveForwardDistance(drives, turns));
		alignment();
	
		//addSequential()
	}
	
	public void alignment() {
		final int RESOLUTION = 544;
		NetworkTable table;
		
		double leftSpeed = 200;
		double rightSpeed = 200;
		
		table = NetworkTable.getTable("Vision");
		int defaultValue = 0;
		while(table.getNumber("est_distance", 0) > 0.5) {
			int shift = (int) table.getNumber("shift", defaultValue); // 1 = left shifted 0 = right shifted
			int centerX = (int) table.getNumber("midpoint_x", RESOLUTION/2); //half of x res
			requires(Robot.driveTrain);
			
			//if (LR == 1)
				//rightSpeed += 
			
			if(centerX < (RESOLUTION/2) + 10 && centerX > (RESOLUTION/2) - 10) {
				leftSpeed = 200;
				rightSpeed = 200;
			}
			else if(centerX > RESOLUTION/2 && leftSpeed < 300)
				leftSpeed+=10;
			else if(centerX < RESOLUTION/2 && rightSpeed < 300)
				rightSpeed +=10;
			
			Robot.driveTrain.tankDrive(leftSpeed, rightSpeed); //1500 max
		}
	}
}
