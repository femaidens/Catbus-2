// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.Subsystems.Shooter;

public class ShootBallAuton extends Command {
  public Timer timer = new Timer();
  public static double shootAutonTime = 3;

  public ShootBallAuton(){
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooter);
    SmartDashboard.putNumber("P", 0.000700);
    SmartDashboard.putNumber("I", 0.000001);
    SmartDashboard.putNumber("D", 0.01);
    SmartDashboard.putNumber("IZone", 100.00);
    SmartDashboard.putNumber("FF", 0.000250);
    SmartDashboard.putNumber("OutputRangeL", -1.0);
    SmartDashboard.putNumber("OutputRangeH", 1.0);

    Shooter.sMotorTopPIDController.setP(SmartDashboard.getNumber("P", 0.000700));
    Shooter.sMotorTopPIDController.setI(SmartDashboard.getNumber ("I", 0.000001));
    Shooter.sMotorTopPIDController.setD(SmartDashboard.getNumber("D", 0.010000));

    Shooter.sMotorBotPIDController.setP(SmartDashboard.getNumber("P", 0.000700));
    Shooter.sMotorBotPIDController.setI(SmartDashboard.getNumber ("I", 0.000001));
    Shooter.sMotorBotPIDController.setD(SmartDashboard.getNumber("D", 0.010000));
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (timer.get() >= 2.25){
      Robot.shooter.spinBotMotor();
    }
    Robot.shooter.stopBotMotor();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished(){
    if (timer.get() >= shootAutonTime){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Shooter.shooterMotorTop.set(0.0);
    Shooter.shooterMotorBot.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}