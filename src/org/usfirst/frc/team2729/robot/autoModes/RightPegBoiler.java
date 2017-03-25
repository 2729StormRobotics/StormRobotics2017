package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import org.usfirst.frc.team2729.robot.commands.ShootFire;
import org.usfirst.frc.team2729.robot.commands.ShooterSpin;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class RightPegBoiler extends CommandGroup{
	NetworkTable table;
//	public static boolean running = false;
	public RightPegBoiler() {
		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");
		
		addSequential(new DFDSpeed(-200, -200, .07, .07));
		addSequential(new DFDSpeed(-355, -175, 1.75, 1.75));
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment(), 6);
		addSequential(new WaitCommand(0.5));
		addSequential(new GearOn(false, true), 1);
		addSequential(new WaitCommand(0.5));	
		addSequential(new DFDSpeed(310, 200, 1.5, 1.5));
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSpeed(200, 300, 1, 1));
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSpeed(200, 200, 0.5, 0.5));
		addSequential(new ShootFire(4702));
		addSequential(new WaitCommand(0.5));
		addSequential(new ShooterSpin(0.41));
		addSequential(new WaitCommand(5));
		addSequential(new ShooterSpin(0));
		addSequential(new ShootFire(0));
	}
}
