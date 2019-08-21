package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
* Drivetrain.java
* Subsystem that contains definitions for the robot drivetrain
*/
public class Drivetrain extends Subsystem {
	
    public void initDefaultCommand() {
    		setDefaultCommand(new Drive());
    }
}

