package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDrive extends Command {

	private final static int RESOLUTION = 544;
	private NetworkTable table;
	private double dist;
	private double incr;
	private DriveForwardDistance y;

	public AutoDrive() {
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.speedControl();
		table = NetworkTable.getTable("Vision");

	}

	@Override
	protected void execute() {
		dist = table.getNumber("est_distance", 0);
		incr = dist / 10;
		SmartDashboard.putNumber("dist", dist);
		SmartDashboard.putNumber("incr", incr);
		if (dist - incr > 0.4) {
			y = new DriveForwardDistance(100, incr, incr);
			y.start();
		} else {
			y = new DriveForwardDistance(50, dist-0.4, dist-0.4);
			y.start();
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.driveTrain.tankDrive(0, 0); // 1500 max
		Robot.driveTrain.percentVbusControl();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
