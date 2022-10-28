// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.Shooter;

public class PowerShooterAuton extends Command {
  public Timer timer = new Timer();
  public static double powerShooterTime = 3;
  public static double rate;
  
  
  public PowerShooterAuton() {
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
    Robot.shooter.currentLimit();
    Shooter.shooterMotorTop.setClosedLoopRampRate(rate);
      //initially Robot.shooter.setClosedLoopRampRate(); -> changed to shooterMotorTop for now
      //does same rate need to apply to the bottom?
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.shooter.spinTopMotor();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer.get() >= powerShooterTime){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.shooter.stopTopMotor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
