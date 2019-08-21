package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* LiftFront.java
* Command that controls the piston that pushes the ball into the shooter motors
*/
public class Push extends Command {

    public Push() {}

    protected void initialize() {}

    protected void execute() {
    	Robot.spheremanipulator.push(true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.spheremanipulator.push(false);
    }

    protected void interrupted() {
    	end();
    }
}