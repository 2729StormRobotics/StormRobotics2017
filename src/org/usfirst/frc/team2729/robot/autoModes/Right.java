package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Right extends CommandGroup{
	

	public Right() {
		addSequential(new VisionAlignment());	
		//addSequential(new CenterTurn());
		//addSequential(new DriveForwardDistance(50, 1, 1));
	}
	
}
