// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.Drivetrain;

public class DriveStraightDistance extends Command {
  public static double d;
  public static double s;
  public Timer timer = new Timer();
  public static int taxiTime = 10;
  
  public DriveStraightDistance(double distance, double speed) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    d = distance;
    s  = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
    Drivetrain.leftEncoder.setPosition(0.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //System.out.println("left encoder value:" + Drivetrain.leftEncoder.getPosition());
    if(timer.get() >= 10){
      //System.out.println("left encoder value:" + Drivetrain.leftEncoder.getPosition());
      Drivetrain.driveAuton(s, 0, 0, 0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Drivetrain.leftEncoder.getPosition() >= d){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.driveAuton(0, 0, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
