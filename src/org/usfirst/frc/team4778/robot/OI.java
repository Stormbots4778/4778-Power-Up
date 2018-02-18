package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.FoldGrabber;
import org.usfirst.frc.team4778.robot.commands.Grab;
import org.usfirst.frc.team4778.robot.commands.Intake;
import org.usfirst.frc.team4778.robot.commands.Lift;
import org.usfirst.frc.team4778.robot.commands.Push;
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
	
	public static Button shoot = new JoystickButton(gamepad, 8);  // Right Trigger
	public static Button intake = new JoystickButton(gamepad, 7); // Left Trigger
	
	public static Button grab = new JoystickButton(gamepad, 6); // Right Bumper
	public static Button rGrab = new JoystickButton(gamepad, 5); // Left Bumper
	
	public static Button push = new JoystickButton(gamepad, 1); // X
	
	public static Button lift_up = new JoystickButton(gamepad, 4);   // Y
	public static Button lift_down = new JoystickButton(gamepad, 2); // A
	
	
	public static Button temp_grabbers = new JoystickButton(gamepad, 3); // B (temporary)
	
	public OI() {
		shoot.whileHeld(new Shoot(1));
		intake.whileHeld(new Intake(0.3));
		
		lift_up.whileActive(new Lift(true));
		lift_down.whileActive(new Lift(false));
		
		push.whileHeld(new Push());
		
		grab.whileHeld(new Grab(true));
		rGrab.whileHeld(new Grab(false));
		
		
		temp_grabbers.whileActive(new FoldGrabber(true));
	}
}
