package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoCenter.java
 * Autonomous from center
 */
public class AutoCenter extends CommandGroup {

    public AutoCenter(boolean shouldWait) {
    		
    		// Init
    		if(shouldWait) addSequential(new AutoTimer(3));
    		addSequential(new Lift(true));
    		addSequential(new FoldGrabber(true));
		
    		if(Robot.gameData.charAt(0) == 'L') {
					// Drive
					addSequential(new AutoEncoderDrive(0.7, 37, 2)); // Drive forward 37 inches (3' 1")
					addSequential(new AutoEncoderTurn(0.7, -1.04, 1.5)); // ~77 degrees ccw
					addSequential(new AutoEncoderDrive(0.7, 69, 4)); // Drive forward 95 inches (7' 11")
					addSequential(new AutoEncoderTurn(0.7, 1.04, 1.5)); // ~77 degrees cw
					addSequential(new AutoEncoderDrive(0.7, 34, 2)); // Drive forward 37 inches (3' 1")
			
    		} else {
					//Drive
					addSequential(new AutoEncoderDrive(0.7, 37, 2)); // Drive forward 37 inches (3' 1")
					addSequential(new AutoEncoderTurn(0.7, 0.94, 1.5)); // ~57 degrees cw
					addSequential(new AutoEncoderDrive(0.7, 60, 2)); // Drive forward 50 inches (4' 2")
					addSequential(new AutoEncoderTurn(0.7, -0.94, 1.5)); // ~57 degrees ccw
					addSequential(new AutoEncoderDrive(0.7, 34, 2)); // Drive forward 60 inches (5')
	    		
    		}
    		// Shoot
    		addParallel(new Shoot(0.35), 2); // 35% power
    		addSequential(new AutoTimer(0.5)); // give it half a second to spin up
    		addSequential(new Push());
    }
}