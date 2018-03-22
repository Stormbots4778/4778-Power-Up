package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * AutoDrive.java
 * Used for moving in autonomous
 */
public class AutoEncoderDrive extends Command {
	
	private double speed;
	private double distance;
	
	private PIDController pid;
	
	private boolean isFinished;
	
    public AutoEncoderDrive(double speed, double distance) {
    		this.speed = speed;
    		this.distance = distance;
    		isFinished = false;
    		
    		//5.9375
    		pid = new PIDController(2.5, 0, 0, distance-7);
    		pid.setTolerence(3);
    		pid.setOutputLimits(-speed, speed);
    }

    protected void initialize() {
    		RobotMap.m_encoderLeft.reset();
    		RobotMap.m_encoderRight.reset();
    		RobotMap.ahrs.reset();
    }
    
    int i = 0;
    
    protected void execute() {
    	double leftPID = pid.computePID(RobotMap.m_encoderLeft.getDistance());
    	double rightPID = pid.computePID(RobotMap.m_encoderRight.getDistance());
    
    	SmartDashboard.putNumber("Left PID", leftPID);
    	SmartDashboard.putNumber("Right PID", rightPID);
    	
//    	if(pid.onTarget()) {
//    		isFinished = true;
//    	}
    	
		Robot.m_drive.tankDrive(leftPID, rightPID);
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
