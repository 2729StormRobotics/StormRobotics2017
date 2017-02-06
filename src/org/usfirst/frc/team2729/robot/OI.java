package org.usfirst.frc.team2729.robot;

import org.usfirst.frc.team2729.robot.commands.Gear;
import org.usfirst.frc.team2729.robot.commands.PIDDrive;
import org.usfirst.frc.team2729.robot.commands.Shift;
import org.usfirst.frc.team2729.robot.commands.ShootFire;
import org.usfirst.frc.team2729.robot.commands.ShooterSpin;
import org.usfirst.frc.team2729.robot.subsystems.ShootingSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {

	private final Joystick driveJoystick = new Joystick(RobotMap.PORT_JOYSTICK_DRIVE),
			armJoystick = new Joystick(RobotMap.PORT_JOYSTICK_ARMS);

	private final Button 
//			halveOne = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_HALVE_1),
//			halveTwo = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_HALVE_2),
			shiftHighDrive = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_SHIFT_DRIVE_HIGH),
			shiftLowDrive = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_SHIFT_DRIVE_LOW),
			driveForward = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_FORWARD),
			driveBackward = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_BACKWARDS),
			shiftGearOn = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHIFT_GEAR_ON),
			shiftGearOff = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHIFT_GEAR_OFF),
			shooterSpinOn = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_SPIN_ON),
			shooterSpinOff = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_SPIN_OFF),
			shootFire = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_FIRE),
			shootFireOff = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_FIRE_OFF);
	
	
	private double _zeroDeadzone(double joyValue,double dead) {
		return Math.abs(joyValue) > dead ? joyValue : 0;
	}
	public double getLeftDrive(){
		return _zeroDeadzone(driveJoystick.getRawAxis(RobotMap.JOYDRIVE_AXIS_DRIVE_LEFT), 0.15);
	}
	public double getRightDrive(){
		return _zeroDeadzone(driveJoystick.getRawAxis(RobotMap.JOYDRIVE_AXIS_DRIVE_RIGHT), 0.15);
	}
	public double getIntake(){
		return _zeroDeadzone(armJoystick.getRawAxis(RobotMap.JOYAXIS_AXIS_INTAKE), 0.15);
	}
	public double getHang() {
		return _zeroDeadzone(armJoystick.getRawAxis(RobotMap.JOYAXIS_AXIS_HANG), 0.15);
	}
	
	public OI(){
		//Driver Commands

		shiftHighDrive.whenPressed(new Shift(true));
		shiftLowDrive.whenPressed(new Shift(false));
		driveForward.whileHeld(new PIDDrive(1, true));
		driveBackward.whileHeld(new PIDDrive(1, true));

		//Operator Commands
		
		
		
		shiftGearOn.whenPressed(new Gear(true));
		shiftGearOff.whenPressed(new Gear(false));	
		shootFire.whenPressed(new ShootFire(.6));
		shootFireOff.whenPressed(new ShootFire(0));
		shooterSpinOn.whenPressed(new ShooterSpin(0.3));
		shooterSpinOff.whenPressed(new ShooterSpin(0));
		
		//Special Commands
		
		/*halveOne.whileHeld(new Command() {
			@Override
			protected void initialize() { Robot.driveTrain.halveOne(true); }
			@Override
			protected void execute() {}
			@Override
			protected boolean isFinished() { return false; }
			@Override
			protected void end() { Robot.driveTrain.halveOne(false); }
			@Override
			protected void interrupted() { end(); }
		});

		halveTwo.whileHeld(new Command() {
			@Override
			protected void initialize() { Robot.driveTrain.halveTwo(true); }
			@Override
			protected void execute() {}
			@Override
			protected boolean isFinished() { return false; }
			@Override
			protected void end() { Robot.driveTrain.halveTwo(false); }
			@Override
			protected void interrupted() { end(); }
		});*/

	}
}
