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
    		addSequential(new FoldGrabber(false));
		
    		if(Robot.gameData.charAt(0) == 'L') {
			
					// Drive
					addSequential(new AutoEncoderDrive(0.7, 37)); // Drive forward 37 inches (3' 1")
					addSequential(new AutoEncoderTurn(0.7, -0.53)); // ~30 degrees ccw
					addSequential(new AutoEncoderDrive(0.7, 69)); // Drive forward 69 inches (5' 9")
					addSequential(new AutoEncoderTurn(0.7, 0.53)); // ~30 degrees cw
					addSequential(new AutoEncoderDrive(0.7, 34)); // Drive forward 34 inches (2' 10")
				
		    		// Shoot
		    		addParallel(new Shoot(0.35)); // 35% power
		    		addSequential(new AutoTimer(0.5)); // give it half a second to spin up
		    		addSequential(new Push());
			
    		} else {
			
					// Drive
					addSequential(new AutoEncoderDrive(0.7, 37)); // Drive forward 37 inches (3' 1")
					addSequential(new AutoEncoderTurn(0.7, 0.63)); // ~36 degrees cw
					addSequential(new AutoEncoderDrive(0.7, 60)); // Drive forward 60 inches (5')
					addSequential(new AutoEncoderTurn(0.7, -0.63)); // ~36 degrees ccw
					addSequential(new AutoEncoderDrive(0.7, 34)); // Drive forward 34 inches (2' 10")
				
		    		// Shoot
		    		addParallel(new Shoot(0.35)); // 35% power
		    		addSequential(new AutoTimer(0.5)); // give it half a second to spin up
		    		addSequential(new Push());
	    		
    		}
    		
    }
}