package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenter extends CommandGroup {

    public AutoCenter() {
    	addSequential(new Lift(true));
		addSequential(new FoldGrabber(false));
		
		//addSequential(new AutoDrive(0.75, 0.25));
		addSequential(new TurnToAngle());
    }
}
