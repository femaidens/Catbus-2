// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.Intake;

public class IntakeDownAuton extends Command {
  public Timer timer = new Timer();
  public static double intakeTime = .75;
  
  public IntakeDownAuton() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
    Intake.intakeArmMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Intake.intakeArmMotor.set(0.2);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer.get() >= intakeTime){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intake.stopIntakeArm();
    Intake.intakeArmMotor.setIdleMode(IdleMode.kBrake);
    timer.reset();
;  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
