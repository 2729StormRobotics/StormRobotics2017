package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDz extends Subsystem{
	
	static int ledStatus;
	SerialPort ledOut = new SerialPort(9600, Port.kMXP);
	
	//Auto Basic = 160 - 
	//Drive Failure = 170 
	//Shooting = 180
	//Encoder Failure = 200
	//Tele Basic = 210 - 
	//Hanging Failure = 220
	//Shooting Failure = 230
	//Gear Failure = 240
	//Intake Failure = 250
	//RDP = 255 - Rainbow
	
	public boolean ledOff = false;
	public boolean ledAuto = false;
	public boolean ledGearOn = false;
	public boolean ledHang = false;
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

//	public void turnOn(int value) {
//		ledStatus |= value;
//		
//	}
//	
//	public void turnOff(int value) {
//		ledStatus &= ~value;
//	}
	
	static int loopCount = 0;
	
	public void setLED(int value){
		ledStatus = value;
	}
	public void update(){
		byte[] ff = new byte[1];
//		if(ledStatus != 0){
//			Robot.driveTrain.tankDrive(0, 0.25);
//		}
		 if(ledAuto){
			ff[0] = (byte) 180;
			ledOut.write(ff, 1);
		}
		if(ledGearOn){
			ff[0] = (byte) 140;
			ledOut.write(ff, 1);
		}
//		else{
//			ff[0] = (byte) 130;
//			ledOut.write(ff, 1);
//		}
		else if(ledHang && ((ledGearOn = true)||(ledGearOn = false))){
			ff[0] = (byte) 255;
			ledOut.write(ff, 1);
		}
//		if(ledOff){
//			ff[0] = (byte) 0;
//			ledOut.write(ff, 1);
//		}
	}
}