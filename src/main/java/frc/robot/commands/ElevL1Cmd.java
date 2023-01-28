package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevSubsystem;

public class ElevL1Cmd extends CommandBase {

    private XboxController xController;
    private ElevSubsystem elevSub;
    private double setpoint = elevSub.setpoint();

    public ElevL1Cmd(ElevSubsystem elevSub) {
        this.elevSub = elevSub;
        addRequirements(elevSub);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute() {
        SmartDashboard.putNumber("ElevEnc", elevSub.getElevEnc());

        if (xController.getRawButton(1) == true){
            setpoint = 100;
        } else {
            elevSub.setElevStop();
        }
        double outputSpeed = elevSub.calculateP() + elevSub.calculateI() + elevSub.calculateD();

        elevSub.setUp(outputSpeed);
    }

    @Override
    public void end(boolean interuppted) {
        elevSub.setElevStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
