package org.usfirst.frc.team4778.robot.subsystems;
//import java.lang.String;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
* SphereManipulator.java
* Subsystem that contains definitions for ball shooter
*/
public class SphereManipulator extends Subsystem {

  private boolean isBlue = false;

  public void initDefaultCommand() {}

  public void shoot(double speed) {
    RobotMap.m_shooterMotors.set(speed);
    if(RobotMap.m_shooterMotors.get() != 0)
    {
      RobotMap.blueLeds.set(Relay.Value.kForward);
    }
  }
  
  public void getTeamColor(String color) {
    if(color == "Blue") {
      isBlue = true;
    } else if(color == "Red") {
      isBlue = false;
    }
  }
  
  public void push(boolean out) {
    if(out) {
      RobotMap.m_pusherSolenoid.set(DoubleSolenoid.Value.kForward);
    } else {
      RobotMap.m_pusherSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void stop() {
    RobotMap.m_shooterMotors.set(0);
    RobotMap.blueLeds.set(Relay.Value.kOff);
    //RobotMap.redLeds.set(Relay.Value.kOff);
  }
}
