package org.usfirst.frc.team2729.robot.autoModes;

import org.usfirst.frc.team2729.robot.commands.FalconDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SplineTest1 extends CommandGroup {
	public SplineTest1() {
		//addSequentials or parallel here
		double[][] waypoints = new double[][]{
			{0, 0},
			{0, 1},
		}; 
		double time = 1.0;
		double step = 0.1;
		double trackWidth = 2.125;
		
		addSequential(new FalconDrive(waypoints, time, step, trackWidth)) ;
	}
}
