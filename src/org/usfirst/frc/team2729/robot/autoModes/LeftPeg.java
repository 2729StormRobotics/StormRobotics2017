package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import org.usfirst.frc.team2729.robot.commands.PVbusMovingVisionAlign;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LeftPeg extends CommandGroup {
	
	NetworkTable table;
	public LeftPeg() {

		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");

		addSequential(new DFDSpeed(-200, -200, .1, .1));
//		addSequential(new WaitCommand(0.2));
		addSequential(new DFDSpeed(-175, -275, 1.75, 1.75));
		addSequential(new WaitCommand(0.1));
		addSequential(new MovingVisionAlignment(), 6);
		addSequential(new WaitCommand(0.5));
		addSequential(new GearOn(false));
		addSequential(new WaitCommand(0.5));
		addSequential(new DFDSpeed(200, 200, 1.4, 1.4));
		
	}

}
