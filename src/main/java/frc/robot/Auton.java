// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.DriveStraightDistance;
import frc.robot.Commands.EngageGB;
import frc.robot.Commands.HoldIntakeArm;
import frc.robot.Commands.IntakeCargoAuton;
import frc.robot.Commands.IntakeDownAuton;
import frc.robot.Commands.IntakeReverse;

public class Auton extends CommandGroup {
  /** Add your docs here. */
  public Auton() {
    // Add Commands here:
    //addSequential(new IntakeDownAuton());
    addSequential(new IntakeReverse());
    addSequential(new DriveStraightDistance(37.5, -0.2)); //change values based on testing - moving quarter of distance & opposite direction
    /*
    addParallel(new HoldIntakeArm());
    addSequential(new IntakeCargoAuton());
    addSequential(new RetractLatch());
    addSequential(new EngageGB());
    addSequential(new WindShooter());
    */
  }
}
