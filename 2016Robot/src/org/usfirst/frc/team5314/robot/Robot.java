
package org.usfirst.frc.team5314.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5314.robot.commands.AutonomousOneCommand;
import org.usfirst.frc.team5314.robot.commands.AutonomousTwoCommand;
import org.usfirst.frc.team5314.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team5314.robot.subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final ShooterSubsystem shooter = new ShooterSubsystem();
	public static final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser AutoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new AutonomousTwoCommand();
        AutoChooser = new SendableChooser();
        AutoChooser.addDefault("Auto One", new AutonomousOneCommand());
        AutoChooser.addObject("Auto Two", new AutonomousTwoCommand());
        SmartDashboard.putData("Auto Chooser", AutoChooser);
        shooter.setTalonFeedback();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		drivetrain.updateStatus();
		shooter.updateStatus();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) AutoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	

    }
   

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drivetrain.updateStatus();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
