// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.*;


/** Add your docs here. */
public class OI {

    public static Joystick driveJoy1 = new Joystick(RobotMap.driveJoy1Port);
    public static Joystick driveJoy2 = new Joystick(RobotMap.driveJoy2Port);
    public static Joystick operJoy = new Joystick(RobotMap.operJoyPort);

    public static Button climbButtonExtend = new JoystickButton(operJoy, 4);
    public static Button climbButtonRetract = new JoystickButton(operJoy, 5);
    public static Button climbButtonOpenAngle = new JoystickButton(operJoy, 4);
    public static Button climbButtonCloseAngle = new JoystickButton(operJoy, 5);

    public void bindButtons() {
        climbButtonExtend.whileHeld(new climbExtend());
        climbButtonRetract.whileHeld(new climbRetract());
        climbButtonOpenAngle.whenPressed(new climbOpenAngle());
        climbButtonCloseAngle.whenPressed(new climbCloseAngle());
    }

}
