// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DutyCycle;

/** Add your docs here. */
public class RobotMap {
    public static int driveJoy1Port = 0;
    public static int driveJoy2Port = 0;
    public static int operJoyPort = 0;

    //drivetrain
    public static int frontRightPort = 0;
    public static int frontLeftPort = 1;
    public static int rearRightPort = 2;
    public static int rearLeftPort = 3;
    public static int gyroPort = 4;

    //climb
    public static int rightClimbPort = 0;
    public static int leftClimbPort = 0;
    public static int climbRightPistonForwardPort = 0;
    public static int climbRightPistonBackwardPort = 0;
    public static int climbLeftPistonForwardPort = 0;
    public static int climbLeftPistonBackwardPort = 0;

    public static int climbLeftUltrasonicPort = 0;
    public static int climbRightUltrasonicPort = 0;

    //shooter
    public static int shooterMotorPort;
    public static int dcEncoder;
    public static int shooterPistonForwardPort;
    public static int shooterPistonBackwardPort;
    public static int shooterGBPistonBackwardPort;
}
