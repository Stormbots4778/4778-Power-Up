package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * ExpandDown.java
 * Unfolds the grabbers and lowers the cube manipulator
 */
public class ExpandDown extends CommandGroup {

    public ExpandDown() {
		addSequential(new FoldGrabber(false));
		addSequential(new AutoTimer(3));
		addSequential(new Lift(false));
    }
}
