// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.Commands.DriveTeleop;

/** Add your docs here. */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //fields

	//mecanum motor controllers
  public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);

  private static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static RelativeEncoder rightEncoder = frontRight.getEncoder();
  public static RelativeEncoder leftEncoder = frontLeft.getEncoder();
  private static MecanumDrive mecanum = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

  public Drivetrain(){
    
  }

  public static void driveTeleop() {
    double xSpeed = OI.driveJoy1.getX();
    double ySpeed = OI.driveJoy1.getY();
    double zRotation = OI.driveJoy2.getX();
    
    mecanum.driveCartesian(ySpeed, xSpeed, zRotation, gyro.getAngle());
  }

  
  public static void driveAuton(double xSpeed, double ySpeed, double zRotation, double angle){
    mecanum.driveCartesian(ySpeed, xSpeed, zRotation, gyro.getAngle());
  }

  public static void driveStraightDistance(double distance){
    double rightDistance = rightEncoder.getPosition();
    double leftDistance = leftEncoder.getPosition();
    while(distance < rightDistance && distance < leftDistance){
      frontLeft.set(0.3);
      rearLeft.set(0.3);
      frontRight.set(0.3);
      rearRight.set(0.3);
      if(leftDistance < rightDistance){
        frontLeft.set(0.3);
        rearLeft.set(0.3);
        frontRight.set(0.0);
        rearRight.set(0.0);
      }
      else if(leftDistance > rightDistance){
        frontLeft.set(0.0);
        rearLeft.set(0.0);
        frontRight.set(0.3);
        rearRight.set(0.3);
      }
    }
  }

  public static void turnDegrees(double angle){
    if(angle > 180){
      angle = -(360 - angle);
    }

    while(gyro.getAngle() != angle){
      if(angle < 0){
        frontLeft.set(0.3);
        rearLeft.set(0.3);
        frontRight.set(-0.3);
        rearRight.set(-0.3);
      }
      else if(angle > 0){
        frontLeft.set(-0.3);
        rearLeft.set(-0.3);
        frontRight.set(0.3);
        rearRight.set(0.3);
      }
    }
    frontLeft.set(0.0);
    rearLeft.set(0.0);
    frontRight.set(0.0);
    rearRight.set(0.0);
  }

  public static void driveStop(){
    frontLeft.set(0.0);
    rearLeft.set(0.0);
    frontRight.set(0.0);
    rearRight.set(0.0);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveTeleop());
  }
}
