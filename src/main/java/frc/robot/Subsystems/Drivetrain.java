// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
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
 /* private static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  private static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
  private static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  private static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);

  private static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  private static MecanumDrive mecanum = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
*/
  public Drivetrain(){
    
  }
/*
  public static void driveTeleop() {
    double xSpeed = OI.driveJoy1.getX();
    double ySpeed = OI.driveJoy1.getY();
    double zRotation = OI.driveJoy2.getX();
    
    mecanum.driveCartesian(ySpeed, xSpeed, zRotation, gyro.getAngle());
  }

  
  public static void driveAuton(double xSpeed, double ySpeed, double zRotation, double angle){
    mecanum.driveCartesian(ySpeed, xSpeed, zRotation, gyro.getAngle());
  }
*/
  //auto align method
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveTeleop());
  }
}
