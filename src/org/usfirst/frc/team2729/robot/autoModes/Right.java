package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.AutoDrive;
import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Right extends CommandGroup{
	NetworkTable table;
//	public static boolean running = false;
	public Right() {
		table = NetworkTable.getTable("Vision");
		double dist = table.getNumber("est_distance", 0);
		//DashboardCmdLine = ""C:\\Program Files (x86)\\FRC Dashboard\\Dashboard.exe""

		double drive1 = -Preferences.getInstance().getDouble("Drive 1", 1.65);
		double turn1 = -Preferences.getInstance().getDouble("Turn 1", 50);
		
		addSequential(new DriveForwardDistance(-0.2, drive1/1.2, drive1/1.2));
		addSequential(new WaitCommand(0.5));
		addSequential(new GyroTurn(-0.3, turn1), 2.5);
		addSequential(new WaitCommand(0.8));
		addSequential(new VisionGyroAlign(), 5);
		
		
		double incr = 0.6;
//		double dist = 1.5;
//		int reps = (int) (dist / incr);
		int reps = 2;
//		addSequential(new VisionAlignment());
		
		for(int i = 0; i<reps; i++) {
			addSequential(new VisionGyroAlign(), 2.5);
			addSequential(new VisionGyroAlign(), 0.5);
			addSequential(new WaitCommand(1));
			addSequential(new DriveForwardDistance(-.2,-incr/1.2, -incr/1.2), 2.5);
			addSequential(new WaitCommand(0.5));
		}
		addSequential(new GearOn(false));
		addSequential(new WaitCommand(0.5));
		addSequential(new DriveForwardDistance(0.2, 1.37, 1.37));
		
	}
	
}
