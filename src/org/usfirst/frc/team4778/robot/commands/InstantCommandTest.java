package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class InstantCommandTest extends InstantCommand {

    public InstantCommandTest() {
    	requires(Robot.grabber);
    	requires(Robot.cubemanipulator);
    }

    // Called once when the command executes
    protected void initialize() {
    	
    }

}
