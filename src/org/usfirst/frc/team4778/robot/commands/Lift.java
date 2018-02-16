package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/*
* Lift.java
* Command that handles the cube manipulator lift
*/
public class Lift extends Command {

	private boolean up;
	
	public Lift(boolean up) {
		this.up = up;
	}
	
    protected void initialize() {}

    protected void execute() {
    		Robot.cubemanipulator.lift(up);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    		end();
    }
}
