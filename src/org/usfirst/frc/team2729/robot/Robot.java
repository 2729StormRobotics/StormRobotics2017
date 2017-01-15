package org.usfirst.frc.team2729.robot;

import org.usfirst.frc.team2729.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	//public static IntakeSystem intake;
	//public static ShootingSystem shoot;
	//public static HangingSystem hang;
	public static OI oi;
	private Compressor compressor;

	Command autonomousCommand;
	SendableChooser chooser;

	@Override
	public void robotInit() {
		Command autoCommand;
		String[] autoModeNames;
		Command[] autoModes;
		driveTrain = new DriveTrain();
		//intake = new IntakeSystem();
		//shoot = new ShootingSystem();
		
		//hang = new HangingSystem();
		oi = new OI();
		//vision = new VisionSystem();
		compressor = new Compressor();
		compressor.start();
		chooser = new SendableChooser();

		autoModeNames = new String[]{"Do Nothing","MAX MANUAL","40% MANUAL","MANUAL LOW BAR","Drive for 4 Seconds","LOW BAR AUTO","TURN 90","Drive To Defense", "Drive to Defense Backwards","Position Center Left", "Position Left", "Position Center", "Position Center Right", "Position Right" };
		//autoModes = new Command[]{new DoNothing(), new ManualDriveAuto(-1,5, true),new ManualDriveAuto(-.4,5, true),new ManualDriveLowBar(),new PIDDriveAuto(-.75, 4, true),new BreachLowBarAuto(), new Turn(90.0, .4) ,new BreachDefenseAuto(3000,.4, true), new BreachDefenseAuto(-3000, .4, true), new PositionCenterLeft(), new PositionLeft(), new PositionCenter(), new PositionCenterRight(), new PositionRight()};

		//configure and send the sendableChooser, which allows the modes
		//to be chosen via radio button on the SmartDashboard
	//	for(int i = 0; i < autoModes.length; ++i){
		//	chooser.addObject(autoModeNames[i], autoModes[i]);
		}
		//SmartDashboard.putData("Auto mode", chooser);
	//	SmartDashboard.putNumber("Encoder", driveTrain.getRightSpeedEnc());
	//}

	/*@Override
	public void disabledInit(){
		Robot.shoot.setTargetSpeed(0);
		Robot.shoot.setTargetTilt(Robot.shoot.getShooterPotRAW());
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		sendSensorData();
		Robot.shoot.setTargetTilt(Robot.shoot.getShooterPotRAW());
		//Robot.vision.addCrosshairs();
	}*/

	public void sendSensorData() {
		SmartDashboard.putNumber("Right Encoder", driveTrain.getRightDistance());
		SmartDashboard.putNumber("Left Encoder", driveTrain.getLeftDistance());
		//SmartDashboard.putNumber("Rot Pot", intake.getPot());
		//SmartDashboard.putNumber("Motor", intake.getTiltPower());
		//Robot.shoot.getShooterAnglePR();

		SmartDashboard.putBoolean("High Gear", Robot.driveTrain.getHighGear());
		SmartDashboard.putBoolean("PTO On", Robot.driveTrain.getPTO());

	}
	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
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
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		//Robot.shoot.unStall();
		//Robot.shoot.setTiltEStopped(false);
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