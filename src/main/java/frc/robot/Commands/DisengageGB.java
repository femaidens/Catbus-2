// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.Shooter;

public class DisengageGB extends Command { //unwind string all the way in opposite direction, then disengage gb
  public DisengageGB() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.shooter.extendGBPiston();
    //Robot.shooter.extend(); //disengage latch
    //Robot.shooter.unwindString();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if(Shooter.encoder.getPosition() <= 139 && Shooter.encoder.getPosition() >= 145){
    //  return true;
   // }
      //return true;
      return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.shooter.extendGBPiston(); //change name
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
