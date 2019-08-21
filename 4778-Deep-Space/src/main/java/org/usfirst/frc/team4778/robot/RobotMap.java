package org.usfirst.frc.team4778.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay;

/*
* RobotMap
* Contains mapping for all of the robot's motor controllers
*/
public class RobotMap {
	
	// Left Front drivetrain motor controller
	public static WPI_TalonSRX m_leftFront = new WPI_TalonSRX(1);
	public static Encoder m_encoderLeftFront = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
	
	// Left Rear drivetrain motor controller
	public static WPI_TalonSRX m_leftRear = new WPI_TalonSRX(3);
	public static Encoder m_encoderLeftRear = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	//Right Front drivetrain motor controller
	public static WPI_TalonSRX m_rightFront = new WPI_TalonSRX(2);
	public static Encoder m_encoderRightFront = new Encoder(7, 6, false, Encoder.EncodingType.k4X);
	
	// Right Rear drivetrain motor controller
	public static WPI_TalonSRX m_rightRear = new WPI_TalonSRX(0);
	public static Encoder m_encoderRightRear = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	// Lifter motor controllers
	public static WPI_TalonSRX m_lifterLeft = new WPI_TalonSRX(4);
	public static WPI_TalonSRX m_lifterRight = new WPI_TalonSRX(5);
	public static SpeedControllerGroup m_lifterMotors = new SpeedControllerGroup(m_lifterLeft, m_lifterRight);

	// Shooter motor controllers
	public static WPI_TalonSRX m_shooterLeft = new WPI_TalonSRX(6);
	public static WPI_TalonSRX m_shooterRight = new WPI_TalonSRX(7);
	public static SpeedControllerGroup m_shooterMotors = new SpeedControllerGroup(m_shooterLeft, m_shooterRight);
	
	// Grabber motor controllers
	public static WPI_TalonSRX m_grabberMotor = new WPI_TalonSRX(8);
	
	// Front lifter solenoid
	public static DoubleSolenoid m_frontLiftSolenoid = new DoubleSolenoid(0,1);
	
	// Rear lifter solenoid
	public static DoubleSolenoid m_rearLiftSolenoid = new DoubleSolenoid(2,3);
	
	// Pusher solenoid
	public static DoubleSolenoid m_pusherSolenoid = new DoubleSolenoid(4,5);

	// LED strip relays
	public static Relay blueLeds = new Relay(0);
	//public static Relay redLeds = new Relay(1);

	// Compressor
	public static Compressor m_compressor = new Compressor();
}