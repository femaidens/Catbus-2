   
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
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
  	public static CANSparkMax shooterMotor = new CANSparkMax(RobotMap.shooterMotorPort, MotorType.kBrushless);
	public static DutyCycleEncoder shooterEncoder = new DutyCycleEncoder(RobotMap.shooterAbEncoderPort);
	public static RelativeEncoder encoder = shooterMotor.getEncoder();
	public static DoubleSolenoid shooterPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.shooterPistonForwardPort, RobotMap.shooterPistonBackwardPort);
	public static DoubleSolenoid shooterGBPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.shooterGBPistonForwardPort, RobotMap.shooterGBPistonBackwardPort);
	public static double windDistance; // distance to wind string
	public static double distance;
	public static double lowerBound;
	public static double upperBound;
	//public static Limelight limelight;

  	public Shooter(){
		
	}

	public void windString(){ //for reload
		double currentDistance = shooterEncoder.getDistance();
		while(currentDistance < windDistance){
			shooterMotor.set(-0.7);
		}
		//shooterMotor.set(0.2); 
	}
	public void unwindString(){
		if(shooterEncoder.getDistance() <= 1.5 && shooterEncoder.getDistance() >= -1.5){
			shooterMotor.set(0.0); 
		}
		shooterMotor.set(-.2);
	}
	public void extend(){  //keeping string in place --> for reload
		shooterPiston.set(DoubleSolenoid.Value.kForward);
	}

	public void retract(){ //releases string --> shoots ball
		shooterPiston.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopShooterMotor(){ //dc encoder motor
		shooterMotor.set(0.0);
	}

	public void extendGBPiston(){
		shooterGBPiston.set(DoubleSolenoid.Value.kForward); //extends gearbox piston to attach motor to shaft
	}
	
	public void retractGBPiston(){
		shooterGBPiston.set(DoubleSolenoid.Value.kReverse); //retract gearbox piston to remove motor from shaft
	}
	
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}