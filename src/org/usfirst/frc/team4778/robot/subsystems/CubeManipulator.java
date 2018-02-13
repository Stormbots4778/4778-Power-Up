package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

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
    public void stop() {
    	RobotMap.m_cubeMotors.set(0);
    }
}

