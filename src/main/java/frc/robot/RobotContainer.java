// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.invoke.MethodHandles;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Gatherer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Shoulder;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer
{
    // This string gets the full name of the class, including the package name
    private static final String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    // *** STATIC INITIALIZATION BLOCK ***
    // This block of code is run first when the class is loaded
    static
    {
        System.out.println("Loading: " + fullClassName);
    }
	
	private boolean useFullRobot		= true;
	private boolean useExampleSubsystem	= true;
	private boolean useGrabber 			= true;
	private boolean useGatherer 		= true;
	private boolean useArm 				= true;
	private boolean useShoulder			= true;


	private final ExampleSubsystem exampleSubsystem;
	public static Grabber grabber;
	private final Arm arm;
	private final Shoulder shoulder;
	private final Gatherer gatherer;
	// private Joystick joystick;
	
	/** 
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 * Use the default modifier so that new objects can only be constructed in the same package.
	 */
	RobotContainer()
	{
		// Create the needed subsystems
		exampleSubsystem 	= (useFullRobot || useExampleSubsystem) ? new ExampleSubsystem() 	: null;
		grabber 			= (useFullRobot || useGrabber) ? new Grabber() 						: null;
		arm 				= (useFullRobot || useArm) ? new Arm() 								: null;
		shoulder 			= (useFullRobot || useShoulder) ? new Shoulder() 					: null;
		gatherer 			= (useFullRobot || useGatherer) ? new Gatherer() 					: null;



		// Configure the trigger bindings
		configureBindings();
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be created via the
	 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
	 * predicate, or via the named factories in {@link
	 * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
	 * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
	 * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
	 * joysticks}.
	 */
	private void configureBindings()
	{}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand()
	{
		return null;
	}
}
