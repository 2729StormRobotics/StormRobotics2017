package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDz extends Subsystem{
	
	static int ledStatus;
	SerialPort ledOut = new SerialPort(9600, Port.kMXP);
	
	//Auto Basic = 160
	//Drive Failure = 170
	//Shooting = 180
	//Encoder Failure = 200
	//Tele Basic = 210
	//Hanging Failure = 220
	//Shooting Failure = 230
	//Gear Failure = 240
	//Intake Failure = 250
	//RDP = 255
	
	public int ledMotors = 1;
	public int ledAuto = 2;
	public int ledTele = 4;
	public int ledShoot = 8;
	public int ledOff = 16;
	
	byte[] ff = new byte[1];
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void turnOn(int value) {
		ledStatus |= value;
		
	}
	
	public void turnOff(int value) {
		ledStatus &= ~value;
	}
	
	static int loopCount = 0;
	
	public void setLED(int value){
		ledStatus = value;
	}
	public void update(){
//		if(ledStatus != 0){
//			Robot.driveTrain.tankDrive(0, 0.25);
//		}
		 if((ledStatus & ledShoot) != 0){
			ff[0] = (byte) 180;
			ledOut.write(ff, 1);
			System.out.println("Tele");
		}
		else if((ledStatus & ledAuto) != 0){
			ff[0] = (byte) 160;
			ledOut.write(ff, 1);
			System.out.println("Auto");
		}
		else if((ledStatus & ledTele) != 0){
			ff[0] = (byte) 190;
			ledOut.write(ff, 1);
			System.out.println("Tele");
		}
		else if((ledStatus & ledOff) != 0){
			ff[0] = (byte) 150;
			ledOut.write(ff, 1);
			System.out.println("Tele");
		}
		else{
			ff[0] = (byte) 255;
			ledOut.write(ff, 1);
			System.out.println("No");
		}
	}
}