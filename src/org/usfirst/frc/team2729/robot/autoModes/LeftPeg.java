package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.commands.DFDSMove;
import org.usfirst.frc.team2729.robot.commands.DFDSpeed;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.MovingVisionAlignment;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LeftPeg extends CommandGroup {
	
	NetworkTable table;
	public LeftPeg() {

		Robot.driveTrain.resetEnc();
		table = NetworkTable.getTable("Vision");
		
		addSequential(new DFDSpeed(-200, -200, 1.55, 1.55));
		addSequential(new WaitCommand(0.2));
		addSequential(new GyroTurn(-150, 50), 2);
		addSequential(new WaitCommand(0.2));
		addSequential(new VisionGyroAlign(), 1);
		addSequential(new WaitCommand(0.2));
		addSequential(new MovingVisionAlignment(), 5); //removed timeout
		addSequential(new WaitCommand(0.5));
		
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
		addSequential(new DFDSpeed(200, 200, 1.4, 1.4));
		
	}

}
