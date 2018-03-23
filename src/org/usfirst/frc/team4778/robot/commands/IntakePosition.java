package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
 * IntakePosition.java
 * Puts robot into intake position eg: Expands grabbers and puts cube manipulator down
 */
public class IntakePosition extends Command {

	private boolean isFinished = false;
	private double endTime;
    
    public IntakePosition() {
    	requires(Robot.grabber);
    	requires(Robot.cubemanipulator);
    }

    protected void initialize() {
    	endTime = Timer.getFPGATimestamp() + 3; // Sets timer for 3 seconds
    	Robot.grabber.fold(false);
    }

    protected void execute() {
    	if(Timer.getFPGATimestamp() >= endTime) {
        	Robot.cubemanipulator.lift(false); // Sets lift down
    		isFinished = true;
		}
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {}
    
    protected void interrupted() {
    	end();
    }
}
