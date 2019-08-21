package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
}
