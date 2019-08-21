package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

/*
* Robot.java
* Main robot class
*/
public class Robot extends TimedRobot {

	public static Timer timer = new Timer();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final DifferentialDrive m_drive = new DifferentialDrive(RobotMap.m_left, RobotMap.m_right);
	public static OI oi = new OI();
	

	@Override
	public void robotInit() {}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {}
}