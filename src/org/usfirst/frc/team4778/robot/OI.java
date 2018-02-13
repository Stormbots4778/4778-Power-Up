package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Intake;
import org.usfirst.frc.team4778.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/*
* OI.java
* Contains definitions for operator interfaces
*/
public class OI {
	public static Joystick gamepad = new Joystick(0);
	
	public static Button shoot = new JoystickButton(gamepad, 8);
	public static Button intake = new JoystickButton(gamepad, 7);
	
	public OI() {		
		shoot.whileHeld(new Shoot(1));
		intake.whileHeld(new Intake(1));
	}
}
