package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
* LiftDrive.java
* Command that handles the wheels on the bottom of the rear lifter
*/
public class LiftDrive extends Command {
	
	private double time;
	private double endTime;
	private boolean isFinished = false;

	private double speed;
	private boolean rearWheels;
	
    public LiftDrive(double speed,boolean rearWheels,double time) {
    	this.rearWheels = rearWheels;
    	this.speed = speed;
    	this.time = time;
		}
		
		public LiftDrive(double speed, boolean rearWheels)
		{
			this.rearWheels = rearWheels;
			this.speed = speed;
			this.time = 0;
		}

    protected void initialize() {
    	endTime = Timer.getFPGATimestamp() + time;
    }

    protected void execute() {
    	if ((Timer.getFPGATimestamp() >= endTime) && (time != 0)) {
				isFinished = true;
			}
			Robot.lifter.liftDrive(speed,rearWheels);
    }

    protected boolean isFinished() {
      return isFinished;
    }

    protected void end() {
			RobotMap.m_lifterMotors.set(0);
			isFinished = false;
    }

    protected void interrupted() {
    	end();
    }
}
