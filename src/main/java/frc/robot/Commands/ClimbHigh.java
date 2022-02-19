// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClimbHigh extends Command {
  double d;

  public ClimbHigh() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean opened = Robot.climber.openAngle();
    if(opened){
      boolean extended = Robot.climber.extendClimb(d);
      if(extended){
        boolean closed = Robot.climber.closeAngle();
      }
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climber.retractClimb(d);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
