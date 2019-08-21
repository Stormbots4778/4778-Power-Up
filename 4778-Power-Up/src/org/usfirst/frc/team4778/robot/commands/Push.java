package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Push extends Command {
	
    public Push() {
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.cubemanipulator.push(true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
		Robot.cubemanipulator.push(false);
    }

    protected void interrupted() {
    		end();
    }
}
