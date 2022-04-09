// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.print.attribute.standard.DialogOwner;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.*;
import frc.robot.Commands.IntakeCargo;
import frc.robot.Commands.IntakeDown;
import frc.robot.Commands.RetractIntake;



/** Add your docs here. */
public class OI {

    public static Joystick driveJoy1 = new Joystick(RobotMap.driveJoy1Port);
    public static Joystick driveJoy2 = new Joystick(RobotMap.driveJoy2Port);
    public static Joystick operJoy = new Joystick(RobotMap.operJoyPort);

    public static Button pistonInButton = new JoystickButton(operJoy, 3); //X
    public static Button pistonOutButton = new JoystickButton(operJoy, 4); //Y

    public static Button climbExtendButton = new JoystickButton(operJoy, 8); //8
    public static Button climbRetractButton = new JoystickButton(operJoy, 1); //A 

    public static Button gyroReset = new JoystickButton(driveJoy2, 1);

    public static Button retractLatchButton = new JoystickButton(operJoy, 2); //B

    public static Button windShooter = new JoystickButton(operJoy, 7); //small left button

    public static Button disengageGB = new JoystickButton(operJoy, 10);
    public static Button engageGB = new JoystickButton(operJoy, 9);

    public static Button intakeMotorButton = new JoystickButton(driveJoy1, 1); 
    public static Button intakeReverseButton = new JoystickButton(driveJoy2, 11); //right driveJoy, top right button
    public static Button intakeExtendButton = new JoystickButton(operJoy, 5); //LB
    //public static Button intakeRetractButton = new JoystickButton(operJoy, 5); //LB
    
    public void bindButtons() {
        pistonInButton.whenPressed(new climbOpenAngle());
        pistonOutButton.whenPressed(new climbCloseAngle());

        climbExtendButton.whileHeld(new climbExtend());
        climbRetractButton.whileHeld(new climbRetract());

        gyroReset.whenPressed(new ResetGyro());

        disengageGB.whenPressed(new DisengageGB());
        engageGB.whenPressed(new EngageGB());
        
        retractLatchButton.whenPressed(new DisengageGB());

        windShooter.whenPressed(new WindShooter());

        intakeMotorButton.whileHeld(new IntakeCargo());
        intakeExtendButton.whileHeld(new IntakeDown());
        //intakeRetractButton.whenPressed(new RetractIntake());
    }
}