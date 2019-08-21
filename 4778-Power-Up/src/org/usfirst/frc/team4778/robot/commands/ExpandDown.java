package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * ExpandDown.java
 * Expands grabbers and force lift down
 */
public class ExpandDown extends CommandGroup {

    public ExpandDown() {
    	addSequential(new FoldGrabber(false));
    	addSequential(new AutoTimer(5));
    	addSequential(new Lift(false));
    }
}
