// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveStraight extends Command {

  public double rotations;

  public DriveStraight(double rot) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    rotations = rot;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.rightEncoder.setPosition(0.0);
    Robot.drivetrain.leftEncoder.setPosition(0.0);

    System.out.println("Starting");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.driveAuton(0.5, -0.5); //parameter is rotations
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.drivetrain.rightEncoder.getPosition() > rotations || Robot.drivetrain.leftEncoder.getPosition() > rotations);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.driveAuton(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
