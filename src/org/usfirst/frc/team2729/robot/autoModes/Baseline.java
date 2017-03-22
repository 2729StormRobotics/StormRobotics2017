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

public class Baseline extends CommandGroup{
	
	public Baseline() {
		addSequential(new DFDSpeed(-500, -500, -1.5, -1.5));
		addSequential(new WaitCommand(0.5));
	}
	
}
