package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.AutoCrossLine;
import org.usfirst.frc.team4778.robot.commands.AutoLeft;
import org.usfirst.frc.team4778.robot.commands.AutoRight;
import org.usfirst.frc.team4778.robot.commands.AutoTimerDrive;
import org.usfirst.frc.team4778.robot.subsystems.CubeManipulator;
import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4778.robot.subsystems.Grabber;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
* Robot.java
* Main robot class
*/
public class Robot extends TimedRobot {
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final DifferentialDrive m_drive = new DifferentialDrive(RobotMap.m_left, RobotMap.m_right);
	public static final CubeManipulator cubemanipulator = new CubeManipulator();
	public static final Grabber grabber = new Grabber();
	public static OI oi = new OI();
	
	public static final double DISTANCE_BETWEEN_WHEELS = 27.75; //inches
	public static final int WHEEL_DIAMETER = 6; 			   //inches
	public static final int PULSES_PER_REVOLUTION = 256; //PPR

	private static double totalDistance = 0;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	public static String gameData = "LLL"; // Sets as a garbage value
	
	@Override
	public void robotInit() {
		m_chooser.addDefault("No Auto (lame)", new AutoTimerDrive(0, 0));
		m_chooser.addObject("Cross Line", new AutoCrossLine());
		m_chooser.addObject("Auto Center Left", new AutoLeft(0, false));
		m_chooser.addObject("Auto Center Right", new AutoRight());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		CameraServer.getInstance().startAutomaticCapture();
		
		RobotMap.m_encoderLeft.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderRight.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// Get game data from FMS
		//gameData = DriverStation.getInstance().getGameSpecificMessage();
		gameData = "LLL"; // garbage
		SmartDashboard.putString("Game Data: ", gameData);
		
	m_autonomousCommand = m_chooser.getSelected();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		RobotMap.m_encoderLeft.reset();
		RobotMap.m_encoderRight.reset();
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Grabber Motors: ", RobotMap.m_grabMotors.get());
		SmartDashboard.putNumber("Intake Motors: ", RobotMap.m_cubeMotors.get());
		
		totalDistance += Math.abs( (RobotMap.m_encoderLeft.getDistance() + RobotMap.m_encoderRight.getDistance()) / 2);
		SmartDashboard.putNumber("Total Distance: ", totalDistance);
	}
	
	@Override
	public void testPeriodic() {
		
	}
}
