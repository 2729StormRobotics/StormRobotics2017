package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DFDSMove;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import org.usfirst.frc.team2729.robot.commands.ShootFire;
import org.usfirst.frc.team2729.robot.commands.ShooterSpin;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class RightPegBoiler extends CommandGroup{
	NetworkTable table;
//	public static boolean running = false;
	public RightPegBoiler() {
		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");
		
		addSequential(new DFDSpeed(-300, -300, 1.40, 1.40));
		addSequential(new WaitCommand(0.2));
		addSequential(new GyroTurn(-180, -60), 2); //CHECK + AND -
		addSequential(new WaitCommand(0.2));
		addSequential(new VisionGyroAlign(), 1);
		addSequential(new WaitCommand(0.2));
		addSequential(new MovingVisionAlignment(), 5); //removed timeout
		addSequential(new WaitCommand(0.2));
		
		//Move back retry
		addSequential(new DFDSMove(200, 200, 1.0, 1.0), 2);
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment(), 5); //removed timeout
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSMove(200, 200, 1.0, 1.0), 2);
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment(), 5); //removed timeout
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSMove(200, 200, 1.0, 1.0), 2);
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment()); //removed timeout
		addSequential(new WaitCommand(0.1));
		addSequential(new GearOn(false, false), 1);
		addSequential(new WaitCommand(0.5));
		
		addSequential(new DFDSpeed(310, 200, 1.5, 1.5));
		addSequential(new WaitCommand(0.1));
		
		addSequential(new ShootFire(4702));
		addSequential(new ShooterSpin(0.41));
		
		addSequential(new DFDSpeed(200, 250, 1, 1), 3);
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSpeed(200, 200, 0.5, 0.5), 3);
		
		addSequential(new WaitCommand(0.5));
		
		addSequential(new WaitCommand(5));
		addSequential(new ShooterSpin(0));
		addSequential(new ShootFire(0));
		
	}
}
