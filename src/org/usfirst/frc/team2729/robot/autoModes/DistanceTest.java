package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DistanceTest extends CommandGroup {
	public DistanceTest() {
		addSequential(new DriveForwardDistance(-0.2, -0.2, -0.5, -0.5));
	}

}