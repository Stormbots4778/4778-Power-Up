package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * FoldUp.java
 * Fold grabbers and force lift up
 */
public class FoldUp extends CommandGroup {

    public FoldUp() {
    	addSequential(new Lift(true));
    	addSequential(new Time(1));
    	addSequential(new FoldGrabber(true));
    }
}
