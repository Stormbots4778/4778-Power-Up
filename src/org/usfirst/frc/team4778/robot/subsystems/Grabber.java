package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
* Grabber.java
* Subsystem that contains definitions for the robot grabber
*/
public class Grabber extends Subsystem {
		
	public void initDefaultCommand() {}	
    
    public void grab(boolean in) {
    	if(in) {
    		RobotMap.m_grabMotors.set(0.6);
    	} else {
    		RobotMap.m_grabMotors.set(-0.6);
    	}
    	return;
    }
    
    public void fold(boolean in) {
   		if(in) {
			RobotMap.m_grabberSolenoid.set(DoubleSolenoid.Value.kForward);
		} else {
			RobotMap.m_grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
    }
    
    public void stop() {
    	RobotMap.m_grabMotors.set(0);
    	return;
    }
}
