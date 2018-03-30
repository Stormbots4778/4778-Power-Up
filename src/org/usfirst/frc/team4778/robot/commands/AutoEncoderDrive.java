package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * AutoDrive.java
 * Used for moving in autonomous
 */
public class AutoEncoderDrive extends Command {
	
	private double speed;
	private double distance;
	
	private double time;
	private double endTime;
	
	private PIDController masterPID;
	private PIDController slavePID;
	
	private boolean isFinished;
	
    public AutoEncoderDrive(double speed, double distance, double time) {
    		this.speed = speed;
    		this.distance = distance;
    		this.time = time;
    }

    protected void initialize() {
    		RobotMap.m_encoderLeft.reset();
    		RobotMap.m_encoderRight.reset();
    		
    		endTime = 0;
    		isFinished = false;
    		
    		//5.9375
    		masterPID = new PIDController(0.25, 0, 0, distance-7);
    		masterPID.setTolerence(3);
    		masterPID.setOutputLimits(-speed, speed);
    		
    		slavePID = new PIDController(0.75, 0, 0, 0);
    		slavePID.setTolerence(1);
    		slavePID.setOutputLimits(-speed, speed);
    		
    		endTime = Timer.getFPGATimestamp() + time;
    }
        
    protected void execute() {
    	slavePID.setSetpoint(RobotMap.m_encoderLeft.getDistance());
    	
    	double leftPID = masterPID.computePID(RobotMap.m_encoderLeft.getDistance());
	    double rightPID = slavePID.computePID(RobotMap.m_encoderRight.getDistance());
	    
	    SmartDashboard.putNumber("Left PID", leftPID);
	    SmartDashboard.putNumber("Right PID", rightPID);

		Robot.m_drive.tankDrive(leftPID, rightPID);
		
		isFinished = Timer.getFPGATimestamp() > endTime;
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
