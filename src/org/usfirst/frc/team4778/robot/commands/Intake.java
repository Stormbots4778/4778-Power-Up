package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {

    public Intake() {
    	
    }

    protected void initialize() {}

    protected void execute() {
    		Robot.intake.setSpeed(-0.35);
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
