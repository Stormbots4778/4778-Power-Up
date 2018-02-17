package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Grab;
import org.usfirst.frc.team4778.robot.commands.Intake;
import org.usfirst.frc.team4778.robot.commands.Lift;
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
	
	public static Button lift_up = new JoystickButton(gamepad, 4);
	public static Button lift_down = new JoystickButton(gamepad, 2);
	
	public static Button grab = new JoystickButton(gamepad, 6);
	
	public OI() {		
		shoot.whileHeld(new Shoot(1));
		intake.whileHeld(new Intake(0.3));
		
		lift_up.whileActive(new Lift(true));
		lift_down.whileActive(new Lift(false));
		
		grab.whileHeld(new Grab());
	}
}
