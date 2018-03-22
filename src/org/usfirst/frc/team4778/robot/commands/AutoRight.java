package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoCenter.java
 * Autonomous from left of center
 */
public class AutoRight extends CommandGroup {

    public AutoRight() {
    	addSequential(new AutoTimer(3));
    	addSequential(new Lift(true));
		addSequential(new FoldGrabber(false));
		addSequential(new AutoTimerDrive(0.7, 2));
		addSequential(new AutoTimer(1));
		if(Robot.gameData.charAt(0) == 'R') {
			addParallel(new Shoot(0.35));
			addSequential(new AutoTimer(1));
			addSequential(new Push());
		}
    }
}