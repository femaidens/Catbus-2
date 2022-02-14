// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANSparkMax shooterMotor = new CANSparkMax(RobotMap.shooterMotorPort, MotorType.kBrushless);
	public static DutyCycleEncoder shooterEncoder = new DutyCycleEncoder(RobotMap.dcEncoder);
	public static DoubleSolenoid shooterPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.shooterPistonForwardPort, RobotMap.shooterPistonBackwardPort);
	public static double windDistance; // distance to wind string

  	public Shooter(){
		
	}

	public void windString(){
		double currentDistance = shooterEncoder.get();
		while(currentDistance < windDistance){
			shooterMotor.set(-0.7);
		}
	}

	public void extend(){
		shooterPiston.set(DoubleSolenoid.Value.kForward);
	}

	public void retract(){
		shooterPiston.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopShooterMotor(){
		shooterMotor.set(0.0);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
