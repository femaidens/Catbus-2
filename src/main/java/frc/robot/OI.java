// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.Commands.PIDTestCommand;

/** Add your docs here. */
public class OI {

    public static Joystick driveJoy = new Joystick(RobotMap.driveJoyPort);
    //public static Button pid = new JoystickButton(driveJoy, 3); //X

    public void bindButtons() {
        //pid.whileHeld(new PIDTestCommand(0.25));
    }
}
