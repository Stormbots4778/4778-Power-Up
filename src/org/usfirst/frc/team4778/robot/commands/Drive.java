package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.OI;
import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* Drive.java
* Command that handles driving the robot
*/
public class Drive extends Command {
	public Drive() {
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		Robot.m_drive.arcadeDrive(-OI.joystickLeft.getY(), OI.joystickRight.getX(), true);
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