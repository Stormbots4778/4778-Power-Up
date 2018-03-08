package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.AutoCenter;
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
	
	public static String gameData;
	
	@Override
	public void robotInit() {
		//m_chooser.addDefault("Default Auto", new AutoCrossLine());
		//m_chooser.addObject("My Auto", new Auto());
		//SmartDashboard.putData("Auto mode", m_chooser);
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
		m_autonomousCommand = new AutoCenter();//m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

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
	}
	
	@Override
	public void testPeriodic() {
		
	}
}
