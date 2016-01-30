package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.DriveWithJoystickCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {
	private CANTalon leftMotor = new CANTalon(RobotMap.driveLeftMotor);
	private CANTalon rightMotor = new CANTalon(RobotMap.driveRightMotor);
    private RobotDrive driveMotors = new RobotDrive(leftMotor, rightMotor);
    private AnalogInput frontSensor = new AnalogInput(RobotMap.frontSensor);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystickCommand());
    }
    public void Drive(double X, double Y){
    	//if (getDistance() < 44 && Y < 0){
    		//Y = 0;
    	//}
    	driveMotors.arcadeDrive(Y, -X);
    }
    public void updateStatus(){
    	SmartDashboard.putNumber("Distance", getDistance());
    }
    public double getDistance(){
    	double distance = Math.round(((frontSensor.getVoltage()/.00976562)*1.034)*10)/10;
    	return distance;
    }
    
}

