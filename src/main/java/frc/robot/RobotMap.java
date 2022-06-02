// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class RobotMap {
    public static int driveJoy1Port = 2; //controls lateral
    public static int driveJoy2Port = 1; //controls turning
    public static int operJoyPort = 0;

    //drivetrain - might need to fix
    public static int frontRightPort = 2; 
    public static int frontLeftPort = 7; 
    public static int rearRightPort = 9; 
    public static int rearLeftPort = 1; 

    //intake
    public static int intakeMotorPort = 6;
    public static int intakeArmPort = 5;

    public static int intakeEncoderPort = 3; 

    //climb
    public static int rightClimbPort = 8;
    public static int leftClimbPort = 10;
    public static int climbPistonForwardPort = 0;
    public static int climbPistonBackwardPort = 1;

    //shooter
    public static int shooterMotorTopPort = 4;//change port number
    public static int shooterMotorBotPort = 3; //change number 
}
