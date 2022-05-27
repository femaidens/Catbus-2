// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** Add your docs here. */
public class TestMotor extends Subsystem { //to test radios
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANSparkMax testMotor = new CANSparkMax(RobotMap.testMotorPort, MotorType.kBrushless);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void spinForward(){
    testMotor.set(0.1);
    System.out.println("Motor spinning forward");
  }
  public void spinReverse(){
    testMotor.set(-0.1);
    System.out.println("Motor spinning backwards");
  }
  public void spinStop(){
    testMotor.set(0);
    System.out.println("Motor spinning stop");
  }
}
