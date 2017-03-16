package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.PVbusMovingVisionAlign;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RightBoiler extends CommandGroup{
	public RightBoiler() {
		addSequential(new DriveForwardDistance(-1.5, -1.7, -0.7, -0.7, false));
		// addSequential(new PVbusMovingVisionAlign(), 4);
		addSequential(new PVbusMovingVisionAlign(), 4);
		addSequential(new WaitCommand(0.5));
		addSequential(new GearOn(false), 1);
		addSequential(new WaitCommand(0.5));
		addSequential(new DriveForwardDistance(0.4, 0.4, 1.37, 1.37, true));
	}
}
