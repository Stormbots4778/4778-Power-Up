package org.usfirst.frc.team4778.robot;

// Note: WPI_TalonSRX must be used to support the updated RobotDrive
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/*
* RobotMap
* Contains mapping for all of the robot's motor controllers
*/
public class RobotMap {
	
	// Left drivetrain motor controllers
	public static WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(7);
	public static WPI_TalonSRX m_rearLeft  = new WPI_TalonSRX(9);
	static SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	public static Encoder m_encoderLeft = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	// Right drivetrain motor controllers
	public static WPI_TalonSRX m_frontRight = new WPI_TalonSRX(10);
	public static WPI_TalonSRX m_rearRight  = new WPI_TalonSRX(6);
	static SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
	public static Encoder m_encoderRight = new Encoder(2, 3, true, Encoder.EncodingType.k4X);

	// Cube manipulator motor controllers (relative to robot's perspective)
	public static WPI_TalonSRX m_cubeBackLeft   = new WPI_TalonSRX(8);
	public static WPI_TalonSRX m_cubeFrontLeft  = new WPI_TalonSRX(2);
	public static WPI_TalonSRX m_cubeBackRight  = new WPI_TalonSRX(4);
	public static WPI_TalonSRX m_cubeFrontRight = new WPI_TalonSRX(3);
	public static SpeedControllerGroup m_cubeMotors = new SpeedControllerGroup(m_cubeBackLeft,m_cubeFrontLeft,m_cubeBackRight,m_cubeFrontRight);
	
	// Grabber motor controllers
	public static WPI_TalonSRX m_grabberLeft  = new WPI_TalonSRX(1);
	public static WPI_TalonSRX m_grabberRight = new WPI_TalonSRX(5);
	public static SpeedControllerGroup m_grabMotors = new SpeedControllerGroup(m_grabberLeft, m_grabberRight);
	
	// Lift solenoids
	public static DoubleSolenoid m_liftSolenoid   = new DoubleSolenoid(2,3);
	public static DoubleSolenoid m_pusherSolenoid = new DoubleSolenoid(4,5);
	
	// Grabber solenoids
	public static DoubleSolenoid m_grabberSolenoid  = new DoubleSolenoid(0,1);
	
	public static Compressor m_compressor = new Compressor();
}