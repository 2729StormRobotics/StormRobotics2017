package org.usfirst.frc.team2729.robot;

import org.usfirst.frc.team2729.robot.autoModes.Baseline;
import org.usfirst.frc.team2729.robot.autoModes.CenterNoVision;
import org.usfirst.frc.team2729.robot.autoModes.CenterVision;
import org.usfirst.frc.team2729.robot.autoModes.LeftPeg;
import org.usfirst.frc.team2729.robot.autoModes.RightPeg;
import org.usfirst.frc.team2729.robot.commands.DriveForward;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2729.robot.subsystems.DriveTrainPID;
import org.usfirst.frc.team2729.robot.subsystems.GearSystem;
import org.usfirst.frc.team2729.robot.subsystems.HangingSystem;
import org.usfirst.frc.team2729.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team2729.robot.subsystems.LEDz;
import org.usfirst.frc.team2729.robot.subsystems.ShootingSystem;
import org.usfirst.frc.team2729.robot.subsystems.VisionSystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	//public static DriveTest driveTrain;
	//public static DriveTrainPID driveTrainPID;
	public static GearSystem gear;
	public static HangingSystem hang;
	public static IntakeSystem intake;
	public static ShootingSystem shoot;
	public static OI oi;
	public static Compressor compressor;
	public static VisionSystem vision;
	public static LEDz leds;
	public static Preferences preferences;

	Command teleop;
	Command autonomousCommand;
	SendableChooser<Command> chooser;

	@Override
	public void robotInit() {


		driveTrain = new DriveTrain();
		//driveTrainPID = new DriveTrainPID();
		gear = new GearSystem();
		hang = new HangingSystem();
		intake = new IntakeSystem();
		shoot = new ShootingSystem();
		oi = new OI();
		vision = new VisionSystem();
		compressor = new Compressor();
		compressor.start();
		leds = new LEDz();
		
		chooser = new SendableChooser<>();
		chooser.addDefault("Do Nothing", new DriveForwardDistance(0, 0, 0, 0, true));
		chooser.addObject("Baseline", new Baseline());
		chooser.addObject("Left", new LeftPeg());
		chooser.addObject("Center No Vision", new CenterNoVision());
		chooser.addObject("Right", new RightPeg());
		chooser.addObject("Center Vision", new CenterVision());
		
		SmartDashboard.putData("AutoChooser", chooser);
		
		
//		String[] autoModeNames = new String[] { "Drive Forward Distance", "Drive Forward Time", "Right", "GyroTurn" };
//		Command[] autoModes = new Command[] { new DriveForwardDistance(50, 2, 2),
//				new DriveForward(-0.25, 10), new Right()};// Almost full turn
//		
////		Command[] autoModes = new Command[] { new DriveForwardDistance(encoderTicsPerRev * 20, encoderTicsPerRev * 20),
////				new DriveForward(-0.25, 10) };
//
//		
//		// configure and send the sendableChooser, which allows the modes
//		// to be chosen via radio button on the SmartDashboard
//		for (int i = 0; i < autoModes.length; i++) {
//			chooser.addObject(autoModeNames[i], autoModes[i]);
//		}
		


		SmartDashboard.putData(Scheduler.getInstance());
			
		
		new Command("Sensor feedback") {
			@Override
			protected void initialize() {
			}

			@Override
			protected void execute() {
				sendSensorData();
			}

			@Override
			protected boolean isFinished() {
				return false;
			}

			@Override
			protected void end() {
			}

			@Override
			protected void interrupted() {
			}
		}.start();
		
	}

	public void sendSensorData() {
		SmartDashboard.putNumber("Right Encoder", driveTrain.getRightDistance());
		SmartDashboard.putNumber("Left Encoder", driveTrain.getLeftDistance());
		SmartDashboard.putNumber("LeftEncVelocity", Robot.driveTrain.getLeftSpeedEnc());
		SmartDashboard.putNumber("RightEncVelocity", Robot.driveTrain.getRightSpeedEnc());
		SmartDashboard.putNumber("LeftSpeed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("RightSpeed", Robot.driveTrain.getRightSpeed());
		SmartDashboard.putNumber("ShootFire Amount Turned", Robot.shoot.getShootFireDistance());
		SmartDashboard.putNumber("ShootFire EncVelocity", Robot.shoot.getShootFireSpeedEnc());
		SmartDashboard.putNumber("ShootFire EncPosition", Robot.shoot.getShootFireDistance());
		SmartDashboard.putNumber("Intake", Robot.oi.getIntake());
		SmartDashboard.putString("ShootFire Speed Control", Robot.shoot.getShootFireMode());
		SmartDashboard.putBoolean("ShootFire is PID?", Robot.shoot.isShootFirePID());
		SmartDashboard.putBoolean("getHighGear", Robot.gear.getHighGear());
		SmartDashboard.putBoolean("haltGear", Robot.gear.getHaltGear());
		SmartDashboard.putBoolean("Is HalfOne?", Robot.driveTrain.getHalfOne());
		SmartDashboard.putBoolean("Is HalfTwo?", Robot.driveTrain.getHalfTwo());
		SmartDashboard.putBoolean("Right Encoder Movement", Robot.driveTrain.encoderEnabledRight());
		SmartDashboard.putBoolean("Left Encoder Movement", Robot.driveTrain.encoderEnabledLeft());
		//pidf
		
		
		
		SmartDashboard.putNumber("GyroAngle", Robot.driveTrain.getGyroAngle());
		// SmartDashboard.putBoolean("PTO On", Robot.driveTrain.getPTO());
		SmartDashboard.putString("DriveTrain control mode", Robot.driveTrain.getDriveTrainControlMode());
		SmartDashboard.putBoolean("DriveTrain is PID?", Robot.driveTrain.isDriveTrainPID());
		SmartDashboard.putNumber("DriveTrain PID: LP", Robot.driveTrain.getLvalueP());
		SmartDashboard.putNumber("DriveTrain PID: LI", Robot.driveTrain.getLvalueI());
		SmartDashboard.putNumber("DriveTrain PID: LD", Robot.driveTrain.getLvalueD());
//		SmartDashboard.putNumber("DriveTrain PID: F", Robot.driveTrain.getValueF());
		
		
	}

	@Override
	public void disabledInit() {
		//Robot.leds.turnOn(Robot.leds.ledOff);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		Robot.leds.update();
		// Robot.vision.addCrosshairs();
	}

	@Override
	public void autonomousInit() {
		//Robot.leds.turnOff(4);
	//	Robot.leds.turnOn(Robot.leds.ledAuto);
		if (teleop != null) {
			teleop.cancel();
		}
		autonomousCommand = (Command) chooser.getSelected();
		if (autonomousCommand != null) {
			Robot.gear.startComp();
			autonomousCommand.start();
		}
	}

	@Override
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		
		Robot.leds.update();

	}

	@Override
	public void teleopInit() {
		//Robot.leds.turnOff(Robot.leds.ledAuto);
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		if (teleop != null) {
			Robot.driveTrain.percentVbusControl();
			teleop.start();
		}
		
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		Robot.leds.update();
		// Robot.vision.addCrosshairs();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
		// Robot.vision.addCrosshairs();
	}
}