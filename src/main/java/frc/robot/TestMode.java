package frc.robot;

import java.lang.invoke.MethodHandles;
import frc.robot.tests.Test;

// *** IMPORTANT - PLEASE READ ***
// 1. Put your test code in your own frc.robot.tests.[yourname]Test.java file
// 2. Uncomment one of the IMPORT statements below
// 3. Uncomment one of the INITIALIZATION statements below
// 4. Test your code
// 5. Undo the changes to this file when finished with testing


// *** IMPORT statements ***
// Uncomment one of these statements

// import frc.robot.tests.ExampleTest;
// import frc.robot.tests.DavidTest;
// import frc.robot.tests.KyleTest;
// import frc.robot.tests.LoganTest;
// import frc.robot.tests.MaahishTest;
// import frc.robot.tests.MatthewTest;
import frc.robot.tests.OwenTest;
// import frc.robot.tests.SamTest;
// import frc.robot.tests.TanuTest;
// import frc.robot.tests.JWoodTest;
// import frc.robot.tests.RThomasTest;


public class TestMode
{
    // This string gets the full name of the class, including the package name
    private static final String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    // *** STATIC INITIALIZATION BLOCK ***
    // This block of code is run first when the class is loaded
    static
    {
        System.out.println("Loading: " + fullClassName);
    }

    // *** CLASS VARIABLES ***
    private final Test myTest;
    

    public TestMode(RobotContainer robotContainer)
    {
        // *** INITIALIZATION statements ***
        // Uncomment one of these statements

        // myTest = new ExampleTest(robotContainer);
        // myTest = new DavidTest(robotContainer);
        // myTest = new KyleTest(robotContainer);
        // myTest = new LoganTest(robotContainer);
        // myTest = new MaahishTest(robotContainer);
        // myTest = new MatthewTest(robotContainer);
        myTest = new OwenTest(robotContainer);
        // myTest = new SamTest(robotContainer);
        // myTest = new TanuTest(robotContainer);
        // myTest = new JWoodTest(robotContainer);
        // myTest = new RThomasTest(robotContainer);
    }

    /**
     * This method runs one time before the periodic() method.
     */
    public void init()
    {
        myTest.init();
    }

    /**
     * This method runs periodically (every 20ms).
     */
    public void periodic()
    {
        myTest.periodic();
    }

    /**
     * This method runs one time after the periodic() method.
     */
    public void exit()
    {
        myTest.exit();
    }    

}
