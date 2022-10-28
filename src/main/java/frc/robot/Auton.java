// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.DriveStraightDistance;
//import frc.robot.Commands.HoldIntakeArm;
//import frc.robot.Commands.IntakeCargoAuton;
// import frc.robot.Commands.IntakeDownAuton;
// import frc.robot.Commands.IntakeReverse;
// import frc.robot.Commands.PowerShooterAuton;
// import frc.robot.Commands.ShootBall;
// import frc.robot.Commands.ShootBallAuton;

public class Auton extends CommandGroup {
  /** Add your docs here. */
  public Auton() {
    // Add Commands here:
    //addSequential(new IntakeReverse());
    addSequential(new DriveStraightDistance(80, 0.35)); //change values based on testing - moving quarter of distance & opposite direction
    //addSequential(new PowerShooterAuton());
    //addParallel(new ShootBallAuton());
    //addSequential(new IntakeDownAuton());
    //addSequential(new DriveStraightDistance(40, 0.3)); //change values based on testing - moving quarter of distance & opposite direction

    /*
    addParallel(new HoldIntakeArm());
    addSequential(new IntakeCargoAuton());
    addSequential(new RetractLatch());
    addSequential(new EngageGB());
    addSequential(new WindShooter());
    */
  }
}