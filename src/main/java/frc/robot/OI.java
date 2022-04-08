// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.print.attribute.standard.DialogOwner;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.IntakeCargo;
import frc.robot.Commands.IntakeDown;
import frc.robot.Commands.RetractIntake;



/** Add your docs here. */
public class OI {

    public static Joystick driveJoy1 = new Joystick(RobotMap.driveJoy1Port);
    public static Joystick driveJoy2 = new Joystick(RobotMap.driveJoy2Port);
    public static Joystick operJoy = new Joystick(RobotMap.operJoyPort);

    public static Button intakeMotorButton = new JoystickButton(driveJoy1, 1); 
    public static Button intakeReverseButton = new JoystickButton(driveJoy2, 11); //right driveJoy, top right button
    public static Button intakeExtendButton = new JoystickButton(operJoy, 5); //LB
    //public static Button intakeRetractButton = new JoystickButton(operJoy, 5); //LB

    public void bindButtons() {
        intakeMotorButton.whileHeld(new IntakeCargo());
        intakeExtendButton.whileHeld(new IntakeDown());
        //intakeRetractButton.whenPressed(new RetractIntake());
    }

}
