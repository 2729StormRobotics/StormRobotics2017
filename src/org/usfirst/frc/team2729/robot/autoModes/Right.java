package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.AutoDrive;
import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

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
		//while(table.getNumber("est_distance", 0) > 0.4){
		//	addSequential(new VisionAlignRep()); //Give param for dist.  Calc dist through incr
		//}
		//table.putBoolean("VisionAlignRep Running", VisionAlignRep())
		//VisionAlignRep x = new VisionAlignRep();
		//x.start();
		//x.start();
//		while (dist > 0.4) {
//			if(!x.isRunning())
//				addSequential(x);
//			
//		}

//		addSequential(new DriveForwardDistance(-0.2, -1.37, -1.37));
//		addSequential(new WaitCommand(1));
//		addSequential(new GearOn(false));
//		addSequential(new WaitCommand(1));
//		addSequential(new DriveForwardDistance(0.2, 1.37, 1.37));
		double incr = 0.5;
		//double dist = 1.5;
		int reps = (int) (dist / incr);
		
		for(int i = 0; i<reps; i++) {
			addSequential(new VisionGyroAlign());
			addSequential(new WaitCommand(1));
			addSequential(new DriveForwardDistance(-.2,-incr, -incr));
		}
		
//		addSequential(new WaitCommand(0.5));
//		addSequential(new GearOn(false));
//		addSequential(new WaitCommand(1));
//		addSequential(new DriveForwardDistance(0.2, 1.37, 1.37));
//		
	}
	
}
