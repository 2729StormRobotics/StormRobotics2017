package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CenterVision extends CommandGroup {

	NetworkTable table;	
	public CenterVision() {
			addSequential(new DFDSpeed(-200, -200, .75, .75));
			addSequential(new WaitCommand(0.1));
			addSequential(new MovingVisionAlignment(), 6);
			addSequential(new WaitCommand(0.5));
			addSequential(new GearOn(false, false), 1);
			addSequential(new WaitCommand(0.5));
			addSequential(new DFDSpeed(200, 200, 1.4, 1.4));
	}
	
}
