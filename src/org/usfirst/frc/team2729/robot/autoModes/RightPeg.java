package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.AutoDrive;
import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import org.usfirst.frc.team2729.robot.commands.PVbusMovingVisionAlign;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class RightPeg extends CommandGroup{
	NetworkTable table;
//	public static boolean running = false;
	public RightPeg() {
		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");
		
		
		addSequential(new DFDSpeed(-200, -200, .07, .07));
		//addSequential(new WaitCommand(0.2));
		addSequential(new DFDSpeed(-355, -175, 1.75, 1.75));
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment(), 6);
		addSequential(new WaitCommand(0.5));
		addSequential(new GearOn(false, true), 1);
		addSequential(new WaitCommand(0.5));
		addSequential(new DFDSpeed(200, 200, 1.4, 1.4));	
	}
}
