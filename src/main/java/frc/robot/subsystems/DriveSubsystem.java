package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private final CANSparkMax driveMotorA = new CANSparkMax(6, MotorType.kBrushless);
    private final CANSparkMax driveMotorB = new CANSparkMax(3, MotorType.kBrushless);
    private double speed = 0.5;

    public DriveSubsystem() {}

    public void periodic() {}

    public void setFwd(){
        driveMotorA.set(speed);
        driveMotorB.set(speed);
    }

    public void setBwd(){
        driveMotorA.set(-speed);
        driveMotorB.set(-speed);
    }

    public void setStop(){
        driveMotorA.set(0);
        driveMotorB.set(0);
    }
}
