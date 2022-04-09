// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeMotorPort, MotorType.kBrushless);
  public static CANSparkMax intakeExtendMotor = new CANSparkMax(RobotMap.intakeExtendPort, MotorType.kBrushless);
  //public static Encoder intakeEncoder = new Encoder(RobotMap.encoderPort1, RobotMap.encoderPort2);
  public static DutyCycleEncoder intakeEncoder = new DutyCycleEncoder(RobotMap.intakeEncoderPort);
  public static double intakeDistance;
  public static double intakeDownDistance;

  //PID fields
  /*public final static double Kp1 = 0.01;
  public final static double Ki1 = 0.0;
  public final static double Kd1 = 0.0;
  //public double distance, left_speed, right_speed;
  public double left_speed1, right_speed1;
  static double min_error1 = 0.1; //sets an error deadband/ minimum value
  static double min_command1 = 0.0;
  static double current_error1 = 0; 
  static double previous_error1 = 0;
  static double integral1 = 0;
  static double derivative1 = 0;
  static double adjust1 = 0;
  static double time1 = 0.1; // 0.1 seconds = 100 milliseconds 

  //PID fields
  public final static double Kp2 = 0.01;
  public final static double Ki2 = 0.0;
  public final static double Kd2 = 0.0;
  //public double distance, left_speed, right_speed;
  public double left_speed2, right_speed2;
  static double min_error2 = 0.1; //sets an error deadband/ minimum value
  static double min_command2 = 0.0;
  static double current_error2 = 0; 
  static double previous_error2 = 0;
  static double integral2 = 0;
  static double derivative2 = 0;
  static double adjust2 = 0;
  static double time2 = 0.1; // 0.1 seconds = 100 milliseconds*/

  public void stopExtendMotor(){
    intakeExtendMotor.set(0.0);
  }

  public void downIntake(){
    intakeExtendMotor.set(0.5);
  }

	//intake
	public void startIntake(){
    intakeMotor.set(0.3);
  }

  public void stopIntake(){
	  intakeMotor.set(0.0);
  }

  public void reverseIntake(){
    intakeMotor.set(-0.3);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
