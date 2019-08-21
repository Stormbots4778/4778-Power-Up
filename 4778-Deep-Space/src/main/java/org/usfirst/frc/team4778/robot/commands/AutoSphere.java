package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* AutoSphere.java
* Autonomous for scoring a ball
*/
public class AutoSphere extends CommandGroup {

  public AutoSphere() {
    //addSequential(new Descend());
    addSequential(new AutoEncoderTurn(0.35,-45,2.5));
  }
}
