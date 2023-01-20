package frc.robot.commands;

import java.lang.invoke.MethodHandles;
import frc.robot.subsystems.Gatherer;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

//accesses Gatherer
public class TurnOffGathererIntake extends CommandBase
{
    //gets class name and package
    private final static String fullClassName = MethodHandles.lookup().lookupClass().getCanonicalName();

    static
    {
        System.out.println("Loading: " + fullClassName);
    }

    private Gatherer gatherer;

     /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */

    public TurnOffGathererIntake(Gatherer gatherer)
    {
        this.gatherer = gatherer;

        addRequirements(this.gatherer);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted)
    {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
        return false;
    }
}