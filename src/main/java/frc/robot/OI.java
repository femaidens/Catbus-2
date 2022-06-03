// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.print.attribute.standard.DialogOwner;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.Commands.IntakeDown;
//import frc.robot.Commands.RetractIntake;
import frc.robot.Commands.*;



/** Add your docs here. */
public class OI {

    public static Joystick driveJoy1 = new Joystick(RobotMap.driveJoy1Port);
    public static Joystick driveJoy2 = new Joystick(RobotMap.driveJoy2Port);
    public static Joystick operJoy = new Joystick(RobotMap.operJoyPort);

    //drivetrain
    //public static Button gyroReset = new JoystickButton(driveJoy2, 1);

    //climb
    public static Button pistonInButton = new JoystickButton(operJoy, 6); //RB
    public static Button pistonOutButton = new JoystickButton(operJoy, 5); //LB
    public static Button climbExtendButton = new JoystickButton(operJoy, 1); //A
    public static Button climbRetractButton = new JoystickButton(operJoy, 2); //B

    //shooter
    public static Button testShooter = new JoystickButton(operJoy, 1);
    /*
    public static Button engageGB = new JoystickButton(operJoy, 9);
    public static Button windShooter = new JoystickButton(operJoy, 7); //small left button
    public static Button disengageGB = new JoystickButton(operJoy, 10);
    public static Button retractLatchButton = new JoystickButton(operJoy, 2); //
    */

    //intake
    public static Button intakeMotorButton = new JoystickButton(operJoy, 4); //intake cargo //Y
    public static Button intakeReverseButton = new JoystickButton(driveJoy2, 11); //right driveJoy, top right button
    public static Button holdIntakeArmButton = new JoystickButton(operJoy, 3); //X
    //public static Button intakeRetractButton = new JoystickButton(operJoy, 5); 

    //public static Button latchDisengage = new JoystickButton(driveJoy2, 15);
    //public static Button latchEngage = new JoystickButton(driveJoy2, 16); //lower right corner of right side
    
    public void bindButtons() {
        //drivetrain
        //gyroReset.whenPressed(new ResetGyro());

        //climb
        pistonInButton.whenPressed(new climbOpenAngle());
        pistonOutButton.whenPressed(new climbCloseAngle());
        climbExtendButton.whileHeld(new climbExtend());
        climbRetractButton.whileHeld(new climbRetract());

        //shooter
        testShooter.whenPressed(new ShootBall());
        //engageGB.whenPressed(new EngageGB());
        //disengageGB.whenPressed(new DisengageGB());

        //intake
        intakeMotorButton.whileHeld(new IntakeCargo());
        intakeReverseButton.whileHeld(new IntakeReverse());
        holdIntakeArmButton.whileHeld(new HoldIntakeArm());
        //intakeRetractButton.whenPressed(new RetractIntake());
    }
}