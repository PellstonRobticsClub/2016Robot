package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.OI;
import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystickCommand extends Command {

    public DriveWithJoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.isBackUpButtonPressed()){
    		Robot.drivetrain.Drive(-Robot.oi.driveStickGetX(), -Robot.oi.driveStickGetY());
    	}else{
    		Robot.drivetrain.Drive(Robot.oi.driveStickGetX(), Robot.oi.driveStickGetY());
    	}
    		
    	 }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
