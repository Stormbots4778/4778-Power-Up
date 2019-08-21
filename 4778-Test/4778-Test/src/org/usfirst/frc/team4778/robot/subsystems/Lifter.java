package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
* Lifter.java
* Subsystem that contains definitions for the front and rear lifters
*/
public class Lifter extends Subsystem {

    public void initDefaultCommand() {}
    
    public void liftFront(boolean up) {
    	if(up) {
    		RobotMap.m_frontLiftSolenoid.set(DoubleSolenoid.Value.kForward);
		} else {
			RobotMap.m_frontLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
    }
    
    public void liftRear(boolean up) {
    		if(up) {
    			RobotMap.m_rearLiftSolenoid.set(DoubleSolenoid.Value.kForward);
			} else {
				RobotMap.m_rearLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
			}
    }
    
    public void liftDrive(double speed,boolean backWheels) {
	    	if(backWheels) {
	    		RobotMap.m_lifterMotors.set(speed);
	    	} else {
	    		RobotMap.m_leftFront.set(-speed);
	    		RobotMap.m_rightFront.set(speed);
	    	}
    }
    
    public void stop() {
    		RobotMap.m_lifterMotors.set(0);
    }
}

