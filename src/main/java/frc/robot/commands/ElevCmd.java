package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevSubsystem;

public class ElevCmd extends CommandBase {

    //Variables

    private final ElevSubsystem elevSub;
    private int counts = 0;

    public ElevCmd(ElevSubsystem elevSub) {
        this.elevSub = elevSub;
        addRequirements(elevSub);
    } // Constructor of ElevCmd

    @Override
    public void initialize() {
        SmartDashboard.putString("StateElevCmd: ", "Initializing ElevCmd...");
        elevSub.setElevStop();
        elevSub.setElevReset();
    } // Start of ElevCmd

    @Override
    public void execute() {
        SmartDashboard.putString("StateElevCmd: ", "Executing ElevCmd...");
        SmartDashboard.putNumber("ElevEnc: ", elevSub.getElevEnc()); // Shows ElevEnc
        SmartDashboard.putNumber("Counts: ", counts);
        /*switch (counts) {
            case 0:
                elevSub.setElevReset();
                counts++;
                break;
            
            case 1: 
                if (elevSub.getElevEnc() < 100){
                    elevSub.setUp();
                } else{
                    counts++;
                }
                break;
            
            case 2:
                if (elevSub.getElevEnc() > -100){
                    elevSub.setDown();
                } else{
                    elevSub.setElevStop();
                    counts++;
                }
                break;
        }*/
    } // Main actions of ElevCmd

    @Override
    public void end(boolean interrupted) {
        elevSub.setElevStop();
        counts = 0;
        SmartDashboard.putString("StateElevCmd: ", "ElevCmd Ended");
    } // End of ElevCmd

    @Override
    public boolean isFinished() {
        if (counts > 2){
            return true;
        }
        return false;
    } // Returns a boolean to activate End
}
