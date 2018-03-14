package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
* Grabber.java
* Subsystem that contains definitions for the robot grabber
*/
public class Grabber extends Subsystem {
	
	private boolean isFolded;
	
	public void initDefaultCommand() {	}	
    
    public void grab(boolean in) {
    		if(in) {
    			RobotMap.m_grabMotors.set(0.6);
    		} else {
    			RobotMap.m_grabMotors.set(-0.6);
    		}
    		return;
    }
    
    public void fold(boolean in) {
    	isFolded = in;
   		if(in) {
   			isFolded = true;
			RobotMap.m_grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else {
			isFolded = false;
			RobotMap.m_grabberSolenoid.set(DoubleSolenoid.Value.kForward);
		}
    }
    
    public boolean isFolded() {
    	return isFolded;
    }
    
    public void stop() {
    		RobotMap.m_grabMotors.set(0);
    		return;
    }
}
