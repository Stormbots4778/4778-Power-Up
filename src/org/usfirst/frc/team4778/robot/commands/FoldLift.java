package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * FoldLift.java
 * Folds the grabbers and lifts the cube manipulator
 */
public class FoldLift extends CommandGroup {

    public FoldLift() {
			addSequential(new Lift(true));
			addSequential(new AutoTimer(3));
			addSequential(new FoldGrabber(false));
    }
}
