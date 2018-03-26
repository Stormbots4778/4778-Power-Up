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
		addSequential(new FoldGrabber(false));
		
		// Everything else
		if(priority == 0) switchAuto(side);
		else if(priority == 1) scaleAuto(side);

    }
    
    private void switchAuto(char side) {
    		if(Robot.gameData.charAt(0) == side) {
        		addSequential(new AutoEncoderDrive(0.7, 152)); // Drive forward 152 inches (12' 8")
        		
        		if(side == 'L') addSequential(new AutoEncoderTurn(0.7, Math.PI/2)); // 90 degrees cw for left
        		else if(side == 'R') addSequential(new AutoEncoderTurn(0.7, -Math.PI/2)); // or 90 degrees ccw for right
        		
        		addSequential(new AutoEncoderDrive(0.7, 20)); //Drive forward against the switch (20 inches)
        		
        		// Shoot
        		addParallel(new Shoot(0.35)); // 35% power
        		addSequential(new AutoTimer(0.5)); // give it half a second to spin up
        		addSequential(new Push());
    		}
    }
    
    private void scaleAuto(char side) {
    		if(Robot.gameData.charAt(1) == side) {
	    		addSequential(new AutoEncoderDrive(0.7, 276)); // Dirve forward 276 inches (23')
	    		
	    		if(side == 'L') addSequential(new AutoEncoderTurn(0.7, 1.1)); // ~63 degrees cw for left
	    		else if(side == 'R')  addSequential(new AutoEncoderTurn(0.7, -1.1)); // ~63 degrees ccw for right
	    			
	    		addSequential(new AutoEncoderDrive(0.7, -25.5)); // Drive backwards 25.5 inches (2' 1.5")
			
	    		// Shoot
			addParallel(new Shoot(0.8)); // 80% power
			addSequential(new AutoTimer(1)); // give it one second to spin up
			addSequential(new Push());
    		}
    }
}