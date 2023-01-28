package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.math.controller.PIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevSubsystem extends SubsystemBase{
    
    private final CANSparkMax leftB = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax leftF = new CANSparkMax(6, MotorType.kBrushless);
    private final MotorControllerGroup elevMotor = new MotorControllerGroup(leftF, leftB);
    private RelativeEncoder elevEnc = leftF.getEncoder();
    private final PIDController elevPID = new PIDController(0.05, 0.005, 0.01);
    private final double driveTick2Ft = 1.0 / 128 * 6 * Math.PI / 12;
    final double iLimit = 10;
    private double setpoint = 0;
    private double errorsum = 0;
    private double lastTimeStamp = 0;
    private double lastError = 0;    
    private double encPosition = elevEnc.getPosition() * driveTick2Ft;
    private double error = setpoint - encPosition;
    private double deltaT = Timer.getFPGATimestamp() - lastTimeStamp;
    private double errorRate = (error - lastError) / deltaT;
    
    public ElevSubsystem() {
        elevEnc = leftF.getEncoder();
    }

    @Override
    public void periodic() {}

    //////////////////////
    //      Methods     //
    //////////////////////

    public void setDown(double speed){
        elevMotor.set(-speed);
    }

    public void setUp(double speed){
        elevMotor.set(speed);
    }

    public void setElevStop(){
        elevMotor.set(0);
    }

    public void setElevReset(){
        elevEnc.setPosition(0);
    }

    public void calculations() {
        if (Math.abs(error) < iLimit) {
            errorsum += error * deltaT;
        }
    }

    public double getElevEnc(){
        return elevEnc.getPosition();
    }

    public double getElevP(){
        return elevPID.getP();
    }

    public double getElevI(){
        return elevPID.getI();
    }

    public double getElevD(){
        return elevPID.getD();
    }

    public double calculateP(){
        return elevPID.getP() * error;
    }

    public double calculateI(){
        return elevPID.getI() * errorsum;
    }

    public double calculateD(){
        return elevPID.getD() * errorRate;
    }

    public double setpoint(){
        return setpoint;
    }
}