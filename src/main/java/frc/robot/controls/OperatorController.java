package frc.robot.controls;

import java.lang.invoke.MethodHandles;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import frc.robot.PeriodicIO;

//import edu.wpi.first.wpilibj.DriverStation;

public class OperatorController extends Xbox implements PeriodicIO
{
    private static final String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    // *** STATIC INITIALIZATION BLOCK ***
    // This block of code is run first when the class is loaded
    static
    {
        System.out.println("Loading: " + fullClassName);
    }
    

    // *** INNER ENUMS and INNER CLASSES ***

    private class PeriodicIO
    {
        private double[] axis = new double[6];
        private boolean[] button = new boolean[14];  // skip 0 and 11
        private Dpad dpad;
    }

    private PeriodicIO periodicIO = new PeriodicIO();
    
    // *** CLASS CONSTRUCTOR ***
    public OperatorController(int port)
    {
        super(port);

        System.out.println(fullClassName + ": Constructor Started");

        registerPeriodicIO();
        configureAxes();
        createRumbleEvents();

        System.out.println(fullClassName + ": Constructor Finished");
    }

    // *** CLASS & INSTANCE METHODS *** 

    public void createRumbleEvents()
    {
        createRumbleEvent(30.0, 2.0, 0.75, 0.75);
        createRumbleEvent(10.0, 1.0, 1.0, 1.0);
        createRumbleEvent(5.0, 0.25, 1.0, 1.0);
        createRumbleEvent(4.0, 0.25, 1.0, 1.0);
        createRumbleEvent(3.0, 0.25, 1.0, 1.0);
        createRumbleEvent(2.0, 0.25, 1.0, 1.0);
        createRumbleEvent(1.0, 0.25, 1.0, 1.0);
    }

    public void configureAxes()
    {
        setAxisSettings(Axis.kLeftX, 0.1, 0.0, 1.0, false, AxisScale.kLinear);
        setAxisSettings(Axis.kLeftY, 0.1, 0.0, 1.0, false, AxisScale.kLinear);
        setAxisSettings(Axis.kLeftTrigger, 0.1, 0.0, 1.0, false, AxisScale.kLinear);
        setAxisSettings(Axis.kRightTrigger, 0.1, 0.0, 1.0, false, AxisScale.kLinear);
        setAxisSettings(Axis.kRightX, 0.1, 0.0, 1.0, false, AxisScale.kLinear);
        setAxisSettings(Axis.kRightY, 0.1, 0.0, 1.0, false, AxisScale.kLinear);
    }

    public DoubleSupplier getAxisSupplier(Axis axis)
    {
        return () -> periodicIO.axis[axis.value];
        // return () -> getRawAxis(axis);
    }

    public BooleanSupplier getButtonSupplier(Button button)
    {
        return () -> periodicIO.button[button.value];
        // return () -> getRawButton(button);
    }

    public BooleanSupplier getDpadSupplier(Dpad dpad)
    {
        return () -> periodicIO.dpad == dpad;
        // return () -> getDpad() == dpad;
    }

    @Override
    public void readPeriodicInputs()
    {
        for(int a = 0; a <= 5; a++)
            periodicIO.axis[a] = getRawAxis(a);

        for(int b = 1; b <= 13; b++)
        {
            if(b != 11) // skip over subscripts 0 and 11
                periodicIO.button[b] = getRawButton(b);
        }

        periodicIO.dpad = getDpad();
    }

    @Override
    public void writePeriodicOutputs()
    {
        checkRumbleEvent();
    }

    @Override
    public String toString()
    {
        String str = "";

        // str = str + ""


        return str;
    }
}
