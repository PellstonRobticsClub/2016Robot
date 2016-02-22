package org.usfirst.frc.team5314.robot;

import org.usfirst.frc.team5314.robot.commands.LoadBoulderCommand;
import org.usfirst.frc.team5314.robot.commands.ShootBoulderCommand;
import org.usfirst.frc.team5314.robot.commands.StopWheelsCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick driveStick = new Joystick(RobotMap.driveStick);
    
    // Button button = new JoystickButton(stick, buttonNumber);
    Button loadButton = new JoystickButton(driveStick,1);
    Button fireButton = new JoystickButton(driveStick, 2);
    Button backUpButton = new JoystickButton (driveStick, 6);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    public OI(){
    	loadButton.whileHeld(new LoadBoulderCommand());
    	fireButton.whenPressed(new ShootBoulderCommand());
    	loadButton.whenReleased(new StopWheelsCommand());
    	
    }
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public double driveStickGetY(){
    	driveStick.getY();
    	return driveStick.getY();
    }
    public double driveStickGetX(){
    	driveStick.getX();
    	return driveStick.getX();
    }
    public double drivestickGetTrigger(){
    	return driveStick.getRawAxis(2) - driveStick.getRawAxis(3);
    }
    public boolean isBackUpButtonPressed(){
    	return backUpButton.get();
    }
  
}

