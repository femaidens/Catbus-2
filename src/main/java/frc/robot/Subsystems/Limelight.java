// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public static NetworkTableEntry tv = table.getEntry("tv"); // any valid targets? (0 for no target, 1 for target) 
  public static NetworkTableEntry tx = table.getEntry("tx"); // horizontal offset from crosshair to target (-27 to 27 degrees)
  public static NetworkTableEntry ta = table.getEntry("ta"); // target area (0% to 100%)
  public static NetworkTableEntry ts = table.getEntry("ts"); // skew or rotation (-90 to 0 degrees)*/
  public static NetworkTableEntry ty = table.getEntry("ty"); // y angle of the limelight to the target (vertical offset)

  public static double h2; //height of the target
  public static double h1; //height of mount
  public static double a1; //mount angle in degrees
  public static double a2; //limelight to shooter angle difference in degrees

  public Limelight(){
  }
  
  public static boolean objectSighted(){
    if (tv.getDouble(0.0) == 1.0){
      return true;
    }
      return false;
  }
  
  public static double getTX(){
    if(objectSighted()){
      return tx.getDouble(0.0);
    }
    return 0;
  }

  public static double getTY() {
    if(objectSighted()) {
      return ty.getDouble(0.0);
    }
    return 0;
  }

  public static double getDistance(){
    return (h2 - h1) / Math.tan(Math.toRadians(a1 + a2));
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}