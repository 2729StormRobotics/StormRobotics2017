package org.usfirst.frc.team2729.robot;

import org.usfirst.frc.team2729.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2729.robot.subsystems.GearSystem;
import org.usfirst.frc.team2729.robot.subsystems.HangingSystem;
import org.usfirst.frc.team2729.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team2729.robot.subsystems.ShootingSystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static GearSystem gear;
	public static HangingSystem hang;
	public static IntakeSystem intake;
	public static ShootingSystem shoot;
	public static OI oi;
	public static Compressor compressor;
//	public static VisionSystem vision;
	Command teleop;
	Command selectedAutoMode;
	SendableChooser chooser;

	@Override
	public void robotInit() {
		
		String[] autoModeNames;
		Command[] autoModes;
		driveTrain = new DriveTrain();
		gear = new GearSystem();
		hang = new HangingSystem();
		intake = new IntakeSystem();
		shoot = new ShootingSystem();
		oi = new OI();
		//vision = new VisionSystem();
		compressor = new Compressor();
		compressor.start();
		chooser = new SendableChooser();

		autoModeNames = new String[]{};
		autoModes = new Command[]{};

	//	configure and send the sendableChooser, which allows the modes
	//	to be chosen via radio button on the SmartDashboard
		for(int i = 0; i < autoModes.length; ++i){
			chooser.addObject(autoModeNames[i], autoModes[i]);
		}
		
		SmartDashboard.putData("Auto mode", chooser);
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putNumber("Left Encoder", driveTrain.getLeftSpeedEnc());
		SmartDashboard.putNumber("Right Encoder", driveTrain.getRightSpeedEnc());
	}

	@Override
	public void disabledInit(){
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		//Robot.vision.addCrosshairs();
	}

	public void sendSensorData() {
		SmartDashboard.putNumber("Right Encoder", driveTrain.getRightDistance());
		SmartDashboard.putNumber("Left Encoder", driveTrain.getLeftDistance());
		SmartDashboard.putBoolean("High Gear", Robot.driveTrain.getHighGear());
//		SmartDashboard.putBoolean("PTO On", Robot.driveTrain.getPTO());

	}
	@Override
	public void autonomousInit() {
		if (teleop != null) {
			teleop.cancel();
		}
		selectedAutoMode = (Command) chooser.getSelected();
		if (selectedAutoMode != null) {
			selectedAutoMode.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		//Robot.vision.addCrosshairs();
	}

	@Override
	public void teleopInit() {
		if (selectedAutoMode != null) {
			selectedAutoMode.cancel();
		}
		if (teleop != null) {
			teleop.start();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		//Robot.vision.addCrosshairs();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
		//Robot.vision.addCrosshairs();
	}
}