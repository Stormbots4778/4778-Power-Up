package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* LiftRear.java
* Command that handles the rear lifter
*/
public class LiftRear extends Command {

	private boolean up;
	private boolean isFinished = false;
		
    public LiftRear(boolean up) {
    	this.up = up;
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.lifter.liftRear(up);
    	isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
