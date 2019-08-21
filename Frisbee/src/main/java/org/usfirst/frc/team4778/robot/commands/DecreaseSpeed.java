package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DecreaseSpeed extends Command {
	public DecreaseSpeed() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.speed -= 0.05;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {
		end();
	}
}
