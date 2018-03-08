package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoCenter.java
 * Autonomous from center line
 */
public class AutoCenter extends CommandGroup {

    public AutoCenter() {
    	addSequential(new Lift(true));
		addSequential(new FoldGrabber(false));
		addSequential(new AutoDrive(0.75, 0.5));
		
		if(Robot.gameData.charAt(0) == 'L') {
			addSequential(new TurnToAngle());
		} else {
			addSequential(new TurnToAngle());
		}
    }
}
