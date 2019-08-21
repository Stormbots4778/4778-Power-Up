package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* AutoCrossLineLevel1.java
* Autonomous for only crossing the line
*/
public class AutoCrossLineLevel1 extends CommandGroup {
  
  public AutoCrossLineLevel1() {
    addSequential(new AutoEncoderDrive(0.3,124,7));
  }
}