package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class OneHundredPercent extends Command {
	public OneHundredPercent() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.speed = 1.0;
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
