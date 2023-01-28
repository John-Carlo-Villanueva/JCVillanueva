package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevSubsystem;
import frc.robot.subsystems.ArmSubsystem;

public class ArmElevStopCmd extends CommandBase{
    
    private final ElevSubsystem elevSub;
    private final ArmSubsystem armSub;

    public ArmElevStopCmd(ArmSubsystem armSub, ElevSubsystem elevSub){
        this.armSub = armSub;
        this.elevSub = elevSub;
        addRequirements(armSub);
        addRequirements(elevSub);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        armSub.setArmStop();
        elevSub.setElevStop();
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}
