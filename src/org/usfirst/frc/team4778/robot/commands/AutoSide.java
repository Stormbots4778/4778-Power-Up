package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * AutoSide.java
 * Autonomous from either left or right side
 * 
 * Priority: 0 = switch
 * 			 1 = scale
 */
public class AutoSide extends CommandGroup {

    public AutoSide(char side, int priority, boolean shouldWait) {
    		
    		// Init
    		if(shouldWait) addSequential(new AutoTimer(3));
    		addSequential(new Lift(true));
    		addSequential(new FoldGrabber(true));
		
    		// Logic Stuff
    		if(priority == 0) {
    				if(Robot.gameData.charAt(0) == side) {
    						switchAuto(side);
    				} else if(Robot.gameData.charAt(1) == side) {
    						scaleAuto(side);
    				} else {
    						crossLineAuto(side);
    				}
    		
    		} else if(priority == 1) {
    				if(Robot.gameData.charAt(1) == side) {
    						scaleAuto(side);
    				} else if(Robot.gameData.charAt(0) == side) {
    						switchAuto(side);
    				} else {
    						crossLineAuto(side);
    				}
    		
    		}
    }
    
    private void switchAuto(char side) {
			addSequential(new AutoEncoderDrive(0.7, 160, 3)); // Drive forward 152 inches (12' 8")
			
			if(side == 'L') addSequential(new AutoEncoderTurn(0.7, Math.PI/2, 2)); // 90 degrees cw for left
			else if(side == 'R') addSequential(new AutoEncoderTurn(0.7, -Math.PI/2, 2)); // or 90 degrees ccw for right
			
			addSequential(new AutoEncoderDrive(0.7, 52, 2)); //Drive forward against the switch (52 inches)
			
    		// Shoot
    		addParallel(new Shoot(0.35), 2); // 35% power
    		addSequential(new AutoTimer(0.5)); // give it half a second to spin up
    		addSequential(new Push());
    }
    
    private void scaleAuto(char side) {
			addSequential(new AutoEncoderDrive(0.7, 276, 8)); // Drive forward 280 inches (23' 4")
			
			if(side == 'L') addSequential(new AutoEncoderTurn(0.7, 1.1, 2.5)); // ~63 degrees cw for left
			else if(side == 'R')  addSequential(new AutoEncoderTurn(0.7, -1.1, 2.5)); // ~63 degrees ccw for right
			
			addSequential(new AutoEncoderDrive(0.7, -25.5, 2)); // Drive backwards 18 inches (1' 6")
			
			// Shoot
			addParallel(new Shoot(0.8), 2); // 80% power
    		addSequential(new AutoTimer(0.5)); // give it half a second to spin up
    		addSequential(new Push());
    }
    
    private void crossLineAuto(char side) {
    	addSequential(new AutoEncoderDrive(0.7, 220, 5)); // Drive forward 220 inches (18' 4")
    	
		if(side == 'L') addSequential(new AutoEncoderTurn(0.7, Math.PI/2, 2.5)); // 90 degrees cw for left
		else if(side == 'R') addSequential(new AutoEncoderTurn(0.7, -Math.PI/2, 2.5)); // or 90 degrees ccw for right
		
		addSequential(new AutoEncoderDrive(0.7, 144, 4)); // Drive forward 144 inches (12')
    }
}