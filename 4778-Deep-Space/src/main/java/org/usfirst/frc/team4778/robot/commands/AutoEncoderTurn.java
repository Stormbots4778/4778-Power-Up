package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
 * AutoEncoderTurn.java
 * Used for accurate turning in autonomous
 */
public class AutoEncoderTurn extends Command {
	
	private double speed;
	private double distance;
	
	private double time;
	private double endTime;
	
	private PIDController masterPIDrightFront;
	private PIDController slavePIDrightRear;
	private PIDController slavePIDleftFront;
	private PIDController slavePIDleftRear;

	private boolean isFinished;
  
	public AutoEncoderTurn(double speed, double angle, double time) {
		this.speed = speed;
		this.time = time;
		distance = -Math.toRadians(angle) * Robot.DISTANCE_BETWEEN_WHEELS;
	}

	protected void initialize() {
		RobotMap.m_encoderLeftFront.reset();
		RobotMap.m_encoderLeftRear.reset();
		RobotMap.m_encoderRightFront.reset();
		RobotMap.m_encoderRightRear.reset();
		
		endTime = 0;
		isFinished = false;
	
		masterPIDrightFront = new PIDController(0.1, 0, 0, distance);
		masterPIDrightFront.setTolerence(2);
		masterPIDrightFront.setOutputLimits(-speed, speed);

		slavePIDrightRear = new PIDController(0.2, 0, 0, 0);
		slavePIDrightRear.setTolerence(1);
		slavePIDrightRear.setOutputLimits(-0.4, 0.4);

		slavePIDleftFront = new PIDController(0.2, 0, 0, 0);
		slavePIDleftFront.setTolerence(2);
		slavePIDleftFront.setOutputLimits(-0.4, 0.4);

		slavePIDleftRear = new PIDController(0.2, 0, 0, 0);
		slavePIDleftRear.setTolerence(1);
		slavePIDleftRear.setOutputLimits(-0.4, 0.4);

		endTime = Timer.getFPGATimestamp() + time;
	}
			
	protected void execute() {
		slavePIDleftRear.setSetpoint(-RobotMap.m_encoderRightFront.getDistance());
		slavePIDleftFront.setSetpoint(-RobotMap.m_encoderRightFront.getDistance());
		slavePIDrightRear.setSetpoint(-RobotMap.m_encoderLeftFront.getDistance());
		
		double rightFrontPID = masterPIDrightFront.computePID(-RobotMap.m_encoderRightFront.getDistance());
		double rightRearPID = slavePIDrightRear.computePID(-RobotMap.m_encoderRightRear.getDistance());
		double leftFrontPID = slavePIDleftFront.computePID(-RobotMap.m_encoderLeftFront.getDistance());
		double leftRearPID = slavePIDleftRear.computePID(-RobotMap.m_encoderLeftRear.getDistance());
	
		RobotMap.m_rightFront.set(rightFrontPID);
		RobotMap.m_rightRear.set(rightRearPID);
		RobotMap.m_leftFront.set(leftFrontPID);
		RobotMap.m_leftRear.set(leftRearPID);

		isFinished = Timer.getFPGATimestamp() > endTime;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		RobotMap.m_leftFront.set(0);
		RobotMap.m_leftRear.set(0);
		RobotMap.m_rightFront.set(0);
		RobotMap.m_rightRear.set(0);
		
		isFinished = false;
	}

	protected void interrupted() {
		end();
	}
}
