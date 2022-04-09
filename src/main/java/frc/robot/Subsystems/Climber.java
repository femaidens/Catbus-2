// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;//add compressor

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
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
  //public static DoubleSolenoid climbRightPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbRightPistonForwardPort, RobotMap.climbRightPistonBackwardPort);
  //public static DoubleSolenoid climbLeftPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbLeftPistonForwardPort, RobotMap.climbLeftPistonBackwardPort);
  public static DoubleSolenoid climbPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbPistonForwardPort, RobotMap.climbPistonBackwardPort);

  //public static Ultrasonic ultrasonicLeft = new Ultrasonic(0, 0);
  //public static Ultrasonic ultrasonicRight = new Ultrasonic(0, 0);

  public static double distance; //distance from the wall
  public static double climbDistance;

  //drivetrain motors
  /*public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
  public static MecanumDrive mecanum = new MecanumDrive(frontLeft, frontLeft, frontLeft, frontLeft);
  public static RelativeEncoder rightEncoder = frontRight.getEncoder();
  public static RelativeEncoder leftEncoder = frontLeft.getEncoder();
  */
  //PID
  public final static double KpLeft = 0.01;
  public final static double KiLeft = 0.0;
  public final static double KdLeft = 0.0;
  static double min_errorLeft = 0.1; //sets an error deadband/ minimum value
  static double min_commandLeft = 0.0;
  static double current_errorLeft = 0; 
  static double previous_errorLeft = 0;
  static double integralLeft = 0;
  static double derivativeLeft = 0;
  static double adjustLeft = 0;
  static double timeLeft = 0.1; // 0.1 seconds = 100 milliseconds 

  public final static double KpRight = 0.01;
  public final static double KiRight = 0.0;
  public final static double KdRight = 0.0;
  static double min_errorRight = 0.1; //sets an error deadband/ minimum value
  static double min_commandRight = 0.0;
  static double current_errorRight = 0; 
  static double previous_errorRight = 0;
  static double integralRight = 0;
  static double derivativeRight = 0;
  static double adjustRight = 0;
  static double timeRight = 0.1; // 0.1 seconds = 100 milliseconds 

  public Climber(){

  }

  public void extendClimb(){
   /* if(rightEncoder.getPosition() >= climbDistance){
      rightClimber.set(0.0);
      leftClimber.set(0.0);
    } //must spin in opp directions */
    rightClimber.set(-0.3);
    leftClimber.set(0.3);
  }

  public void retractClimb(){
    /*if(rightEncoder.getPosition() >= climbDistance){
      rightClimber.set(0.0);
      leftClimber.set(0.0);
    } //must spin in opp directions */
    rightClimber.set(0.3);
    leftClimber.set(-0.3);
  }

  public void openAngle(){
    climbPiston.set(DoubleSolenoid.Value.kForward);
    //climbRightPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void closeAngle(){
    climbPiston.set(DoubleSolenoid.Value.kReverse);
    //climbRightPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopClimb(){
    rightClimber.set(0);
    leftClimber.set(0);
  }

  public void alignClimb(){
    /*double leftUltrasonicDistance = ultrasonicLeft.getRangeInches();
    double rightUltrasonicDistance = ultrasonicRight.getRangeInches();

    //not done
    while(leftUltrasonicDistance != distance || rightUltrasonicDistance != distance){
      previous_errorLeft = current_errorLeft;
      current_errorLeft = distance - leftUltrasonicDistance;
      integralLeft = (current_errorLeft+previous_errorLeft)/2*(timeLeft);
      derivativeLeft = (current_errorLeft-previous_errorLeft)/timeLeft;
      adjustLeft = KpLeft*current_errorLeft + KiLeft*integralLeft + KdLeft*derivativeLeft;

      if (current_errorLeft > min_errorLeft){
        adjustLeft += min_commandLeft;
      }
      else if (current_errorLeft < -min_errorLeft){
        adjustLeft -= min_commandLeft;
      }

      if(current_errorLeft > 0){
        frontLeft.set(0.3 + adjustLeft);
        rearLeft.set(0.3 + adjustLeft);
      }

      else if(current_errorLeft < 0){
        frontLeft.set(0.3 - adjustLeft);
        rearLeft.set(0.3 - adjustLeft);
      }


      //Right
      previous_errorRight = current_errorRight;
      current_errorRight = distance - rightUltrasonicDistance;
      integralRight = (current_errorRight+previous_errorRight)/2*(timeRight);
      derivativeRight = (current_errorRight-previous_errorRight)/timeRight;
      adjustRight = KpRight*current_errorRight + KiRight*integralRight + KdRight*derivativeRight;

      if (current_errorRight > min_errorRight){
        adjustRight += min_commandRight;
      }
      else if (current_errorRight < -min_errorRight){
        adjustRight -= min_commandRight;
      }

      if(current_errorRight > 0){
        frontRight.set(0.3 + adjustRight);
        rearRight.set(0.3 + adjustRight);
      }

      else if(current_errorRight < 0){
        frontRight.set(0.3 - adjustRight);
        rearRight.set(0.3 - adjustRight);
      }


    }*/
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
