package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/*
 * FoldGrabber.java
 * Meant to unfold the grabbers at the start of the match
 */
public class FoldGrabber extends Command {

	private boolean isFinished = false;
	private boolean in;
    
    public FoldGrabber(boolean in) {
    	requires(Robot.grabber);
    	this.in = in;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.grabber.fold(in);
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
