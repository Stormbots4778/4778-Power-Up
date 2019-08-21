package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	private static double speed = 0;

	public static double getSpeed() {
		return speed;
	}

	public static void setSpeed(double newSpeed) {
		// speed = newSpeed;
		if (newSpeed > 0) {
			speed = 0;
		} else if (newSpeed < -1.0) {
			// directional speed limiter
			// |-1.0| is already the maximum speed so this is unnecessary right now
			// it is kept here to provide the necessary control flow for future use
			speed = -1.0;
		} else {
			speed = newSpeed;
		}
	}

	@Override
	public void initDefaultCommand() {}
}
