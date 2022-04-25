// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.Shooter;

public class WindShooter extends Command {
  public WindShooter() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.shooter.encoder.setPosition(0.0);
    Robot.shooter.extend(); //disengages latch
    Robot.shooter.retractGBPiston(); //engage gearbox
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.shooter.extend(); //extend is open
    Robot.shooter.windString();
    Robot.shooter.retract(); //engage latch by not pushing piston
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /*if(Shooter.encoder.getPosition() >= 69.5 && Shooter.encoder.getPosition() <= 73){
      return true;
    }
    return false;
    */
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shooter.stopShooterMotor(); 
    Robot.shooter.retractGBPiston(); //disengage gearbox
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
