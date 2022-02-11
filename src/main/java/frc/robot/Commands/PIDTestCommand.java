// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Subsystems.PIDTest;

public class PIDTestCommand extends Command {
  public PIDTestCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    SmartDashboard.putNumber("P", 0.000700);
    SmartDashboard.putNumber("I", 0.000001);
    SmartDashboard.putNumber("D", 0.01);
    SmartDashboard.putNumber("IZone", 100.00);
    SmartDashboard.putNumber("FF", 0.000250);
    SmartDashboard.putNumber("OutputRangeL", 0.0);
    SmartDashboard.putNumber("OutputRangeH", 1.0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    PIDTest.motorPIDController.setP(SmartDashboard.getNumber("P", 0.000700));
    PIDTest.motorPIDController.setI(SmartDashboard.getNumber("I", 0.000001));
    PIDTest.motorPIDController.setD(SmartDashboard.getNumber("D", 0.01000));
    PIDTest.motorPIDController.setIZone(SmartDashboard.getNumber("I", 100.00));
    PIDTest.motorPIDController.setFF(SmartDashboard.getNumber("I", 0.000250));
    PIDTest.motorPIDController.setOutputRange(SmartDashboard.getNumber("OutputRangeL", 0.0), SmartDashboard.getNumber("OuputRangeH", 1.0));
    PIDTest.motorPIDController.setReference(SmartDashboard.getNumber("ShooterSpeed", 0.0), ControlType.kVelocity);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    PIDTest.motor.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
