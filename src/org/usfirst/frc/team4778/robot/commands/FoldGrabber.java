package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/*
 * FoldGrabber.java
 * Meant to unfold the grabbers at the start of the match
 */
public class FoldGrabber extends Command {

	private boolean in;
	
    public FoldGrabber(boolean in) {
        requires(Robot.grabber);
    		this.in = in;
    }

    protected void initialize() {
    }

    protected void execute() {
    	//if(RobotMap.m_liftSolenoid.get().equals(DoubleSolenoid.Value.kReverse)) {
    		Robot.grabber.fold(in);
    	//}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.grabber.fold(!in);
    }
    
    protected void interrupted() {
    		end();
    }
}
