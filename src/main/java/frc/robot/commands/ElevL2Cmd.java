package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevSubsystem;

public class ElevL2Cmd extends CommandBase{

    private XboxController xController;
    private ElevSubsystem elevSub;
    private double setpoint = elevSub.setpoint();

    public ElevL2Cmd(ElevSubsystem elevSub){
        this.elevSub = elevSub;
        addRequirements(elevSub);
    }
    
    @Override
    public void initialize() {}

    public void execute() {
        SmartDashboard.putNumber("ElevEnc", elevSub.getElevEnc());

        if(xController.getRawButton(2) == true){
            setpoint = 200;
        } else{
            elevSub.setElevStop();
        }
        double outputSpeed = elevSub.calculateP() + elevSub.calculateI() + elevSub.calculateD();

        elevSub.setUp(outputSpeed);
    }

    public void end() {
        elevSub.setElevStop();
    }

    public boolean isFinished() {
        return false;
    }
}
