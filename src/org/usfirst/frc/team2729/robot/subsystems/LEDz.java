package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LEDz extends Subsystem {

	static int ledStatus;
	SerialPort ledOut = new SerialPort(9600, Port.kMXP);

	// Auto Basic = 160 -
	// Drive Failure = 170
	// Shooting = 180
	// Encoder Failure = 200
	// Tele Basic = 210 -
	// Hanging Failure = 220
	// Shooting Failure = 230
	// Gear Failure = 240
	// Intake Failure = 250
	// RDP = 255 - Rainbow

	public boolean ledOff = false;
	public boolean ledAuto = false;
	public int ledGearOn = 0;
	public boolean ledHang = false;
	public int vision = 0;
	public NetworkTable table;
	public NetworkTable LEDZ;

	@Override
	protected void initDefaultCommand() {
		table = NetworkTable.getTable("Vision");
		// TODO Auto-generated method stub
		LEDZ = NetworkTable.getTable("LEDS");

	}

	// public void turnOn(int value) {
	// ledStatus |= value;
	//
	// }
	//
	// public void turnOff(int value) {
	// ledStatus &= ~value;
	// }

	static int loopCount = 0;

	public void setLED(int value) {
		ledStatus = value;
	}

	public void update() {
		double angle = table.getNumber("p_angle", 0);
		double targets = table.getNumber("targets", 0);
		if (targets <2)
			vision = 0;
		else if (angle > 1)
			vision = 1;
		else if (angle < -1)
			vision = 3;
		else
			vision = 2;

		table.putNumber("vision", vision);
		LEDZ.putNumber("ledGearOn", ledGearOn);
				byte[] ff = new byte[1];
		// if(ledStatus != 0){
		// Robot.driveTrain.tankDrive(0, 0.25);
		// }
		if (vision == 1) {
			ff[0] = (byte) 110;
			ledOut.write(ff, 1);
		} else if (vision == 2) {
			ff[0] = (byte) 140;
			ledOut.write(ff, 1);
		} else if (vision == 3) {
			ff[0] = (byte) 120;
			ledOut.write(ff, 1);
		}
		else if (ledGearOn == 1) {
			ff[0] = (byte) 130;
			ledOut.write(ff, 1);
		}
		// else if(ledGearOn == 0){
		// ff[0] = (byte) 255;
		// ledOut.write(ff, 1);
		// }
		// else{
		// ff[0] = (byte) 130;
		// ledOut.write(ff, 1);
		// }
		else if (ledHang) {
			ff[0] = (byte) 255;
			ledOut.write(ff, 1);
		} else {
			ff[0] = (byte) 0;
			ledOut.write(ff, 1);
		}
		// if(ledOff){
		// ff[0] = (byte) 0;
		// ledOut.write(ff, 1);
		// }
	}
}