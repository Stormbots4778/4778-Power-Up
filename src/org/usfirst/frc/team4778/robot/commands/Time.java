package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
 * Time.java
 * Used for timing
 */
public class Time extends Command {

	private double time;
	private double endTime;
		
	private boolean isFinished;
	
    public Time(double time) {
    		this.time = time;
    		isFinished = false;
    }

    protected void initialize() {
    		endTime = Timer.getFPGATimestamp() + time;
    }

    protected void execute() {
		if (Timer.getFPGATimestamp() >= endTime) {
			isFinished = true;
		}	
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
