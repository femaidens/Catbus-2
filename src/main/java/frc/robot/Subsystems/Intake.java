// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeMotorPort, MotorType.kBrushless);
	public static DoubleSolenoid intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.intakePistonBackwardPort, RobotMap.intakePistonBackwardPort);

	//extend piston
	public void extend(){
		intakePiston.set(DoubleSolenoid.Value.kForward);
	}

	//retract piston
	public void retract(){
	  intakePiston.set(DoubleSolenoid.Value.kReverse);
  }

	//intake
	public void startIntake(){
		intakeMotor.set(0.7);
  }

  public void stopIntake(){
	  intakeMotor.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
