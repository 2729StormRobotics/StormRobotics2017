package org.usfirst.frc.team2729.robot.commands;

import org.usfirst.frc.team2729.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootFire extends Command {
	
	private final double _fireRate;

	public ShootFire(double fireRateInput) {
		requires(Robot.shoot);
		_fireRate = fireRateInput;
		
	}
	
	@Override
	protected void initialize() {
		Robot.shoot.resetEnc();
	}
	
	@Override
	protected void execute() {
		
		//If the button to turn off the shooter is pressed, override preferences value from SMartDashboard
		//if (_fireRate == 0) {
		//	fireRate = 0;
		//}
		//else {
			
			
			//fireRate = Preferences.getInstance().getDouble("ShootFireSpeed", _fireRate);
			//fireRate = _fireRate;
			
		//}
		//This value must be negative so that shooter runs in correct direction
		//if (fireRate > 0) {
			//fireRate = 0;
		//}
		
		//Value lower than -0.9 will default to -0.9
		//if (fireRate < -0.9) {
			//fireRate = -0.9;
		//}
		Robot.shoot.shootFire(_fireRate);
		if (_fireRate == 0) {
			Robot.shoot.lightOff();
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
