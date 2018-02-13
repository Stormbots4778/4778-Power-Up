package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* Intake.java
* Command that handles the cube manipulator intake
*/
public class Intake extends Command {

	private double speed;

    public Intake(double speed) {
        requires(Robot.cubemanipulator);
		this.speed = speed;
    }

    protected void initialize() {}

    protected void execute() {
    		Robot.cubemanipulator.intake(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.cubemanipulator.stop();
    }

    protected void interrupted() {
    		end();
    }
}
