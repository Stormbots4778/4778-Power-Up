package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* LiftFront.java
* Command that handles the front lifter
*/
public class LiftFront extends Command {

	private boolean up;
	private boolean isFinished = false;
		
    public LiftFront(boolean up) {
    	this.up = up;
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.lifter.liftFront(up);
    	isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        isFinished = false;
    }

    protected void interrupted() {
    	end();
    }
}
