package org.usfirst.frc.team2729.robot;

import org.usfirst.frc.team2729.robot.autoModes.Right;
import org.usfirst.frc.team2729.robot.autoModes.VisionAlignRep;
import org.usfirst.frc.team2729.robot.commands.AutoDrive;
import org.usfirst.frc.team2729.robot.commands.CenterTurn;
import org.usfirst.frc.team2729.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team2729.robot.commands.GearOn;
import org.usfirst.frc.team2729.robot.commands.GyroTurn;
import org.usfirst.frc.team2729.robot.commands.LightOn;
import org.usfirst.frc.team2729.robot.commands.ShootFire;
import org.usfirst.frc.team2729.robot.commands.ShooterSpin;
import org.usfirst.frc.team2729.robot.commands.VisionAlignment;
import org.usfirst.frc.team2729.robot.commands.VisionGyroAlign;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
// Hi Mom
	private final Joystick driveJoystick = new Joystick(RobotMap.PORT_JOYSTICK_DRIVE),
			armJoystick = new Joystick(RobotMap.PORT_JOYSTICK_ARMS);

	private final Button 
			halveOne = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_HALVE_1),
			halveTwo = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_HALVE_2),
			shiftGearOn = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHIFT_GEAR_ON),
			shiftGearOff = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHIFT_GEAR_OFF),
			shooterSpinOn = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_SPIN_ON),
			shooterSpinOnLow = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_SPIN_LOW),
			shooterSpinOff = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_SPIN_OFF),
			shootFire = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_FIRE),
			shootFireOff = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_SHOOT_FIRE_OFF),
			gyroTurn = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_CENTERTURN),
			autoDrive = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_AUTODRIVE),
			fullAuto = new JoystickButton(driveJoystick, RobotMap.JOYDRIVE_BUTTON_FULLAUTO),
			lightOn = new JoystickButton(armJoystick, RobotMap.JOYARM_BUTTON_LIGHT_ON),
			drive = new JoystickButton(armJoystick, RobotMap.JOYARM_DRIVE);
	
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
		return _zeroDeadzone(armJoystick.getRawAxis(RobotMap.JOYAXIS_AXIS_INTAKE), 0.24);
	}
	public double getHang() {
		return _zeroDeadzone(armJoystick.getRawAxis(RobotMap.JOYAXIS_AXIS_HANG), 0.15);
	}
	
	public OI(){
		//Driver Commands

		//Operator Commands	
		
		shiftGearOn.whenPressed(new GearOn(true));
		shiftGearOff.whenPressed(new GearOn(false));	
		shootFire.whenPressed(new ShootFire(4702));
		shootFireOff.whenPressed(new ShootFire(0));
		shooterSpinOn.whenPressed(new ShooterSpin(0.41));
		shooterSpinOnLow.whenPressed(new ShooterSpin(.20));
		shooterSpinOff.whenPressed(new ShooterSpin(0));
		gyroTurn.whenPressed(new GyroTurn(-0.2, 180));
		autoDrive.whenPressed(new DriveForwardDistance(-0.2, -0.42, -0.42));
		lightOn.whenPressed(new LightOn());
		fullAuto.whenPressed(new VisionAlignment());
		drive.whenPressed(new DriveForwardDistance(-0.5, 2, 2));
		
		//Special Commands
		
		halveOne.whileHeld(new Command() {
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
		});

	}
}
