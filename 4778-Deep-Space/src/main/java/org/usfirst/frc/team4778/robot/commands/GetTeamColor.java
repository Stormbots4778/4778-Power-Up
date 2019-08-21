package org.usfirst.frc.team4778.robot.commands;
import java.lang.String;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* GetTeamColor.java
* Command that gets the team color from the dashboard
*/
public class GetTeamColor extends Command {
  
  private String color;

  public GetTeamColor(String color) {
    this.color = color;
  }

  protected void initialize() {}

  protected void execute() {
    Robot.spheremanipulator.getTeamColor(color);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {}
}
