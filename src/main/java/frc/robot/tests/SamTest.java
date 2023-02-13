package frc.robot.tests;

import java.lang.invoke.MethodHandles;

// import javax.lang.model.util.ElementScanner14;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotContainer;
// import frc.robot.subsystems.Shoulder;
import frc.robot.sensors.Vision;

public class SamTest implements Test
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
    // private final Shoulder shoulder;
    // private final Joystick joystick;
    private final Vision vision;
  

    // *** CLASS CONSTRUCTOR ***
    public SamTest(RobotContainer robotContainer)
    {
        System.out.println(fullClassName + " : Constructor Started");

        this.robotContainer = robotContainer;
        vision = this.robotContainer.vision;
        // shoulder = this.robotContainer.shoulder;
        // joystick = new Joystick(0);

        System.out.println(fullClassName + " : Constructor Finished");
    }

    /**
     * This method runs one time before the periodic() method.
     */
    public void init()
    {
        // shoulder.resetEncoder();
    }

    /**
     * This method runs periodically (every 20ms).
     */
    public void periodic()
    {
        vision.getX();
        

        // if(joystick.getRawButton(1))    //A
        // {
        //     shoulder.moveUp();
        // }
        // else if(joystick.getRawButton(2))   //B
        // {
        //     shoulder.moveDown();
        // }
        // else
        // {
        //     shoulder.off();
        // }

        // shoulder.moveDown();
        
        // System.out.println(shoulder);
    }
    
    /**
     * This method runs one time after the periodic() method.
     */
    public void exit()
    {

    }

    // *** METHODS ***
    // Put any additional methods here.

    
}
