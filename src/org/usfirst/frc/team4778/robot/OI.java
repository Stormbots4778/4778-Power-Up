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
	public static Joystick joystickLeft = new Joystick(1);
	public static Joystick joystickRight = new Joystick(0);
	
	public static Button shootScale = new JoystickButton(joystickRight, 3);
	public static Button shootSwitch = new JoystickButton(joystickLeft, 3);
	
	public static Button intake = new JoystickButton(joystickLeft, 5);
	
	public static Button grab = new JoystickButton(joystickRight, 4);
	public static Button rGrab = new JoystickButton(joystickRight, 5);
	
	public static Button pushL = new JoystickButton(joystickLeft, 1);
	public static Button pushR = new JoystickButton(joystickRight, 1);
	
	public static Button lift_up = new JoystickButton(joystickRight, 2);
	public static Button lift_down = new JoystickButton(joystickLeft, 2);
	
	public static Button temp_grabbers = new JoystickButton(joystickLeft, 4);
	
	public OI() {
		shootSwitch.toggleWhenPressed(new Shoot(1));
		shootScale.toggleWhenPressed(new Shoot(0.5));
		intake.toggleWhenPressed(new Intake(0.3));
		
		lift_up.whileActive(new Lift(true));
		lift_down.whileActive(new Lift(false));
		
		pushL.whileHeld(new Push());
		pushR.whileHeld(new Push());
		
		grab.toggleWhenPressed(new Grab(true));
		rGrab.toggleWhenPressed(new Grab(false));
		
		temp_grabbers.whenPressed(new FoldGrabber());
	}
}
