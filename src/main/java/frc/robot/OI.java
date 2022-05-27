// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.SpinForward;
import frc.robot.Commands.SpinReverse;

/** Add your docs here. */
public class OI {
    public static Joystick driveJoy = new Joystick(RobotMap.driveJoyPort);
    public static JoystickButton spinForward = new JoystickButton(driveJoy, 1); //A
    public static JoystickButton spinReverse = new JoystickButton(driveJoy, 2); //B

    public void bindButtons() {
        spinForward.whileHeld(new SpinForward());
        spinReverse.whileHeld(new SpinReverse());
    }
}
