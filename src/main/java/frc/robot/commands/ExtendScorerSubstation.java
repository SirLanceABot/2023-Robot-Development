package frc.robot.commands;

import frc.robot.Constants.TargetPosition;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Shoulder;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

// import frc.robot.subsystems.Arm.TargetPosition;
// import frc.robot.subsystems.Shoulder.TargetPosition;
import java.lang.invoke.MethodHandles;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;


/** 
 * Move arm and shoulder to a scoring position. Uses arm and shoulder subsytems. 
 */
public class ExtendScorerSubstation extends SequentialCommandGroup
{
    // This string gets the full name of the class, including the package name
    private static final String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    // *** STATIC INITIALIZATION BLOCK ***
    // This block of code is run first when the class is loaded
    static
    {
        System.out.println("Loading: " + fullClassName);
    }

    // *** CLASS AND INSTANCE VARIABLES ***
    private final Shoulder shoulder;
    private final Arm arm;
    private final Grabber grabber;


    /**
     * Creates a new ExtendScorerSubstation.
     * DELETE AFTER TESTING EXTEND SCORE WITH NEW CASES
     *
     * @param shoulder The shoulder subsystem.
     * @param arm The arm subystem.
     * @param grabber The grabber subsystem
     */
    public ExtendScorerSubstation(Shoulder shoulder, Arm arm, Grabber grabber) 
    {
        this.shoulder = shoulder;
        this.arm = arm;
        this.grabber = grabber;
        
        // Use addRequirements() here to declare subsystem dependencies.
        // if(shoulder != null && arm != null &&  grabber != null && wrist != null)
        if(shoulder != null && arm != null && grabber != null)
        {
            addRequirements(this.shoulder);
            addRequirements(this.arm);
            addRequirements(this.grabber);

            build();
        }
    }

    private void build()
    {
        addCommands( new ParallelCommandGroup( 
            new GrabGamePiece(grabber),
            new MoveShoulderToScoringPosition(shoulder, TargetPosition.kSubstation),
            new SequentialCommandGroup( 
                new WaitUntilCommand(() -> shoulder.getPosition() > TargetPosition.kLowCone.shoulder).withTimeout(1.0)),
                new MoveArmToScoringPosition(arm, TargetPosition.kSubstation)));
        // addCommands( new MoveShoulderToScoringPosition(shoulder, targetPosition) );
        // addCommands( new ParallelCommandGroup( 
        //     new GrabGamePiece(grabber), 
        //     new MoveArmToScoringPosition(arm, targetPosition)));
        // addCommands( new MoveWrist(wrist, WristPosition.kUp) );
        // addCommands( new MoveArmToScoringPosition(arm, targetPosition) );
        // addCommands( new ReleaseGamePiece(grabber) );
    }

    @Override
    public String toString()
    {
        return "ExtendScorerSubstation()";
    }
}