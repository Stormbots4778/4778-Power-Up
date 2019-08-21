package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
* Grab.java
* Command that grabs disk
*/
public class TimedGrab extends Command {
  private double time;
  private double endTime;
  private boolean isFinished = false;

  private double speed;
  private boolean grabDisk;
  
  public TimedGrab(double speed,boolean grabDisk,double time) {
    this.speed = speed;
    this.grabDisk = grabDisk;
    this.time = time;
  }

  protected void initialize() {
    endTime = Timer.getFPGATimestamp() + time;
  }

  protected void execute() {
    if (Timer.getFPGATimestamp() >= endTime) {
      isFinished = true;
    }
    Robot.grabber.grab(speed,grabDisk);
  }

  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {
    RobotMap.m_grabberMotor.set(0);
    isFinished = false;
  }

  protected void interrupted() {
    end();
  }
}