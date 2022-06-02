// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;//add compressor

import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Climber extends Subsystem {
  public static CANSparkMax rightClimber = new CANSparkMax(RobotMap.rightClimbPort, MotorType.kBrushless);
  public static CANSparkMax leftClimber = new CANSparkMax(RobotMap.leftClimbPort, MotorType.kBrushless);
  //public static DoubleSolenoid climbRightPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbRightPistonForwardPort, RobotMap.climbRightPistonBackwardPort);
  //public static DoubleSolenoid climbLeftPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbLeftPistonForwardPort, RobotMap.climbLeftPistonBackwardPort);
  public static DoubleSolenoid climbPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbPistonForwardPort, RobotMap.climbPistonBackwardPort);

  public static double distance; //distance from the wall
  public static double climbDistance;

  public Climber(){

  }

  public void extendClimb(){
   /* if(rightEncoder.getPosition() >= climbDistance){
      rightClimber.set(0.0);
      leftClimber.set(0.0);
    } //must spin in opp directions */
    rightClimber.set(-0.6);           
    //leftClimber.set(0.6);
  }

  public void retractClimb(){
    /*if(rightEncoder.getPosition() >= climbDistance){
      rightClimber.set(0.0);
      leftClimber.set(0.0);
    } //must spin in opp directions */
    rightClimber.set(0.6);
    //leftClimber.set(-0.6);
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

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
