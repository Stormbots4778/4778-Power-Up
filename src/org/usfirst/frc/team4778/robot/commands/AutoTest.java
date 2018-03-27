package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoTest.java
 * CommandGroup for testing various autonomouses
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
		addSequential(new Lift(true));
    	addSequential(new FoldGrabber(true));
    	addSequential(new AutoEncoderDrive(0.75, 120, 5));
    	addParallel(new Shoot(0.4), 1.5);
    	addSequential(new AutoTimer(0.5));
    	addSequential(new Push());
    	addSequential(new AutoEncoderTurn(0.7, 90, 1.5));
    }
}
