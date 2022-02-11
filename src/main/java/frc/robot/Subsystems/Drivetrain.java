/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

//import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

///import frc.robot.commands.DriveTeleop;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
	public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
	public static CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);
	public static CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);
	
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	//public static DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.solChannel1, RobotMap.solChannel2);

	public static RelativeEncoder rightEncoder = frontRight.getEncoder();
	public static RelativeEncoder leftEncoder = frontLeft.getEncoder();

  	public Drivetrain(){
	  //frontLeft.setSmartCurrentLimit(currentLimit);
	  //frontRight.setSmartCurrentLimit(currentLimit);
	  //rearLeft.setSmartCurrentLimit(currentLimit);
	  //rearRight.setSmartCurrentLimit(currentLimit);
	  //middleLeft.setSmartCurrentLimit(currentLimit);
	  //middleRight.setSmartCurrentLimit(currentLimit);
	  
  	}
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
  @Override
  public void initDefaultCommand() {
   		//setDefaultCommand(new DriveTeleop());
  }

  public double getTest(){
    return 2.0;
  }
	public static void driveAuton(final double rightSpeed, final double leftSpeed) {
		frontRight.set(rightSpeed);
		rearRight.set(rightSpeed);
		frontLeft.set(leftSpeed);
		rearLeft.set(leftSpeed);
		middleLeft.set(leftSpeed);
		middleRight.set(rightSpeed);	
		//SmartDashboard.putNumber("Left motor speed", leftEncoder.getPosition());
		//SmartDashboard.putNumber("Right motor speed", rightEncoder.getPosition());
	}

	public static void driveStraightDistance(double distance) { //enter number of rotations as distance
    /*while(rightEncoder.getPosition() < distance && leftEncoder.getPosition() < distance) {
      if(rightEncoder.getPosition() < leftEncoder.getPosition()) {
        driveAuton(0.2, -0.1);
      } else if(rightEncoder.getPosition() > leftEncoder.getPosition()) {
        driveAuton(0.1, -0.2);
      } else {
        driveAuton(0.1, -0.1);
      }*/
      
      //only tested uncommented code, there might be something wrong with driveStraightDistance?

      driveAuton(-0.1, 0.1);
      //System.out.println("Right: " + rightEncoder.getPosition() + ", Left: " + leftEncoder.getPosition());
      System.out.println("Right: " + frontRight.get() + ", Left: " + frontLeft.get());

    //}

	}

	public static void turnDegrees(double angle) {
 /*   if (angle > 180) {
      angle = -(360 - angle);
      }
    
      while (Drivetrain.gyro.getAngle() != angle) {
        if (angle < 0) {
          Drivetrain.frontRight.set(1.0);
          Drivetrain.rearRight.set(1.0);
          Drivetrain.frontLeft.set(-1.0);
          Drivetrain.rearLeft.set(-1.0);
        } else {
          Drivetrain.frontRight.set(-1.0);
          Drivetrain.rearRight.set(-1.0);
          Drivetrain.frontLeft.set(1.0);
          Drivetrain.rearRight.set(1.0);
        }
      }

      Drivetrain.frontRight.set(0.0);
      Drivetrain.rearRight.set(0.0);
      Drivetrain.frontLeft.set(0.0);
      Drivetrain.rearRight.set(0.0);*/
  }
}