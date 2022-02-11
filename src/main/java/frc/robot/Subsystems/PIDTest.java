// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.PIDTestCommand;

/** Add your docs here. */
public class PIDTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static CANSparkMax motor = new CANSparkMax(RobotMap.motorPort, MotorType.kBrushless);
  public static SparkMaxPIDController motorPIDController = motor.getPIDController();
  

  public PIDTest() {

  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new PIDTestCommand());
  }
}
