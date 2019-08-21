package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.RunShooter;
import org.usfirst.frc.team4778.robot.commands.IncreaseSpeed;
import org.usfirst.frc.team4778.robot.commands.DecreaseSpeed;
import org.usfirst.frc.team4778.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick gamepad = new Joystick(2);
	public static Button gamepadA = new JoystickButton(gamepad, 1);
	public static Button gamepadRightBumper = new JoystickButton(gamepad, 6);
	public static Button gamepadLeftBumper = new JoystickButton(gamepad, 5);

	public OI() {
		gamepadA.toggleWhenPressed(new RunShooter());
		gamepadRightBumper.whenPressed(new IncreaseSpeed());
		gamepadLeftBumper.whenPressed(new DecreaseSpeed());
	}
}
