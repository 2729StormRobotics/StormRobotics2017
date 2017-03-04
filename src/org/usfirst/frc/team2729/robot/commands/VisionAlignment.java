package org.usfirst.frc.team2729.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionAlignment extends CommandGroup{
	NetworkTable table;
	public VisionAlignment() {
		
		table = NetworkTable.getTable("Vision");
		double dist = table.getNumber("est_distance", 0);
	
		double incr = 0.5;
		int reps = (int) (dist / incr);
		
		for(int i = 0; i<reps; i++) {
			addSequential(new VisionGyroAlign(), 1.5);
			addSequential(new WaitCommand(0.7));
			addSequential(new DriveForwardDistance(-.2,-.2, -incr/1.5, -incr/1.5));
			addSequential(new WaitCommand(0.5));
		}
		
	}
	
}
