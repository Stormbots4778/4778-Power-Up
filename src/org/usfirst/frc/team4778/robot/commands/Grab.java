package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* Grab.java
* Command that handles robot grabber
*/
public class Grab extends Command{


	public Grab() {
        requires(Robot.grabber);
    }

    protected void initialize() {}

    protected void execute() {
    		Robot.grabber.grab();
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
