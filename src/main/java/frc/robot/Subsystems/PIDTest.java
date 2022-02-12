// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.PIDTestCommand;
import com.ctre.phoenix.motorcontrol.ControlMode;
/** Add your docs here. */
public class PIDTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /*public static CANSparkMax motor = new CANSparkMax(RobotMap.motorPort, MotorType.kBrushless);
  public static SparkMaxPIDController motorPIDController = motor.getPIDController();
  public static RelativeEncoder motorEncoder = motor.getEncoder();
  public static double speed;

  public PIDTest() {
    motorPIDController.setP(1e-4);
    motorPIDController.setI(1e-6);
    motorPIDController.setD(1e-2);
    motorPIDController.setIZone(0);
    motorPIDController.setFF(0);
    motorPIDController.setOutputRange(-0.2,0.2);

  
  }

  public static void spinMotor(double s) {
    motor.set(speed);
    motorPIDController.setReference(s, ControlType.kVelocity);
    System.out.println(motorEncoder.getVelocity());
  }*/
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new PIDTestCommand());
  }
}
