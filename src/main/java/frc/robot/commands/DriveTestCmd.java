package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveTestCmd extends CommandBase {
    
    private DriveSubsystem driveSubsystem;
    private int counts = 0;
    public Timer timer;

    public DriveTestCmd(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        timer = new Timer();
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("State: ", "DriveTestCmd started!");
    }

    @Override
    public void execute() {
        SmartDashboard.putString("State: ", "Executing DriveTestCmd...");
        SmartDashboard.putNumber("Counts: ", counts);
        switch (counts) {
            case 0:
                timer.reset();
                timer.start();
                counts++;
                break;

            case 1:
                if (timer.get() <= 5) {
                    driveSubsystem.setFwd();
                } else {
                    driveSubsystem.setStop();
                    timer.reset();
                    timer.start();
                    counts++;
                }
                break;

            case 2:
                if (timer.get() <= 2) {
                    driveSubsystem.setStop();
                } else {
                    timer.reset();
                    timer.start();
                    counts++;
                }
                break;

            case 3:
                if (timer.get() <= 10) {
                    driveSubsystem.setBwd();
                } else {
                    driveSubsystem.setStop();
                    counts++;
                }
                break;
        }

        /*
         * while(timer.get() <= 5){
         * new DriveForwardCmd(driveSubsystem, speed);
         * }
         * timer.reset();
         * while(timer.get() <= 2){
         * driveSubsystem.setMotor(0);
         * }
         * timer.reset();
         * while(timer.get() <= 10){
         * new DriveBackwardCmd(driveSubsystem, speed);
         * }
         * driveSubsystem.setMotor(0);
         */
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setStop();
        counts = 0;
        SmartDashboard.putString("State: ", "DriveTestCmd ended!");
    }

    @Override
    public boolean isFinished() {
        if (counts > 3) {
            return true;
        } else {
            return false;
        }
    }
}