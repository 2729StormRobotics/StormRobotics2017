package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Center extends CommandGroup {

	public Center() {

		addSequential(new DriveForwardDistance(-0.2, -1.37, -1.37));
		addSequential(new WaitCommand(0.5));
		addSequential(new GearOn(false));
		addSequential(new WaitCommand(1));
		addSequential(new DriveForwardDistance(0.2, 1.37, 1.37));
		
		
	}
	
}
