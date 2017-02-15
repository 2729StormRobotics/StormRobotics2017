package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Right extends CommandGroup{
	

	public Right() {
		//DashboardCmdLine = ""C:\\Program Files (x86)\\FRC Dashboard\\Dashboard.exe""
//		addSequential(new VisionAlignment());	
//		addSequential(new CenterTurn());
//		addSequential(new AutoDrive());
//		addSequential(new CenterTurn());
//		addSequential(new AutoDrive());
//		addSequential(new CenterTurn());
//		addSequential(new AutoDrive());
		addSequential(new GyroTurn(.1, 180));
//		addSequential(new DriveForwardDistance(50, 1, 1));
	}
	
}
