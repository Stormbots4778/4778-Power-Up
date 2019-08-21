package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class AlterShooterSpeed extends Command {
	private double delta;

	public AlterShooterSpeed(double delta) {
		this.delta = delta;
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		double newSpeed = Shooter.getSpeed() + delta;
		Shooter.setSpeed(newSpeed);
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
