package org.usfirst.frc.team4778.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

/*
* RobotMap
* Contains mapping for all of the robot's motor controllers
*/
public class RobotMap {
	
	// Left drivetrain motor controllers
	public static VictorSP m_frontLeft = new VictorSP(3);
	public static VictorSP m_rearLeft  = new VictorSP(4);
	public static SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	public static Encoder m_encoderLeft = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	// Right drivetrain motor controllers
	public static VictorSP m_frontRight = new VictorSP(1);
	public static VictorSP m_rearRight  = new VictorSP(2);
	public static SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
	public static Encoder m_encoderRight = new Encoder(2, 3, false, Encoder.EncodingType.k4X);

	// Cube manipulator motor controllers
	public static VictorSP m_cubeBackLeft   = new VictorSP(5);
	public static VictorSP m_cubeFrontLeft  = new VictorSP(6);
	public static VictorSP m_cubeBackRight  = new VictorSP(7);
	public static VictorSP m_cubeFrontRight = new VictorSP(8);
	public static SpeedControllerGroup m_cubeMotors = new SpeedControllerGroup(m_cubeBackLeft,m_cubeFrontLeft,m_cubeBackRight,m_cubeFrontRight);
	
	// Grabber motor controllers
	public static VictorSP m_grabberLeft = new VictorSP(0);
	public static VictorSP m_grabberRight = new VictorSP(9);
	public static SpeedControllerGroup m_grabMotors = new SpeedControllerGroup(m_grabberLeft, m_grabberRight);
	
	// Lift solenoids
	public static DoubleSolenoid m_liftSolenoid  = new DoubleSolenoid(2,3);
	public static DoubleSolenoid m_pusherSolenoid = new DoubleSolenoid(4,5);
	
	// Grabber solenoids
	public static DoubleSolenoid m_grabberSolenoid  = new DoubleSolenoid(0,1);
	
	public static AHRS ahrs = new AHRS(SerialPort.Port.kMXP);
}
