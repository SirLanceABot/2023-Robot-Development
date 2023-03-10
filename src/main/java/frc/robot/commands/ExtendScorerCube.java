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
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;


/** 
 * Move arm and shoulder to a scoring position. Uses arm and shoulder subsytems. 
 */
public class ExtendScorerCube extends SequentialCommandGroup
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
    // private final Grabber grabber;
    private final Wrist wrist;
    private TargetPosition targetPosition;


    /**
     * Creates a new ExtendScorerCube.
     * DELETE AFTER TESTING EXTEND SCORE WITH NEW CASES
     *
     * @param shoulder The shoulder subsystem.
     * @param arm The arm subystem.
     * @param wrist The wrist subsystem.
     * @param targetPosition Target position (Type: TargetPosition)
     */
    public ExtendScorerCube(Shoulder shoulder, Arm arm, Wrist wrist, TargetPosition targetPosition) 
    {
        this.shoulder = shoulder;
        this.arm = arm;
        // this.grabber = grabber;
        this.wrist = wrist;
        this.targetPosition = targetPosition;
        
        // Use addRequirements() here to declare subsystem dependencies.
        // if(shoulder != null && arm != null &&  grabber != null && wrist != null)
        if(shoulder != null && arm != null && wrist != null)
        {
            addRequirements(this.shoulder);
            addRequirements(this.arm);
            // addRequirements(this.grabber);
            addRequirements(this.wrist);

            build();
        }
    }

    private void build()
    {
        
        addCommands( new MoveShoulderToScoringPosition(shoulder, targetPosition));
        addCommands( new MoveArmToScoringPosition(arm, targetPosition));
        // addCommands( new MoveWrist(wrist, WristPosition.kUp) );
        // addCommands( new MoveArmToScoringPosition(arm, targetPosition) );
        // addCommands( new ReleaseGamePiece(grabber) );
    }

    @Override
    public String toString()
    {
        return "ExtendScorer(" + targetPosition + ")";
    }
}