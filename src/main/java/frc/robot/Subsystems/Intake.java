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

	//retract piston
	public void retract(){
    double extendedDistance = intakeEncoder.getAbsolutePosition();
    while(intakeEncoder.getAbsolutePosition() - extendedDistance < intakeDistance){
      intakeExtendMotor.set(-0.3);
    }
    intakeExtendMotor.set(0.0);
  }

  public void stopExtendMotor(){
    intakeExtendMotor.set(0.0);
  }

  public void downIntake(){
    intakeExtendMotor.set(0.5);
    //stopIntake();
    /*while(intakeEncoder.getDistance() < intakeDownDistance){
      previous_error2 = current_error2;
      current_error2 = intakeDownDistance - intakeEncoder.getDistance();
      integral2 = (current_error2+previous_error2)/2*(time2);
      derivative2 = (current_error2-previous_error2)/time2;
      adjust2 = Kp2*current_error2 + Ki2*integral2 + Kd2*derivative2;

      if (current_error2 > min_error2){
        adjust2 += min_command2;
      }
      else if (current_error2 < -min_error2){
        adjust2 -= min_command2;
      }
      
      intakeExtendMotor.set(adjust2);

    } */
  }

	//intake
	public void startIntake(){
    //wait few milliseconds
    //stopExtendMotor();
    intakeMotor.set(0.3);
    /*while(intakeEncoder.getDistance() < intakeDistance){
      previous_error1 = current_error1;
      current_error1 = intakeDistance - intakeEncoder.getDistance();
      integral1 = (current_error1+previous_error1)/2*(time1);
      derivative1 = (current_error1-previous_error1)/time1;
      adjust1 = Kp1*current_error1 + Ki1*integral1 + Kd1*derivative1;

      if (current_error1 > min_error1){
        adjust1 += min_command1;
      }
      else if (current_error1 < -min_error1){
        adjust1 -= min_command1;
      }
      
      intakeExtendMotor.set(adjust1);

    } */
		//intakeMotor.set(0.0);
  }

  public void stopIntake(){
	  intakeMotor.set(0.0);
  }

  public void reverseIntake(){
    intakeMotor.set(-0.3);
  }
  public void holdIntakeArm(){
    double distance = 0.40; //test for this value tomorrow with absolute encoder
    double margin = 0.065; //test for this value tmr
    while(intakeEncoder.getAbsolutePosition() != distance){
      if(intakeEncoder.getAbsolutePosition() > distance + margin){
        intakeMotor.set(0.0); //if arm is greater than 37 degrees let arm fall down
      }
      else if(intakeEncoder.getAbsolutePosition() < distance - margin){
        intakeMotor.set(0.4); //if arm is less than 37 degress let it move up
      }
      else{
        intakeMotor.set(0.1); //if arm is between margin; let it stay there
      }
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
