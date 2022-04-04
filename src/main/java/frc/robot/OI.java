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

    public static Button pistonInButton = new JoystickButton(operJoy, 3);
    public static Button pistonOutButton = new JoystickButton(operJoy, 4);

    public static Button climbExtendButton = new JoystickButton(operJoy, 2);
    public static Button climbRetractButton = new JoystickButton(operJoy, 1);

    public void bindButtons() {
        pistonInButton.whenPressed(new climbOpenAngle());
        pistonOutButton.whenPressed(new climbCloseAngle());

        climbExtendButton.whileHeld(new climbExtend());
        climbRetractButton.whileHeld(new climbRetract());
    }

}
