package org.usfirst.frc.team2729.robot;

import org.usfirst.frc.team2729.robot.autoModes.Right;
import org.usfirst.frc.team2729.robot.commands.DriveForward;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.subsystems.DriveTrain;
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
	
	SerialPort ledOut = new SerialPort(9600, Port.kMXP);

	public static DriveTrain driveTrain;
//	public static DriveTrainPID driveTrainPID;
	public static GearSystem gear;
	public static HangingSystem hang;
	public static IntakeSystem intake;
	public static ShootingSystem shoot;
	public static OI oi;
	public static Compressor compressor;
	public static VisionSystem vision;
	public static LEDz leds;

	Command teleop;
	Command autonomousCommand;
	SendableChooser<Command> chooser;

	@Override
	public void robotInit() {

		driveTrain = new DriveTrain();
//		driveTrainPID = new DriveTrainPID();
		gear = new GearSystem();
		hang = new HangingSystem();
		intake = new IntakeSystem();
		shoot = new ShootingSystem();
		oi = new OI();
		vision = new VisionSystem();
		compressor = new Compressor();
		compressor.start();
		chooser = new SendableChooser<>();
		leds = new LEDz();
		
		chooser.addDefault("Default Program", new DriveForwardDistance(50, 0, 0));

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
		
		chooser.addObject("Drive 2 Meters", new DriveForwardDistance(50, 2, 2));
		chooser.addObject("Right", new Right());

		SmartDashboard.putData("Auto mode", chooser);
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
		SmartDashboard.putNumber("GyroAngle", Robot.driveTrain.getGyroAngle());
		// SmartDashboard.putBoolean("PTO On", Robot.driveTrain.getPTO());
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		
		// Robot.vision.addCrosshairs();
	}

	@Override
	public void autonomousInit() {
		
		if (teleop != null) {
			teleop.cancel();
		}
		autonomousCommand = (Command) chooser.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		byte[] ff = new byte[1];
		Scheduler.getInstance().run();
		sendSensorData();
		ff[0] = (byte) 160;
		ledOut.write(ff, 1);
		// Robot.vision.addCrosshairs();
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		if (teleop != null) {
			teleop.start();
			
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		// Robot.vision.addCrosshairs();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
		// Robot.vision.addCrosshairs();
	}
}