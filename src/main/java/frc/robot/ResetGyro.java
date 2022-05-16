// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command {
  public ResetGyro() {
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.drivetrain.resetGyro(); //to be changed!!!!!!!!!
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {}
}