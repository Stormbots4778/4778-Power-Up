package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoTest.java
 * Testing command for autonomous
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
		addSequential(new Lift(true));
		//addSequential(new FoldGrabber(true));	
    	addSequential(new AutoEncoderTurn(0.7, Math.PI/3, 5));
		//addSequential(new AutoEncoderDrive(0.7, 200, 5));
    }
}