package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SeventyFivePercent extends Command {
	public SeventyFivePercent() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.speed = 0.75;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {
		end();
	}
}
