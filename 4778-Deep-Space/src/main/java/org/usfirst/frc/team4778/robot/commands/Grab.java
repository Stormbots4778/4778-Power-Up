package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/*
* Grab.java
* Command that grabs disk
*/
public class Grab extends Command {
  private double speed;
  private boolean grabDisk;
  
  public Grab(double speed,boolean grabDisk) {
    this.speed = speed;
    this.grabDisk = grabDisk;
  }

  protected void initialize() {}

  protected void execute() {
    Robot.grabber.grab(speed,grabDisk);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    RobotMap.m_grabberMotor.set(0);
  }

  protected void interrupted() {
    end();
  }
}
