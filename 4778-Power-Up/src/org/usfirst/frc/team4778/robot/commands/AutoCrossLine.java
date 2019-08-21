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
			addSequential(new AutoEncoderDrive(0.7, 160, 3)); // Drive forward 152 inches (12' 8")
    }
}
