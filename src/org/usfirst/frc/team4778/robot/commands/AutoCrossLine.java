package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoCrossLine.java
 * Crosses the line :/
 */
public class AutoCrossLine extends CommandGroup {

    public AutoCrossLine() {
			addSequential(new Lift(true));
    		addSequential(new FoldGrabber(true));
    		addSequential(new AutoTimerDrive(0.75, 1.25));
    }
}
