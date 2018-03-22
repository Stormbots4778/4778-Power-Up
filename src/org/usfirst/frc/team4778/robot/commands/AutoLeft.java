package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoCenter.java
 * Autonomous from left of center
 * 
 * Priority: 0 = switch
 * 			 1 = scale
 */
public class AutoLeft extends CommandGroup {

    public AutoLeft(int priority) {
    		// Init
    		addSequential(new AutoTimer(3));
    		addSequential(new Lift(true));
		addSequential(new FoldGrabber(false));
		
		// Drive
		if(Robot.gameData.charAt(priority) == 'L') {
			if(priority == 0) { // Switch
				addSequential(new AutoEncoderDrive(0.7, 152));
				addSequential(new AutoEncoderTurn(0.7, Math.PI/2)); // 90 degrees cw
				addSequential(new AutoEncoderDrive(0.7, 20));
				addParallel(new Shoot(0.35));
				addSequential(new AutoTimer(0.5));
				addSequential(new Push());
			} else {
//				addSequential(new AutoEncoderDrive(0.7, 324));
//				addSequential(new AutoEncoderTurn(0.7, Math.PI/2)); // 90 degrees cw
//				addSequential(new AutoEncoderDrive(0.7, -20)); // ???
//				addParallel(new Shoot(0.8));
//				addSequential(new AutoTimer(1));
//				addSequential(new Push());
			}
		} else if(Robot.gameData.charAt(priority == 0 ? 1 : 0) == 'L') {
			//addSequential(new AutoEncoderDrive(0.7, ?));
			//addSequential(new TurnToAngle(90));
			//addParallel(new Shoot(0.8));
			//addSequential(new AutoTimer(1));
			//addSequential(new Push());
		}
		//addSequential(new AutoTimerDrive(0.7, 2));
    }
}