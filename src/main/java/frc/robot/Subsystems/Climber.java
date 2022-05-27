// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Climber extends Subsystem {
  public static CANSparkMax rightClimber = new CANSparkMax(RobotMap.rightClimbPort, MotorType.kBrushless);
  public static CANSparkMax leftClimber = new CANSparkMax(RobotMap.leftClimbPort, MotorType.kBrushless);
  public static DoubleSolenoid climbRightPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.climbRightPistonForwardPort, RobotMap.climbRightPistonBackwardPort);

  public Climber(){}

  public void extendClimb(){
    rightClimber.set(0.7); //was -
    leftClimber.set(0.7);
  }

  public void retractClimb(){
    rightClimber.set(-0.7); //was +
    leftClimber.set(-0.7);
  }

  public void openAngle(){
    //climbLeftPiston.set(DoubleSolenoid.Value.kForward);
    climbRightPiston.set(DoubleSolenoid.Value.kForward); 
  }

  public void closeAngle(){
    //climbLeftPiston.set(DoubleSolenoid.Value.kReverse);
    climbRightPiston.set(DoubleSolenoid.Value.kReverse);
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
