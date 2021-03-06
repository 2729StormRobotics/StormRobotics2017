package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class VisionAlignRep extends CommandGroup{
	public VisionAlignRep() {
		
		addSequential(new GyroTurn(0.2, 0));
		addSequential(new WaitCommand(1));
		addSequential(new DriveForwardDistance(-.2,-.2, -.5, -.5, true));
	}

}
