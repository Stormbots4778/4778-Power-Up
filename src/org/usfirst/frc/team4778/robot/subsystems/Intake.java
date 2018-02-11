package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
    public void initDefaultCommand() {
    		
    }
    
    public void setSpeed(double speed) {
    		RobotMap.I0.set(-speed);
    		RobotMap.I1.set(speed);
    		RobotMap.I2.set(speed);
    		RobotMap.I3.set(-speed);
    }
    
    public void setSpeed(double front, double back) {
	    	RobotMap.I0.set(-back);
	    	RobotMap.I1.set(back);
	    	RobotMap.I2.set(front);
	    	RobotMap.I3.set(-front);
    }
}

