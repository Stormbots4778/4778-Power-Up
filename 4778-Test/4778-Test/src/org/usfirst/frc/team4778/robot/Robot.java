package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4778.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
* Robot.java
* Main robot class
*/
public class Robot extends TimedRobot {
	
	// Subsystems
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final MecanumDrive m_drive = new MecanumDrive(RobotMap.m_leftFront, RobotMap.m_leftRear, RobotMap.m_rightFront, RobotMap.m_rightRear);
	public static final Lifter lifter = new Lifter();
	
	public static OI oi = new OI();
	
	//Command m_autonomousCommand;
	//SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	
	@Override
	public void robotInit() {
		
		// Auto Chooser
		//SmartDashboard.putData("Auto mode", m_chooser);
		
		// Initialize the camera server
		//CameraServer.getInstance().startAutomaticCapture();
		
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
						
//		m_autonomousCommand = m_chooser.getSelected();
//				
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.start();
//		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {			
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.cancel();
//		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {}
}
