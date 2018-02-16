package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
* CubeManipulator.java
* Subsystem that contains definitions for the cube manipulator
*/
public class CubeManipulator extends Subsystem {
	
    public void initDefaultCommand() {}
    
    public void shoot(double speed) {
    		RobotMap.m_cubeMotors.set(speed);
    }
    
    public void intake(double speed) {
    		RobotMap.m_cubeMotors.set(-speed);
    }
    
    public void push(boolean out) {
    		if(out) {
    			RobotMap.m_pusherSolenoid.set(DoubleSolenoid.Value.kForward);
    		} else {
    			RobotMap.m_pusherSolenoid.set(DoubleSolenoid.Value.kReverse);
    		}
    }
    
    public void lift(boolean up) {
    		if(up) {
    			RobotMap.m_liftSolenoid.set(DoubleSolenoid.Value.kForward);
    		} else {
    			RobotMap.m_liftSolenoid.set(DoubleSolenoid.Value.kReverse);
    		}
    }
    public void stop() {
    		RobotMap.m_cubeMotors.set(0);
    		//RobotMap.m_liftSolenoid.set(DoubleSolenoid.Value.kOff);
    }
}

