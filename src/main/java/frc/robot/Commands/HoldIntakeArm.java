// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.Intake;

public class HoldIntakeArm extends Command { //--> up intake arm adjustment
  public HoldIntakeArm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Intake.intakeArmMotor.setIdleMode(IdleMode.kCoast);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.intake.upIntakeArm();
    //Robot.intake.holdIntakeArm();
    //Intake.intakeArmMotor.set(0.5);
    //System.out.println("execute");
    //System.out.println(Intake.intakeEncoder.getDistance());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.intake.stopIntakeArm();
    Robot.intake.downIntakeArm();
    //System.out.println("end");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
