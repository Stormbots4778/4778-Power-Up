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
	
	private PIDController distancePID;
	private PIDController navxPID;
	
	private boolean isFinished;
	
	
    public AutoEncoderDrive(double speed, double distance) {
    		this.speed = speed;
    		this.distance = distance;
    		isFinished = false;
    		
    		distancePID = new PIDController(1.5, 0, 0, distance);
    		distancePID.setTolerence(1);
    		distancePID.setOutputLimits(-speed, speed);
    		
    		navxPID = new PIDController(0.5, 0, 0, 0);
    		navxPID.setTolerence(1);
    		navxPID.setOutputLimits(-0.5, 0.5);
    }

    protected void initialize() {
    		RobotMap.m_encoderLeft.reset();
    		RobotMap.m_encoderRight.reset();
    		RobotMap.ahrs.reset();
    }

    protected void execute() {
    	double distancePIDOutput = distancePID.computePID(RobotMap.m_encoderLeft.getDistance());
    	double navxPIDOutput = navxPID.computePID(RobotMap.ahrs.getYaw());
    	SmartDashboard.putNumber("PID Distance: ", distancePIDOutput);
    	SmartDashboard.putNumber("PID NavX: ", navxPIDOutput);
		Robot.m_drive.arcadeDrive(distancePIDOutput, navxPIDOutput);
		
		isFinished = distancePID.onTarget();
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
