package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
 * AutoDrive.java
 * Used for moving in autonomous
 */
public class AutoTimerDrive extends Command {

	private double time;
	private double endTime;
	
	private double speed;
	
	private boolean isFinished;
	
    public AutoTimerDrive(double speed, double time) {
    		this.speed = speed;
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
		
		Robot.m_drive.tankDrive(speed, speed);
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    		Robot.m_drive.tankDrive(0, 0);
    }

    protected void interrupted() {
    		end();
    }
}
