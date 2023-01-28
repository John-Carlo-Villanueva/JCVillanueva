package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ElevSubsystem;

public class ArmElevResetCmd extends CommandBase{
    
    // Variable
    private final ArmSubsystem armSub;
    private final ElevSubsystem elevSub;

    public ArmElevResetCmd(ArmSubsystem armSub, ElevSubsystem elevSub){
        this.armSub = armSub;
        this.elevSub = elevSub;
        addRequirements(armSub);
        addRequirements(elevSub);
    } // Constructor of ArmCmd

    @Override
    public void initialize(){
    } // Start of ArmCmd

    @Override
    public void execute(){
        SmartDashboard.putString("State:", "ArmEnc Reset");
        armSub.setArmReset();
        elevSub.setElevReset();
    } // Main Actions of ArmCmd

    @Override
    public void end(boolean interrupted){

    } // End of ArmCmd

    @Override
    public boolean isFinished(){
        return false;
    } // Returns a boolean to activate End
}
