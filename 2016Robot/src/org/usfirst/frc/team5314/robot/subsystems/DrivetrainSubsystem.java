package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.DriveWithJoystickCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {
	private CANTalon leftMotor = new CANTalon(RobotMap.driveLeftMotor);
	private CANTalon rightMotor = new CANTalon(RobotMap.driveRightMotor);
    private RobotDrive driveMotors = new RobotDrive(leftMotor, rightMotor);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystickCommand());
    }
    public void Drive(double X, double Y){
    	driveMotors.arcadeDrive(Y, -X);
    }
    
}

