// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class GyroTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static void getAngle(){
    System.out.println(gyro.getAngle());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new GyroTestCommand());
  }
}
