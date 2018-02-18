package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* Grab.java
* Command that handles robot grabber
*/
public class Grab extends Command{

	private boolean in;
	
	public Grab(boolean in) {
        requires(Robot.grabber);
        this.in = in;
    }

    protected void initialize() {}

    protected void execute() {
    		Robot.grabber.grab(in);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.grabber.stop();
    }

    protected void interrupted() {
    		end();
    }

}
