// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeDown extends Command {
  public IntakeDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.resetGyro();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.intake.downIntake();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
<<<<<<< HEAD:src/main/java/frc/robot/Commands/DriveTeleop.java
      Drivetrain.mecanum.driveCartesian(0,0,0,0);
=======
    Robot.intake.intakeExtendMotor.set(0.0);
>>>>>>> c5fd17f75e6a2135211c8f523938be1faa708643:src/main/java/frc/robot/Commands/IntakeDown.java
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.intake.intakeExtendMotor.set(0.0);
  }
}
