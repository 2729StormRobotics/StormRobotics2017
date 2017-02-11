package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Command;

public class Hang extends Command{
	SerialPort ledOut = new SerialPort(9600, Port.kMXP);
	
	public Hang() {
		requires(Robot.hang);
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		byte[] ff = new byte[1];
		double power = Robot.oi.getHang();
		Robot.hang.hang(power);
		ff[0] = (byte) 255;
		ledOut.write(ff, 1);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.hang.halt();
	}
	
	@Override
	protected void interrupted() {
		Robot.hang.halt();
	}
}
