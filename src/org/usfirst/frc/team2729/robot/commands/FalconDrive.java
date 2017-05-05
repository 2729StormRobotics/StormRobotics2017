package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;
import org.usfirst.frc.team2729.robot.util.FalconPathPlanner;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FalconDrive extends Command{
	int i;
	FalconPathPlanner path;
	NetworkTable table;
	double time;
	double step;
	double trackWidth;
	double ticksPerFoot = 977.848;
	
	public FalconDrive(double[][] waypoints, double time, double step, double trackWidth) {
		path = new FalconPathPlanner(waypoints);
		path.calculate(time, step, trackWidth);
		i = 0;
		table = NetworkTable.getTable("SplineTesting");
		Robot.driveTrain.speedControl();
		this.time = time;
		this.step = step;
		this.trackWidth = trackWidth;
		
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.driveTrain.speedControl();
		Robot.driveTrain.tankDrive(path.smoothLeftVelocity[i][1]*ticksPerFoot, path.smoothRightVelocity[i][1]*ticksPerFoot);
		
//		SmartDashboard.putDouble("Smooth Left Velocity", path.smoothLeftVelocity[i][1]);
//		SmartDashboard.putDouble("Smooth Right Velocity", path.smoothRightVelocity[i][1]);
		table.putNumber("Smooth Left", path.smoothLeftVelocity[i][1]);
		table.putNumber("Smooth Right Velocity", path.smoothRightVelocity[i][1]);
		i++;
		//Robot.driveTrain.tankDrive(300, 300);
	}

	@Override
	protected boolean isFinished() {
		if(i >= path.smoothLeftVelocity.length)
			return true;
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
