package frc.robot.subsystems;

import java.lang.invoke.MethodHandles;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Gatherer extends Subsystem4237
{
    // This string gets the full name of the class, including the package name
    private static final String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    // *** STATIC INITIALIZATION BLOCK ***
    // This block of code is run first when the class is loaded
    static
    {
        System.out.println("Loading: " + fullClassName);
    }

    private final CANSparkMax gathererMotor = new CANSparkMax(2, MotorType.kBrushless);
    private SparkMaxLimitSwitch forwardLimitSwitch;
    private SparkMaxLimitSwitch reverseLimitSwitch;
    private RelativeEncoder gathererEncoder;


    public Gatherer()
    {
        configGathererMotor();
    }

    private void configGathererMotor()
    {   
        gathererMotor.restoreFactoryDefaults();
        gathererMotor.setInverted(false);
        gathererMotor.setIdleMode(IdleMode.kBrake);

        // set feedback device
        // gathererEncoder = gathererEncoder.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 4096);

        gathererMotor.setSoftLimit(SoftLimitDirection.kForward, 0);
        gathererMotor.enableSoftLimit(SoftLimitDirection.kForward, false);
        gathererMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
        gathererMotor.enableSoftLimit(SoftLimitDirection.kReverse, false);

        forwardLimitSwitch = gathererMotor.getForwardLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        forwardLimitSwitch.enableLimitSwitch(false);
        reverseLimitSwitch = gathererMotor.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        reverseLimitSwitch.enableLimitSwitch(false);
    }


    public void gatherGamePiece()
    {
        gathererMotor.set(0.5);
    }

    // Incase gamepiece gets jammed or we need to release it
    // reverse direction of motors to push gamepiece out
    public void freeGamePiece()
    {
        gathererMotor.set(-0.5);
    }


    @Override
    public synchronized void readPeriodicInputs()
    {

    }

    @Override
    public synchronized void writePeriodicOutputs()
    {

    }
}