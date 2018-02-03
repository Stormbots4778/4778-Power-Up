package org.usfirst.frc.team4778.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public static Joystick gamepad;
	
	public OI() {
		gamepad = new Joystick(0);
	}
}
