package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.LiftFront;
import org.usfirst.frc.team4778.robot.commands.LiftRear;
import org.usfirst.frc.team4778.robot.commands.Ascend;
import org.usfirst.frc.team4778.robot.commands.LiftDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
* OI.java
* Contains definitions for operator interfaces
*/

public class OI {
	public static Joystick joystickLeft = new Joystick(0);
	public static Joystick joystickRight = new Joystick(1);
	
	public static Button lift_front_up = new JoystickButton(joystickRight, 6); //comment out when not testing
	public static Button lift_rear_up = new JoystickButton(joystickLeft, 11); //comment out when not testing
	public static Button lift_front_down = new JoystickButton(joystickRight, 7); //comment out when not testing
	public static Button lift_rear_down = new JoystickButton(joystickLeft, 10); //comment out when not testing
	
	public static Button ascend = new JoystickButton(joystickLeft,2); //change to better button

	public OI() {
		lift_front_up.whileActive(new LiftFront(true));
		lift_rear_up.whileActive(new LiftRear(true));
		lift_front_down.whileActive(new LiftFront(false));
		lift_rear_down.whileActive(new LiftRear(false));
		ascend.whenPressed(new Ascend());
	}
}
