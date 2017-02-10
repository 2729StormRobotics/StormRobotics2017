package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionAlignment extends Command {

	private final static int RESOLUTION = 544;
	private NetworkTable table;
	private double dist;
	private double incr;
	private CenterTurn x;
	private DriveForwardDistance y;

	public VisionAlignment() {

	}

	@Override
	protected void initialize() {
		Robot.driveTrain.speedControl();
		table = NetworkTable.getTable("Vision");
		x = new CenterTurn();

	}

	@Override
	protected void execute() {
		dist = table.getNumber("est_distance", 0);

		incr = dist / 10;
		x.start();
		if (dist - incr > 0.4) {
			y = new DriveForwardDistance(200, incr, incr);
			y.start();
		} else {
			y = new DriveForwardDistance(50, dist-0.4, dist-0.4);
			y.start();
		}
	}

	@Override
	protected boolean isFinished() {
		return dist <= 0.4;
	}

	@Override
	protected void end() {
		Robot.driveTrain.tankDrive(0, 0); // 1500 max
	}

	@Override
	protected void interrupted() {
		Robot.driveTrain.tankDrive(0, 0); // 1500 max
	}
}
