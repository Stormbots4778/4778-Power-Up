package org.usfirst.frc.team4778.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class RobotMap {
	// XXX: conditional controller
	public static boolean gamepadDrive = true;
	public static VictorSP L0 = new VictorSP(2);
	public static VictorSP L1 = new VictorSP(3);
	public static VictorSP R0 = new VictorSP(0);
	public static VictorSP R1 = new VictorSP(1);
	public static VictorSP V1 = new VictorSP(8);
	public static VictorSP V2 = new VictorSP(9);
	public static double speed = 0.5;
}
