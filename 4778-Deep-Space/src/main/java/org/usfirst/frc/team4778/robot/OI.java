package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Ascend;
import org.usfirst.frc.team4778.robot.commands.Descend;
import org.usfirst.frc.team4778.robot.commands.Grab;
import org.usfirst.frc.team4778.robot.commands.LiftDrive;
import org.usfirst.frc.team4778.robot.commands.LiftFront;
import org.usfirst.frc.team4778.robot.commands.LiftRear;
import org.usfirst.frc.team4778.robot.commands.Push;
import org.usfirst.frc.team4778.robot.commands.Shoot;
import org.usfirst.frc.team4778.robot.commands.TimedGrab;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
* OI.java
* Contains definitions for operator interfaces
*/
public class OI {
	public static Joystick joystickLeft = new Joystick(0);
	public static Joystick joystickRight = new Joystick(1);

	public static Button intake = new JoystickButton(joystickLeft, 2);
	public static Button shoot = new JoystickButton(joystickLeft, 1);

	public static Button push = new JoystickButton(joystickLeft, 1);

	public static Button release_disk = new JoystickButton(joystickRight, 1); 
	public static Button grab_disk = new JoystickButton(joystickRight, 2);
	
	public static Button lift_front_up = new JoystickButton(joystickRight, 6); //comment out when not testing
	public static Button lift_rear_up = new JoystickButton(joystickLeft, 11); //comment out when not testing
	public static Button lift_front_down = new JoystickButton(joystickRight, 7); //comment out when not testing
	public static Button lift_rear_down = new JoystickButton(joystickLeft, 10); //comment out when not testing
	
	public static Button descend = new JoystickButton(joystickLeft,7);
	public static Button ascend = new JoystickButton(joystickRight,11);

	public static Button lift_drive_forward = new JoystickButton(joystickRight, 8);
	public static Button lift_drive_backward = new JoystickButton(joystickRight, 9);

	public OI() {
		intake.toggleWhenPressed(new Shoot(-0.1));
		shoot.toggleWhenPressed(new Shoot(0.35));

		push.whileHeld(new Push());
		//pushR.whileHeld(new Push());
		
		grab_disk.whileHeld(new Grab(0.2,true));
		release_disk.whenPressed(new TimedGrab(0.6,false,0.06));

		//comment out when not testing
		lift_front_up.whileActive(new LiftFront(true));
		lift_rear_up.whileActive(new LiftRear(true));
		lift_front_down.whileActive(new LiftFront(false));
		lift_rear_down.whileActive(new LiftRear(false));
		//comment out when not testing

		ascend.whenPressed(new Ascend());
		descend.whenPressed(new Descend());
		
		//comment out when not testing
		lift_drive_forward.whileHeld(new LiftDrive(0.4, true));
		lift_drive_backward.whileHeld(new LiftDrive(-0.4, true));
	}
}