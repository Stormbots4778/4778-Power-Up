package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	private boolean isFinished = false;
	private double endTime;

	public TurnToAngle() { // Angle in degrees
		requires(Robot.drivetrain);
	}

	@Override
	protected void initialize() {
		endTime = Timer.getFPGATimestamp() + (0.77);

	}

	@Override
	protected void execute() {
		Robot.m_drive.tankDrive(0.8, 0.8);
		if (Timer.getFPGATimestamp() >= endTime) {
			isFinished = true;
		}
	}

	@Override
	protected void end() {
		Robot.m_drive.tankDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}
}