package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
* AutoTimer.java
* Used for timing
*/

public class AutoTimer extends Command {

	private double time;
	private double endTime;
		
	private boolean isFinished;
	
    public AutoTimer(double time) {
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
      isFinished = false;
    }

    protected void interrupted() {
    	end();
    }
}