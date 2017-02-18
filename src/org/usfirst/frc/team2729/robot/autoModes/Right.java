package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.AutoDrive;
import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Right extends CommandGroup{

	public Right() {
		//DashboardCmdLine = ""C:\\Program Files (x86)\\FRC Dashboard\\Dashboard.exe""
//		addSequential(new VisionAlignment());	
		addSequential(new GyroTurn(50, 0));
		addSequential(new WaitCommand(1));
		addSequential(new DriveForwardDistance(50, .5, .5));
		addSequential(new GyroTurn(50, 0));
		addSequential(new WaitCommand(1));
		addSequential(new DriveForwardDistance(50, .5, .5));
		addSequential(new GyroTurn(50, 0));
//		addSequential(new AutoDrive());
//		addSequential(new GyroTurn(.1, 180));
//		addSequential(new DriveForwardDistance(50, 1, 1));
	}
	
}
