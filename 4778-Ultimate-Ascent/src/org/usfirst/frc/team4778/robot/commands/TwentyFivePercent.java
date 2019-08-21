package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TwentyFivePercent extends Command {
	public TwentyFivePercent() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.speed = 0.25;
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
