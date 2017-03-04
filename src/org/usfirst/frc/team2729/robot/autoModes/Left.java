package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Left extends CommandGroup {
	
	public Left() {

		addSequential(new GyroTurn(-0.2, 30));
		addSequential(new WaitCommand(0.8));
		addSequential(new DriveForwardDistance(-0.2,-.2, -0.5, -0.5));
		
	}

}
