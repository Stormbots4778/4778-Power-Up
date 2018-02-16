package org.usfirst.frc.team4778.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;

/*
* RobotMap
* Contains mapping for all of the robot's motor controllers
*/
public class RobotMap {
	
	// Left drivetrain motor controllers
	public static Victor m_frontLeft = new Victor(3);
	public static Victor m_rearLeft  = new Victor(4);
	static SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	
	// Right drivetrain motor controllers
	public static Victor m_frontRight = new Victor(1);
	public static Victor m_rearRight  = new Victor(2);
	static SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

	// Cube manipulator motor controllers
	public static Victor m_cubeBackLeft   = new Victor(5);
	public static Victor m_cubeFrontLeft  = new Victor(6);
	public static Victor m_cubeBackRight  = new Victor(7);
	public static Victor m_cubeFrontRight = new Victor(8);
	public static SpeedControllerGroup m_cubeMotors = new SpeedControllerGroup(m_cubeBackLeft,m_cubeFrontLeft,m_cubeBackRight,m_cubeFrontRight);
	
	// Grabber motor controllers
	//public static Victor m_grabberLeft = new Victor();
	//public static Victor m_grabberRight = new Victor();
	
	// Lift solenoids
	public static DoubleSolenoid m_liftSolenoid  = new DoubleSolenoid(0,1);
	
	// Grabber solenoids
	public static DoubleSolenoid m_grabberSolenoid  = new DoubleSolenoid(2,3);
	
	// Compressor
	public static Compressor compressor = new Compressor(0);

}
