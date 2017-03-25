package org.usfirst.frc.team2729.robot.subsystems;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LEDz extends Subsystem {

	private static int ledStatus;
	private static SerialPort ledOut = new SerialPort(9600, Port.kMXP);

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

	private boolean ledOff = false;
	private boolean ledAuto = false;
	private int ledGearOn = 0;
	private boolean ledHang = false;
	private int vision = 0;
	private boolean pegDetect = false;
	private NetworkTable table;
	private NetworkTable LEDZ;
	private static int loopCount = 0;

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

	public void setLED(int value) {
		ledStatus = value;
	}

	public void update() {
		double angle = table.getNumber("p_angle", 0);
		double targets = table.getNumber("targets", 0);
		if (targets < 2)
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

		if (!Robot.gear.getHaltGear()) {
			ff[0] = (byte) 255;
			ledOut.write(ff, 1);
		} else if (vision == 1) {
			ff[0] = (byte) 110;
			ledOut.write(ff, 1);
		} else if (vision == 2) {
			ff[0] = (byte) 140;
			ledOut.write(ff, 1);
		} else if (vision == 3) {
			ff[0] = (byte) 120;
			ledOut.write(ff, 1);
		} else if (ledGearOn == 1) {
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

	/**
	 * @return the ledStatus
	 */
	public static int getLedStatus() {
		return ledStatus;
	}

	/**
	 * @param ledStatus the ledStatus to set
	 */
	public static void setLedStatus(int ledStatus) {
		LEDz.ledStatus = ledStatus;
	}

	/**
	 * @return the ledOut
	 */
	public static SerialPort getLedOut() {
		return ledOut;
	}

	/**
	 * @param ledOut the ledOut to set
	 */
	public static void setLedOut(SerialPort ledOut) {
		LEDz.ledOut = ledOut;
	}

	/**
	 * @return the ledOff
	 */
	public boolean isLedOff() {
		return ledOff;
	}

	/**
	 * @param ledOff the ledOff to set
	 */
	public void setLedOff(boolean ledOff) {
		this.ledOff = ledOff;
	}

	/**
	 * @return the ledAuto
	 */
	public boolean isLedAuto() {
		return ledAuto;
	}

	/**
	 * @param ledAuto the ledAuto to set
	 */
	public void setLedAuto(boolean ledAuto) {
		this.ledAuto = ledAuto;
	}

	/**
	 * @return the ledGearOn
	 */
	public int getLedGearOn() {
		return ledGearOn;
	}

	/**
	 * @param ledGearOn the ledGearOn to set
	 */
	public void setLedGearOn(int ledGearOn) {
		this.ledGearOn = ledGearOn;
	}

	/**
	 * @return the ledHang
	 */
	public boolean isLedHang() {
		return ledHang;
	}

	/**
	 * @param ledHang the ledHang to set
	 */
	public void setLedHang(boolean ledHang) {
		this.ledHang = ledHang;
	}

	/**
	 * @return the vision
	 */
	public int getVision() {
		return vision;
	}

	/**
	 * @param vision the vision to set
	 */
	public void setVision(int vision) {
		this.vision = vision;
	}

	/**
	 * @return the pegDetect
	 */
	public boolean isPegDetect() {
		return pegDetect;
	}

	/**
	 * @param pegDetect the pegDetect to set
	 */
	public void setPegDetect(boolean pegDetect) {
		this.pegDetect = pegDetect;
	}

	/**
	 * @return the table
	 */
	public NetworkTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(NetworkTable table) {
		this.table = table;
	}

	/**
	 * @return the lEDZ
	 */
	public NetworkTable getLEDZ() {
		return LEDZ;
	}

	/**
	 * @param lEDZ the lEDZ to set
	 */
	public void setLEDZ(NetworkTable lEDZ) {
		LEDZ = lEDZ;
	}

	/**
	 * @return the loopCount
	 */
	public static int getLoopCount() {
		return loopCount;
	}

	/**
	 * @param loopCount the loopCount to set
	 */
	public static void setLoopCount(int loopCount) {
		LEDz.loopCount = loopCount;
	}
}