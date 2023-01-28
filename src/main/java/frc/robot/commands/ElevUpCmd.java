package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ElevSubsystem;

public class ElevUpCmd extends CommandBase{
    
    //Variables
    private final ElevSubsystem elevSub;

    public ElevUpCmd(ElevSubsystem elevSub){
        this.elevSub = elevSub;
        addRequirements(elevSub);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        SmartDashboard.putNumber("ElevEnc", elevSub.getElevEnc());
        if(elevSub.getElevEnc() > -92){
            elevSub.setUp(.4);
        } else{
            elevSub.setElevStop();
        }
    }

    @Override
    public void end(boolean interuppted){
        elevSub.setElevStop();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
