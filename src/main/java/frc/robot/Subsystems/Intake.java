// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorSensorV3.MainControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeMotorPort, MotorType.kBrushless);
  public static CANSparkMax intakeExtendMotor = new CANSparkMax(RobotMap.intakeExtendPort, MotorType.kBrushless);
  public static Encoder intakeEncoder = new Encoder(RobotMap.encoderPort1, RobotMap.encoderPort2);
  public static double intakeDistance;

  //PID fields
  public final static double Kp = 0.01;
  public final static double Ki = 0.0;
  public final static double Kd = 0.0;
  //public double distance, left_speed, right_speed;
  public double left_speed, right_speed;
  static double min_error = 0.1; //sets an error deadband/ minimum value
  static double min_command = 0.0;
  static double current_error = 0; 
  static double previous_error = 0;
  static double integral = 0;
  static double derivative = 0;
  static double adjust = 0;
  static double time = 0.1; // 0.1 seconds = 100 milliseconds 

	//extend piston
	public void extend(){
    
	}

	//retract piston
	public void retract(){
    double extendedDistance = intakeEncoder.getDistance();
    while(intakeEncoder.getDistance() - extendedDistance < intakeDistance){
      intakeExtendMotor.set(-0.3);
    }
    intakeExtendMotor.set(0.0);
  }

  public void stopExtendMotor(){
    intakeExtendMotor.set(0.0);
  }

	//intake
	public void startIntake(){
    //wait few milliseconds
    stopExtendMotor();
    intakeMotor.set(0.3);
    while(intakeEncoder.getDistance() < intakeDistance){
      previous_error = current_error;
      current_error = intakeDistance - intakeEncoder.getDistance();
      integral = (current_error+previous_error)/2*(time);
      derivative = (current_error-previous_error)/time;
      adjust = Kp*current_error + Ki*integral + Kd*derivative;

      if (current_error > min_error){
        adjust += min_command;
      }
      else if (current_error < -min_error){
        adjust -= min_command;
      }
      
      intakeExtendMotor.set(adjust);

    } 
		intakeMotor.set(0.0);
  }

  public void stopIntake(){
	  intakeMotor.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
