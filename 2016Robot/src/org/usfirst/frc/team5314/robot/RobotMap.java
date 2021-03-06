package org.usfirst.frc.team5314.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static int driveLeftMotor = 1;
    public static int driveRightMotor = 0;
    
    public static int driveStick = 1;
	public static int frontSensor = 0;
	
	public static int anglemotor = 3;
	public static int rightShooterWheel = 1;
	public static int leftShooterWheel = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
