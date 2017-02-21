package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionAlignment extends Command {

	private final static int SHIFTSCALE = 5;
	private NetworkTable table;
	private double dist;
	private double incr;
	//private CenterTurn x;
	private DriveForwardDistance y;

	public VisionAlignment() {
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.speedControl();
		table = NetworkTable.getTable("Vision");
	}

	@Override
	protected void execute() {
		
		dist = table.getNumber("est_distance", 0);
		new GyroTurn(50, 0).start();
		new AutoDrive(0).start();
		/*
//		double shift = table.getNumber("shift", 0);
		double shift = 0;
		incr = dist / 4;
		//x = new CenterTurn(0);
		//x.set_targetRotation(shift * SHIFTSCALE);
		//x.start();
		if (dist - incr > 0.4) {
			y = new DriveForwardDistance(200, incr, incr);
			y.start();
		} else {
			y = new DriveForwardDistance(50, dist-0.4, dist-0.4);
			y.start();
		
		}
		*/
	}

	@Override
	protected boolean isFinished() {
		//return dist <= 0.4;
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
