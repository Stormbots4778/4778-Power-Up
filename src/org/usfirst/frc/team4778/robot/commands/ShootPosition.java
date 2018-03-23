package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
 * ShootPosition.java
 * Puts robot into shoot position eg: Puts cube manipulator up and folds grabbers in
 */
public class ShootPosition extends Command {

	private boolean isFinished = false;
	private double endTime;
    
    public ShootPosition() {
    	requires(Robot.grabber);
    	requires(Robot.cubemanipulator);
    }

    protected void initialize() {
    	endTime = Timer.getFPGATimestamp() + 6; // Sets timer for 6 seconds
    	Robot.cubemanipulator.lift(true); // Sets lift up
    }

    protected void execute() {
    	if (Timer.getFPGATimestamp() >= endTime) {
        	Robot.grabber.fold(true); // Folds grabbers
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
