package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Baseline extends CommandGroup{
	
	public Baseline() {
		addSequential(new DFDSpeed(-500, -500, -1.5, -1.5));
		addSequential(new WaitCommand(0.5));
	}
	
}
