package frc.robot.tests;

import java.lang.invoke.MethodHandles;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;

public class ExampleTest implements Test
{
    // This string gets the full name of the class, including the package name
    private static final String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    // *** STATIC INITIALIZATION BLOCK ***
    // This block of code is run first when the class is loaded
    static
    {
        System.out.println("Loading: " + fullClassName);
    }

    // *** CLASS & INSTANCE VARIABLES ***
    // Put all class and instance variables here.
    private final RobotContainer robotContainer;
    private final ExampleSubsystem exampleSubsystem;


    // *** CLASS CONSTRUCTOR ***
    public ExampleTest(RobotContainer robotContainer)
    {
        this.robotContainer = robotContainer;
        this.exampleSubsystem = robotContainer.exampleSubsystem;
    }

    /**
     * This method runs one time before the periodic() method.
     */
    public void init()
    {}

    /**
     * This method runs periodically (every 20ms).
     */
    public void periodic()
    {}
    
    /**
     * This method runs one time after the periodic() method.
     */
    public void exit()
    {}

    // *** METHODS ***
    // Put any additional methods here.

    
}
