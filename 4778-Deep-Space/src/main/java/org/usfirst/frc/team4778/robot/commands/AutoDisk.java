package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* AutoDisk.java
* Autonomous for scoring a disk
*/
public class AutoDisk extends CommandGroup {

  public AutoDisk() {
    addSequential(new Descend());
    addSequential(new AutoTimer(1));
    addSequential(new AutoEncoderTurn(0.35,-165,3));
    addSequential(new AutoEncoderDrive(0.4,85,4.75));
    addSequential(new AutoEncoderTurn(0.35,-20,2));
    addSequential(new AutoEncoderDrive(0.3,30,1.25));
    //addSequential(new TimedGrab(0.8,false,0.06));
  }
}
