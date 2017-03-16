package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class PVbusMovingVisionAlign extends Command {
	NetworkTable table;
	double left = 0;
	double right = 0;
	double base = -0.2;

	public PVbusMovingVisionAlign() {
		requires(Robot.driveTrain);

		table = NetworkTable.getTable("Vision");

	}

	protected void initialize() {
		Robot.driveTrain.percentVbusControl();
	}

	protected void execute() {

		if (table.getNumber("p_angle", 0) > 1 && Math.abs(right - left) < 0.1) {
			left += 0.03;
			right -= 0.03;
		} else if (table.getNumber("p_angle", 0) < 1 && Math.abs(right - left) < 0.1) {
			left -= 0.03;
			right += 0.03;
		} else {
			left = 0;
			right = 0;
		}

		if (table.getNumber("est_distance", 0) < 0.75)
			base = -0.2;

		Robot.driveTrain.tankDrive(left + base, right + base);

	}

	@Override
	protected void end() {
		// Robot.driveTrain.percentVbusControl();
		// Robot.driveTrain.tankDrive(0, 0);
	}

	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
//		if (/*table.getNumber("est_distance", 0) < 0.3
//				|| */(table.getNumber("targets", 2) == 0 && Math.abs(Robot.driveTrain.getRightSpeedEnc()) < 5)) {
//
//			return true;
//		}
		int leftSpeed = Math.abs(Robot.driveTrain.getLeftSpeedEnc());
		int rightSpeed = Math.abs(Robot.driveTrain.getRightSpeedEnc());
		double dist = table.getNumber("est_distance", 0);
		
//		if (dist < 0.5 && leftSpeed + rightSpeed < 8) {
//			return true;
//		}
		
		if (table.getNumber("targets", 2) == 0 && Math.abs(Robot.driveTrain.getRightSpeedEnc()) < 5) {

			return true;
		}

		return false;
	}

}
