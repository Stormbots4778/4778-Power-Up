package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.OI;
import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/*
* Drive.java
* Command that handles driving the robot
*/
public class Drive extends Command {
	private static double targetTurnPower = 0;
	private static double targetLinearPower = 0;
	private static double currentTurnPower = 0;
	private static double currentLinearPower = 0;
	private static double deltaTime = 0;

	public Drive() {
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		deltaTime = 5*Robot.timer.get();
		Robot.timer.reset();
		targetTurnPower = Math.abs(OI.joystickRight.getX())*-OI.joystickRight.getX()*0.8f;
		targetLinearPower = OI.joystickLeft.getY()*0.75f;
		currentTurnPower = targetTurnPower;
		currentLinearPower = targetLinearPower;
		Robot.m_drive.arcadeDrive(currentTurnPower, currentLinearPower);
		//Robot.m_drive.arcadeDrive(Math.abs(OI.joystickRight.getX())*-OI.joystickRight.getX()*0.9f, OI.joystickLeft.getY()*0.75f);
	}
	

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}