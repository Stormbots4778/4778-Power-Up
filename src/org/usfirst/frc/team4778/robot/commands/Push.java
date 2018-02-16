package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Push extends Command {

	private boolean out;
	
    public Push(boolean out) {
    		this.out = out;
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.cubemanipulator.push(out);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
