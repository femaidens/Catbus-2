// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class RobotMap {
    public static int driveJoy1Port = 2; //controls lateral
    public static int driveJoy2Port = 1; //controls turning
    public static int operJoyPort = 0;

    //drivetrain
    public static int frontRightPort = 9; //10
    public static int frontLeftPort = 1; //9
    public static int rearRightPort = 8; //11
    public static int rearLeftPort = 7; //3

    //intake
    public static int intakeMotor1Port = 2;
    public static int intakeSmallMotorPort = 3;
    public static int intakeExtendPort = 3;
    public static int intakeEncoderPort = 3;

    //climb
    public static int rightClimbPort = 6;
    public static int leftClimbPort = 5;
    public static int climbSolenoidForwardPort = 7;
    public static int climbSolenoidBackwardPort = 6;

    //shooter
    public static int shooterMotor1Port = 16; //change port numbers
    public static int shooterMotor2Port = 17;
    public static int shooterAbEncoderPort = 2;
}
