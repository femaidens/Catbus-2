   
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  	public static CANSparkMax shooterMotorTop = new CANSparkMax(RobotMap.shooterMotorTopPort, MotorType.kBrushless);
	public static CANSparkMax shooterMotorBot = new CANSparkMax(RobotMap.shooterMotorBotPort, MotorType.kBrushless);
	public static SparkMaxPIDController sMotorTopPIDController = shooterMotorTop.getPIDController();
	public static SparkMaxPIDController sMotorBotPIDController = shooterMotorBot.getPIDController();
	public static double windDistance; // distance to wind string
	public static double distance;
	public static double lowerBound;
	public static double upperBound;
	//public static Limelight limelight;

	public Shooter(){
		sMotorTopPIDController.setP(1e-4);
    	sMotorTopPIDController.setI(1e-6);
    	sMotorTopPIDController.setD(1e-2);
    	sMotorTopPIDController.setIZone(0);
    	sMotorTopPIDController.setFF(0);
    	sMotorTopPIDController.setOutputRange(-1.0, 1.0); //changes actual spd 

		sMotorBotPIDController.setP(1e-4);
    	sMotorBotPIDController.setI(1e-6);
    	sMotorBotPIDController.setD(1e-2);
    	sMotorBotPIDController.setIZone(0);
    	sMotorBotPIDController.setFF(0);
    	sMotorBotPIDController.setOutputRange(-1.0, 1.0); //changes actual spd 
	}
	
	public void stopTopMotor(){ 
		shooterMotorTop.set(0.0);
	}

	public void stopBotMotor(){
		shooterMotorBot.set(0.0);
	}
	
	public void spinTopMotor(){
		shooterMotorTop.set(-1); 
	}

	public void spinBotMotor(){
		shooterMotorBot.set(-0.2);//motor reversed
	}

	public void currentLimit(){
		int limit = 40; //limit in amps
		frontRight.setSmartCurrentLimit(limit);
		rearRight.setSmartCurrentLimit(limit);
		frontLeft.setSmartCurrentLimit(limit);
		rearLeft.setSmartCurrentLimit(limit);
	}

	public void voltRamp(){
		double rate = 3;
		shooterMotorTop.setClosedLoopRampRate(rate);
		shooterMotorBot.setClosedLoopRampRate(rate);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}