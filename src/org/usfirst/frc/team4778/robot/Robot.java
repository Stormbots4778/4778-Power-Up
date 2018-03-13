package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.AutoCenterLeft;
import org.usfirst.frc.team4778.robot.commands.AutoCenterRight;
import org.usfirst.frc.team4778.robot.commands.AutoCrossLine;
import org.usfirst.frc.team4778.robot.commands.AutoDrive;
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

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	public static String gameData = "AAA";
	
	@Override
	public void robotInit() {
		m_chooser.addDefault("No Auto", new AutoDrive(0, 0));
		m_chooser.addObject("Cross Line", new AutoCrossLine());
		m_chooser.addObject("Auto Center Left", new AutoCenterLeft());
		m_chooser.addObject("Auto Center Right", new AutoCenterRight());
		SmartDashboard.putData("Auto mode", m_chooser);
		CameraServer.getInstance().startAutomaticCapture();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
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
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Grabber Motors: ", RobotMap.m_grabMotors.get());
		SmartDashboard.putNumber("Intake Motors: ", RobotMap.m_cubeMotors.get());

	}
	
	@Override
	public void testPeriodic() {
		
	}
	
	
}
