package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.PVbusMovingVisionAlign;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Center extends CommandGroup {

	NetworkTable table;
//	public static boolean running = false;
	
	public Center() {

//			table = NetworkTable.getTable("Vision");
//			double dist = table.getNumber("est_distance", 0);
			addSequential(new DriveForwardDistance(-0.3, -0.3, -0.7, -0.7, false));
			//addSequential(new PVbusMovingVisionAlign(), 4);
			addSequential(new PVbusMovingVisionAlign(), 4);
			addSequential(new WaitCommand(0.5));
			addSequential(new GearOn(false), 1);
			addSequential(new WaitCommand(0.5));
//			addSequential(new DriveForwardDistance(-0.2, -0.2, -0.5, -0.5, false));
//			addSequential(new WaitCommand(2));
//			Robot.driveTrain.tankDrive(0, 0);
			addSequential(new DriveForwardDistance(0.4, 0.4, 1.37, 1.37, true));
	}
	
}
