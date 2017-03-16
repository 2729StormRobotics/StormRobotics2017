package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.PVbusMovingVisionAlign;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Left extends CommandGroup {
	
	NetworkTable table;
	public Left() {

		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");

		addSequential(new DriveForwardDistance(-0.3, -0.3, -1.1, -1.1, false));
		//addSequential(new DFDSpeed(-100, -100, -1, -1));
		addSequential(new WaitCommand(0.5));
		addSequential(new DriveForwardDistance(-0.2, -0.5, -0.6, -1.25, false));
		//addSequential(new GyroTurn(-.3, 60), 4);
		addSequential(new WaitCommand(0.5));
		addSequential(new PVbusMovingVisionAlign());
		//addSequential(new GearOn(false));
		//addSequential(new WaitCommand(0.5));
		//addSequential(new DriveForwardDistance(-0.2, -0.2, .7, 1.37, true));
		
	}

}
