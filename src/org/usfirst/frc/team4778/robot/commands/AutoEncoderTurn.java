package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * AutoDrive.java
 * Used for turning in autonomous
 */
public class AutoEncoderTurn extends Command {
	
	private double speed;
	private double angle;
	
	private PIDController pidLeft;
	private PIDController pidRight;
	
	private double time;
	private double endTime;
	
	private boolean isFinished;
	
	/*
	 * Tested P Values:
	 * 	0.0875 for pi/4
	 * 	0.05 for pi/2
	 */
	
    public AutoEncoderTurn(double speed, double angle, double time) {
    		this.speed = speed;
    		this.angle = angle;
    		this.time = time;
    }

    protected void initialize() {
    		RobotMap.m_encoderLeft.reset();
    		RobotMap.m_encoderRight.reset();
    		
    	   	endTime = 0;
    	   	isFinished = false;
    		
    		pidLeft = new PIDController(0.25, 0, 0, Robot.DISTANCE_BETWEEN_WHEELS * angle / 2);
    		pidRight = new PIDController(0.25, 0, 0, -Robot.DISTANCE_BETWEEN_WHEELS * angle / 2);
    		pidLeft.setTolerence(0.5);
    		pidRight.setTolerence(0.5);
    		pidLeft.setOutputLimits(-speed,speed);
    		pidRight.setOutputLimits(-speed,speed);

    		endTime = Timer.getFPGATimestamp() + time;
    }
    
    protected void execute() {
	    	double leftTurnPID = pidLeft.computePID(RobotMap.m_encoderLeft.getDistance());
	    	double rightTurnPID = pidRight.computePID(RobotMap.m_encoderRight.getDistance());
	    
	    	SmartDashboard.putNumber("Left Turn PID", leftTurnPID);
	    	SmartDashboard.putNumber("Right Turn PID", rightTurnPID);
	    	
		Robot.m_drive.tankDrive(leftTurnPID, rightTurnPID);
		
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
