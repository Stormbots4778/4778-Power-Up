package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.FiftyPercent;
import org.usfirst.frc.team4778.robot.commands.OneHundredPercent;
import org.usfirst.frc.team4778.robot.commands.RunShooter;
import org.usfirst.frc.team4778.robot.commands.SeventyFivePercent;
import org.usfirst.frc.team4778.robot.commands.TwentyFivePercent;
import org.usfirst.frc.team4778.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick gamepad = new Joystick(2);
	public static Button gamepadRightBumper = new JoystickButton(gamepad, 6);
	public static JoystickButton gamepadUp = new JoystickButton(gamepad, 4);
	public static JoystickButton gamepadDown = new JoystickButton(gamepad, 1);
	public static JoystickButton gamepadLeft = new JoystickButton(gamepad, 3);
	public static JoystickButton gamepadRight = new JoystickButton(gamepad, 2);

	public OI() {
		Shooter.setSpeed(-0.35);
		gamepadRightBumper.toggleWhenPressed(new RunShooter());
		gamepadUp.whileHeld(new TwentyFivePercent());
		gamepadRight.whileHeld(new FiftyPercent());
		gamepadDown.whileHeld(new SeventyFivePercent());
		gamepadLeft.whileHeld(new OneHundredPercent());
	}
}
