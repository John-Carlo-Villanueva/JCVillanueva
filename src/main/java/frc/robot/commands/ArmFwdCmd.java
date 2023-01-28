package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmFwdCmd extends CommandBase{
    
    // Variable
    private final ArmSubsystem armSub;

    public ArmFwdCmd(ArmSubsystem armSub){
        this.armSub = armSub;
        addRequirements(armSub);
    } // Constructor of ArmCmd

    @Override
    public void initialize(){
    } // Start of ArmCmd

    @Override
    public void execute(){
        SmartDashboard.putNumber("ArmEnc", armSub.getArmEnc());
        if (armSub.getArmEnc() < 92){
            armSub.setFwd(.5);
        } else{
            armSub.setArmStop();
        }

    } // Main Actions of ArmCmd

    @Override
    public void end(boolean interrupted){

    } // End of ArmCmd

    @Override
    public boolean isFinished(){
        return false;
    } // Returns a boolean to activate End
}