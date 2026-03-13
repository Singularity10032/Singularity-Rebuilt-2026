package frc.robot.subsystems.HoodedShooter;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Interplut;

public class Shooter extends SubsystemBase{
    TalonFX upperRoller,lowerRoller;
    Interplut shooterTable = new Interplut();
    TalonFXConfiguration shooterConfig;
    public enum ShooterState{
        IDLE, SHOOTING
    }
    
    public Shooter(){
        upperRoller = new TalonFX();
        lowerRoller = new TalonFX();
        stop();
        shooterTable.addPoint(0.0, 0.5);//add points
    }

    public void setSpeed(double speed){
        upperRoller.set(speed);
        lowerRoller.set(speed);
    }

    public double getSpeed(){
        return upperRoller.get();
    }

    public void stop(){
        upperRoller.stopMotor();
        lowerRoller.stopMotor();
    }

    public double getInterpolatedSpeed(double distance){
        return shooterTable.getInterpolatedValue(distance);
    }



}
