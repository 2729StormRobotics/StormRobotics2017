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

public class Right extends CommandGroup{
	NetworkTable table;
//	public static boolean running = false;
	public Right() {
		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");
		
		addSequential(new DFDSpeed(-400, -400, 2, 2));
		//addSequential(new DriveForwardDistance(-0.3, -0.3, -0.4, -0.4, false));
		//addSequential(new DriveForwardDistance(-0.35, -0.21, -1.55, -0.8, false));
		//addSequential(new PVbusMovingVisionAlign());
		//addSequential(new GearOn(false));
		//addSequential(new WaitCommand(0.5));
		//addSequential(new DriveForwardDistance(0.2, 0.2, 1.37, 1.37, true));
		
		//TestBot
//		double left = -105;
//		double right = -150;
		//addSequential(new DFDSpeed(left, right, -1, -1.5));
		//addSequential(new DFDSpeed(-50, -50, -0.5, -0.5));
		//addSequential(new WaitCommand(2));
		//addSequential(new MovingVisionAlignment());
		//addSequential(new WaitCommand(2));	
	}
}
