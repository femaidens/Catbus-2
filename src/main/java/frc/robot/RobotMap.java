// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class RobotMap {
    public static int driveJoy1Port = 2; //controls lateral (left)
    public static int driveJoy2Port = 1; //controls turning (right)
    public static int operJoyPort = 0;

    //drivetrain - might need to fix
    public static int frontRightPort = 2; 
    public static int frontLeftPort = 3; 
    public static int rearRightPort = 9; 
    public static int rearLeftPort = 1; 

    //intake
    public static int intakeMotorPort = 6;
    public static int intakeArmPort = 5;

    public static int intakeEncoderPort = 3; 

    //climb
    public static int rightClimbPort = 8; //originally 8
    public static int leftClimbPort = 10; //originally 10
    public static int climbPistonForwardPort = 1; //originally 1
    public static int climbPistonBackwardPort = 0; //originally 0

    //shooter
    public static int shooterMotorTopPort = 4;//big wheel
    public static int shooterMotorBotPort = 12; //green wheel
}
