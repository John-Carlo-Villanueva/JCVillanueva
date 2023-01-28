package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase{
    private final CANSparkMax rightB = new CANSparkMax(15, MotorType.kBrushless);
    private final CANSparkMax rightF = new CANSparkMax(2, MotorType.kBrushless);
    private final MotorControllerGroup armMotor = new MotorControllerGroup(rightF, rightB);
    private RelativeEncoder armEnc = rightF.getEncoder();

    public ArmSubsystem(){
        armEnc = rightF.getEncoder();
    }

    @Override
    public void periodic(){}

    //////////////////////
    //      Methods     //
    //////////////////////

    public void setFwd(double speed){
        armMotor.set(speed);
    }

    public void setBwd(double speed){
        armMotor.set(-speed);
    }

    public void setArmStop(){
        armMotor.set(0);
    }

    public void setArmReset(){
        armEnc.setPosition(0);
    }

    public double getArmEnc(){
        return armEnc.getPosition();
    }
}
