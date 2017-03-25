package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LeftPegBoiler extends CommandGroup {
	
	NetworkTable table;
	public LeftPegBoiler() {

		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");

		addSequential(new DFDSpeed(-200, -200, .1, .1));
		//addSequential(new WaitCommand(0.2));
		addSequential(new DFDSpeed(-175, -275, 1.75, 1.75));
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment(), 6);
		addSequential(new WaitCommand(0.5));
		addSequential(new GearOn(false, true), 1);
		addSequential(new WaitCommand(0.5));
		addSequential(new DFDSpeed(200, 310, 1.5, 1.5));
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSpeed(300, 200, 1, 1));
		addSequential(new WaitCommand(0.1));
		addSequential(new DFDSpeed(200, 200, 0.5, 0.5));
		
	}

}
