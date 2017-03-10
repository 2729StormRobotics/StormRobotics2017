package org.usfirst.frc.team2729.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionSystem extends Subsystem {
	
	NetworkTable table;
	@Override
	protected void initDefaultCommand() {
	}

	public VisionSystem() {

	}
	
	public void DriveForwardDistance() {
		new org.usfirst.frc.team2729.robot.commands.DriveForwardDistance(0, 0, 0, 0, true);
	}
	
	public double GetEstDistance() {
		table = NetworkTable.getTable("Vision");
		return table.getNumber("est_distance", 0);
	}

}
