package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoCenter.java
 * Autonomous from left of center
 */
public class AutoCenterLeft extends CommandGroup {

    public AutoCenterLeft() {
    	addSequential(new Time(3));
    	addSequential(new Lift(true));
		addSequential(new FoldGrabber(false));
		addSequential(new AutoDrive(0.7, 2));
		addSequential(new Time(1));
		if(Robot.gameData.charAt(0) == 'L') {
			addParallel(new Shoot(0.35));
			addSequential(new Time(1));
			addSequential(new Push());
		}
    }
}
