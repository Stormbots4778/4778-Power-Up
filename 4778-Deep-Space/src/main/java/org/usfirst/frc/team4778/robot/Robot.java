package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.AutoCrossLineLevel1;
import org.usfirst.frc.team4778.robot.commands.AutoCrossLineLevel2;
import org.usfirst.frc.team4778.robot.commands.AutoDisk;
import org.usfirst.frc.team4778.robot.commands.AutoSphere;
import org.usfirst.frc.team4778.robot.commands.GetTeamColor;
import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4778.robot.subsystems.Grabber;
import org.usfirst.frc.team4778.robot.subsystems.Lifter;
import org.usfirst.frc.team4778.robot.subsystems.SphereManipulator;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.TimedRobot;

/*
* Robot.java
* Main robot class
*/
public class Robot extends TimedRobot {
	
	// Subsystems
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Grabber grabber = new Grabber();
	public static final Lifter lifter = new Lifter();
	public static final MecanumDrive m_drive = new MecanumDrive(RobotMap.m_leftFront, RobotMap.m_leftRear, RobotMap.m_rightFront, RobotMap.m_rightRear);
	public static final SphereManipulator spheremanipulator = new SphereManipulator();

	public static OI oi = new OI();
	
	public static final int PULSES_PER_REVOLUTION = 256; //PPR
	public static final int WHEEL_DIAMETER = 6; //inches
	public static final double DISTANCE_BETWEEN_WHEELS = 21.9; //inches

	public static double LF, LR, RF, RR; 
	public static double x = 0;
	public static double y = 0;
	public static double angle = 0;
	
	UsbCamera camForward;
	UsbCamera camDown;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	SendableChooser<Command> m_teamChooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		// Auto Chooser
		m_chooser.setDefaultOption("Cross Line Level 2", new AutoCrossLineLevel2());
		m_chooser.addOption("Cross Line Level 1", new AutoCrossLineLevel1());
		m_chooser.addOption("Disk", new AutoDisk());
		m_chooser.addOption("Sphere", new AutoSphere());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		// Team Chooser
		m_teamChooser.setDefaultOption("Blue", new GetTeamColor("Blue"));
		m_teamChooser.addOption("Red", new GetTeamColor("Red")); 
		SmartDashboard.putData("Team", m_teamChooser);

		camForward = CameraServer.getInstance().startAutomaticCapture(0);
		camForward.setResolution(240,135);
		camForward.setFPS(30);
		camDown = CameraServer.getInstance().startAutomaticCapture(1);
		camDown.setResolution(240,180);
		camDown.setFPS(30);
		camDown.setExposureManual(30);
		
		// Configure encoder pulse values
		RobotMap.m_encoderLeftFront.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderLeftRear.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderRightFront.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderRightRear.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
	}

	public void updateTelemetry() {
		LF = RobotMap.m_encoderLeftFront.getDistance();
		LR = RobotMap.m_encoderLeftRear.getDistance();
		RF = RobotMap.m_encoderRightFront.getDistance();
		RR = RobotMap.m_encoderRightRear.getDistance();
		angle = ((LF + LR) + (RF + RR)) / (4 * DISTANCE_BETWEEN_WHEELS);
		x = (((LF + RF) - (LR + RR)) / 4); // * Math.sin(angle);
		y = (((LF + LR) - (RF + RR)) / 4); // * Math.cos(angle);

		SmartDashboard.putNumber("Front Left Encoder", LF);
		SmartDashboard.putNumber("Back Left Encoder", LR);
		SmartDashboard.putNumber("Front Right Encoder", RF);
		SmartDashboard.putNumber("Back Right Encoder", RR);
		SmartDashboard.putNumber("angle", Math.toDegrees(angle) % 360);
		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		RobotMap.m_encoderLeftFront.reset();
		RobotMap.m_encoderLeftRear.reset();
		RobotMap.m_encoderRightFront.reset();
		RobotMap.m_encoderRightRear.reset();
		
		m_autonomousCommand = m_chooser.getSelected();
				
		if (m_autonomousCommand != null) {
			//m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		updateTelemetry();
	}

	@Override
	public void teleopInit() {	
		RobotMap.m_encoderLeftFront.reset();
		RobotMap.m_encoderLeftRear.reset();
		RobotMap.m_encoderRightFront.reset();
		RobotMap.m_encoderRightRear.reset();

		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		updateTelemetry();
	}
	
	@Override
	public void testPeriodic() {}
}