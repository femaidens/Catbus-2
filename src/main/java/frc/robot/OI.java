// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//import javax.print.attribute.standard.DialogOwner;

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
    public static Button prepShooter = new JoystickButton(operJoy, 7); //small right button
    public static Button shootBall = new JoystickButton(operJoy, 8); //small left buttton
    public static Button shootBallTest = new JoystickButton(driveJoy1, 16); //single dot button on lateral
    
    /*
    public static Button engageGB = new JoystickButton(operJoy, 9);
    public static Button windShooter = new JoystickButton(operJoy, 7); //small left button
    public static Button disengageGB = new JoystickButton(operJoy, 10);
    public static Button retractLatchButton = new JoystickButton(operJoy, 2); //
    */
    

    //intake
    public static Button intakeMotorButton = new JoystickButton(operJoy, 4); //intake cargo //Y
    public static Button intakeReverseButton = new JoystickButton(driveJoy2, 11); //right driveJoy, top right button --> CHECK TO SEE IF THIS IS THE THIRD BUTTON ON DRIVEJOY 2
    public static Button holdIntakeArmButton = new JoystickButton(operJoy, 3); //X; up intake arm
    public static Button downIntakeButton = new JoystickButton(operJoy, 10); //right axis button
    public static Button intakeDownAutonButton = new JoystickButton(driveJoy2, 16);
    //public static Button intakeRetractButton = new JoystickButton(operJoy, 5); 

    //public static Button latchDisengage = new JoystickButton(driveJoy2, 15);
    //public static Button latchEngage = new JoystickButton(driveJoy2, 16); //lower right corner of right side
    
    public void bindButtons() {
        //drivetrain
        //gyroReset.whenPressed(new ResetGyro());

        //climb
        pistonInButton.whenPressed(new climbCloseAngle());
        pistonOutButton.whenPressed(new climbOpenAngle());
        climbExtendButton.whileHeld(new climbExtend());
        climbRetractButton.whileHeld(new climbRetract());

        //shooter
        //shootBall.whileHeld(new ShootBall()); //actually prep
        shootBallTest.whenPressed(new ShootBall2()); //command group
        prepShooter.whileHeld(new ShootBall()); //preps
        shootBall.whileHeld(new PrepShooter());  //shoot
        //engageGB.whenPressed(new EngageGB());
        //disengageGB.whenPressed(new DisengageGB());

        //intake
        intakeMotorButton.whileHeld(new IntakeCargo());
        intakeReverseButton.whileHeld(new IntakeReverse());
        //downIntakeButton.whileHeld(new DownIntakeArm());
        holdIntakeArmButton.whileHeld(new HoldIntakeArm());
        intakeDownAutonButton.whenPressed(new IntakeDownAuton());
        //intakeRetractButton.whenPressed(new RetractIntake());
    }
}