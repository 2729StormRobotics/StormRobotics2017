package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CenterTurn extends Command{
	
	final int RESOLUTION = 320;
	int _rotation;
	NetworkTable table;
	double _targetRotation;
	
	public CenterTurn(int targetRotation) {
		requires(Robot.driveTrain);
		_targetRotation = targetRotation;
	}
	
	@Override
	protected void initialize() {
		table = NetworkTable.getTable("Vision");		
	}
	
	@Override
	public void execute() {

		int shift = (int) table.getNumber("shift", 0); // (+) = left shifted (-) = right shifted
		_rotation = (int) table.getNumber("p_angle", 0);
		GyroTurn x = new GyroTurn(50, _rotation - _targetRotation);
		x.start();
			//Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed); //1500 max

		/*
		if(centerX < (RESOLUTION/2) + 10 && centerX > (RESOLUTION/2) - 10) {
			leftSpeed = 0;
			rightSpeed = 0;
		}
		else if(centerX > RESOLUTION/2 && leftSpeed < 30) {
			leftSpeed+=1;
			rightSpeed -=1;
		}
		else if(centerX < RESOLUTION/2 && rightSpeed < 30) {
			rightSpeed +=1;
			leftSpeed -=1;
		}
		*/
	}
	public void set_targetRotation(double targetRotation) {
		_targetRotation = targetRotation;
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.percentVbusControl();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}
