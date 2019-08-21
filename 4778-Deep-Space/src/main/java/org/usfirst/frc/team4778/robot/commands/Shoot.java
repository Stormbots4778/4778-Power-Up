package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* Shoot.java
* Command that handles the sphere manipulator shooter
*/
public class Shoot extends Command {

    private double speed;
	
    public Shoot(double speed) {
        requires(Robot.spheremanipulator);
        this.speed = speed;
    }

    protected void initialize() {}

    protected void execute() {
        Robot.spheremanipulator.shoot(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
  	    Robot.spheremanipulator.stop();
    }

    protected void interrupted() {
        end();
    }
}
