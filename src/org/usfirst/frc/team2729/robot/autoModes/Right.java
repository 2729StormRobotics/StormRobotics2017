package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Right extends CommandGroup{
	

	public Right() {
		addSequential(new VisionAlignment());	
//		addSequential(new CenterTurn());
//		addSequential(new AutoDrive());
//		addSequential(new CenterTurn());
//		addSequential(new AutoDrive());
//		addSequential(new CenterTurn());
//		addSequential(new AutoDrive());
		//addSequential(new DriveForwardDistance(50, 1, 1));
	}
	
}
