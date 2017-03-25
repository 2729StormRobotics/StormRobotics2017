package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CenterNoVision extends CommandGroup {

	NetworkTable table;
	
	public CenterNoVision() {
			addSequential(new DFDSpeed(-200, -200, 2, 2));
			addSequential(new WaitCommand(0.5));
			addSequential(new GearOn(false, true), 1);
			addSequential(new WaitCommand(0.5));
			addSequential(new DFDSpeed(200, 200, 1.4, 1.4));
	}
	
}
