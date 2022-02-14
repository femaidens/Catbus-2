// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Climber extends Subsystem {
  public static CANSparkMax rightClimber = new CANSparkMax(RobotMap.rightClimbPort, MotorType.kBrushless);
  public static CANSparkMax leftClimber = new CANSparkMax(RobotMap.leftClimbPort, MotorType.kBrushless);
  public static DoubleSolenoid climbRightPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbRightPistonForwardPort, RobotMap.climbRightPistonBackwardPort);
  public static DoubleSolenoid climbLeftPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbLeftPistonForwardPort, RobotMap.climbLeftPistonBackwardPort);

  public static Ultrasonic ultrasonicLeft = new Ultrasonic(0, 0);
  public static Ultrasonic ultrasonicRight = new Ultrasonic(0, 0);

  public static double distance; //distance from the wall

  //drivetrain motors
  public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
  public static MecanumDrive mecanum = new MecanumDrive(frontLeft, frontLeft, frontLeft, frontLeft);
  //PID
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

  public Climber(){

  }

  public void extendClimb(){
    rightClimber.set(0.7);
    leftClimber.set(0.7);
  }

  public void retractClimb(){
    rightClimber.set(-0.7);
    leftClimber.set(-0.7);
  }

  public void openAngle(){
    climbLeftPiston.set(DoubleSolenoid.Value.kForward);
    climbRightPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void closeAngle(){
    climbLeftPiston.set(DoubleSolenoid.Value.kReverse);
    climbRightPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopClimb(){
    rightClimber.set(0);
    leftClimber.set(0);
  }

  public void alignClimb(){
    double leftUltrasonicDistance = ultrasonicLeft.getRangeInches();
    double rightUltrasonicDistance = ultrasonicRight.getRangeInches();

    //not done
    while(leftUltrasonicDistance != distance){
      previous_error = current_error;
      current_error = distance - leftUltrasonicDistance;
      integral = (current_error+previous_error)/2*(time);
      derivative = (current_error-previous_error)/time;
      adjust = Kp*current_error + Ki*integral + Kd*derivative;

      if (current_error > min_error){
        adjust += min_command;
      }
      else if (current_error < -min_error){
        adjust -= min_command;
      }

      if(current_error > 0){
        frontRight.set(0.3 + adjust);
        frontLeft.set(0.3 + adjust);
        rearRight.set(0.3 + adjust);
        rearLeft.set(0.3 + adjust);
      }

      else if(current_error < 0){
        frontRight.set(0.3 - adjust);
        frontLeft.set(0.3 - adjust);
        rearRight.set(0.3 - adjust);
        rearLeft.set(0.3 - adjust);
      }


    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
