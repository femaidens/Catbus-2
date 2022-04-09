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
	//mecanum motor controllers
  public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);

  //public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static RelativeEncoder rightEncoder = frontRight.getEncoder();
  public static RelativeEncoder leftEncoder = frontLeft.getEncoder();
  
  public static MecanumDrive mecanum = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

  public static double deadzone = 0.05;

  //PID fields
  /*public final static double Kp = 0.01;
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
  static double time = 0.1;*/ // 0.1 seconds = 100 milliseconds 

  public static Limelight limelight = new Limelight();

  public static int currentLimit;

  public Drivetrain(){
    /*frontRight.setSmartCurrentLimit(currentLimit);
    rearRight.setSmartCurrentLimit(currentLimit);
    frontLeft.setSmartCurrentLimit(currentLimit);
    rearLeft.setSmartCurrentLimit(currentLimit);*/
  }

  public static void driveTeleop() {
    //mecanum.driveCartesian(ySpeed, xSpeed, zRotation, gyro.getAngle());
    //mecanum.driveCartesian(zRotation, xSpeed, ySpeed);
    //mecanum.driveCartesian(zRotation, xSpeed, ySpeed, 0);

    frontRight.setInverted(true);
    rearRight.setInverted(true);
    //mecanum.driveCartesian(-ySpeed, xSpeed, zRotation);
    //mecanum.driveCartesian(-OI.driveJoy1.getY(), OI.driveJoy1.getX(), OI.driveJoy2.getX(), gyro.getAngle());
    mecanum.driveCartesian(-OI.driveJoy1.getY(), OI.driveJoy1.getX(), OI.driveJoy2.getX(),0);
  }

  public static void driveAuton(double ySpeed, double xSpeed, double zRotation, double angle){
    mecanum.driveCartesian(ySpeed, xSpeed, zRotation, 0); //probably needs to be fixed
  }

  public static void resetGyro(){
    //gyro.reset();
  }

  public static void driveStop(){
    mecanum.driveCartesian(0,0,0,0);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveTeleop());
  }
}
