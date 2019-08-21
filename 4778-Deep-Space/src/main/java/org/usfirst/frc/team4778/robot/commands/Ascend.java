package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Ascend extends CommandGroup {

	public Ascend() {
		addSequential(new LiftRear(true)); 
		addSequential(new AutoTimer(0.6));
		addSequential(new LiftFront(true));
		
		//Extend front and rear lifters
		
		addSequential(new AutoTimer(2));
		addParallel(new TimedGrab(0.2,true,1));
		
		addSequential(new LiftDrive(0.40,true,2)); //Position front of robot on upper level
		
		addSequential(new LiftFront(false)); //Retract front lifter
		addSequential(new AutoTimer(1));
		
		//old addSequential(new LiftDrive(0.4,true,1)); //Drive forward further onto upper level
		addSequential(new LiftDrive(0.45,true,1.3)); //Drive forward further onto upper level
		addParallel(new LiftDrive(0.4,false,1.3));
		
		addSequential(new LiftRear(false)); //Retract rear lifter
		//addSequential(new AutoTimer(2));
		
		addSequential(new LiftDrive(0.25,false,2)); //Drive all the way onto upper level
		addSequential(new LiftDrive(0.4,false,1));
	}
}