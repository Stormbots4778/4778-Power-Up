package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	private double speed;
	
    public Shoot(double speed) {
    		this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.intake.setSpeed(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.intake.setSpeed(0);
    }

    protected void interrupted() {
    		end();
    }
}
