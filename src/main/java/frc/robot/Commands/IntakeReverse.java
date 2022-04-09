// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

<<<<<<<< HEAD:src/main/java/frc/robot/Commands/AlignClimb.java
public class AlignClimb extends Command {
  public AlignClimb() {
========
public class IntakeReverse extends Command {
  public IntakeReverse() {
>>>>>>>> c5fd17f75e6a2135211c8f523938be1faa708643:src/main/java/frc/robot/Commands/IntakeReverse.java
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
<<<<<<<< HEAD:src/main/java/frc/robot/Commands/AlignClimb.java
    Robot.climber.alignClimb();
========
    Robot.intake.reverseIntake();
>>>>>>>> c5fd17f75e6a2135211c8f523938be1faa708643:src/main/java/frc/robot/Commands/IntakeReverse.java
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
