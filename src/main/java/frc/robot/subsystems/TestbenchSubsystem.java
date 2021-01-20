/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.TestbenchCommand;

/**
 * Add your docs here.
 */
public class TestbenchSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // motor controllers
  // public WPI_TalonSRX talonsrx0 = new WPI_TalonSRX(RobotMap.TALONSRX0_CAN);
  public VictorSP victorsp0 = new VictorSP(RobotMap.VICTORSP0_PWM);
  //public CANSparkMax sparkmax0 = new CANSparkMax(RobotMap.SPARKMAX0_CAN, MotorType.kBrushless);
  public VictorSP succc0 = new VictorSP(RobotMap.SUCCC0_PWM);

  // compressor
  public Compressor air0 = new Compressor(RobotMap.AIR0_CAN);

  // solenoids
  public Solenoid s0 = new Solenoid(0);
  public Solenoid s1 = new Solenoid(1);
  public Solenoid s2 = new Solenoid(2);
  public Solenoid s3 = new Solenoid(3);
  public Solenoid s4 = new Solenoid(4);
  public Solenoid s5 = new Solenoid(5);
  public Solenoid s6 = new Solenoid(6);
  public Solenoid s7 = new Solenoid(7);
  
  // button board
  // public DigitalInput talonsrx0Switch = new DigitalInput(RobotMap.TALONSRX0_DIO);
  public DigitalInput victorsp0Switch = new DigitalInput(RobotMap.VICTORSP0_DIO);
  public DigitalInput sparkmax0Switch = new DigitalInput(RobotMap.SPARKMAX0_DIO);
  public DigitalInput air0Switch = new DigitalInput(RobotMap.AIR0_DIO);
  public DigitalInput succc0Switch = new DigitalInput(RobotMap.SUCCC0_DIO);
  public DigitalInput keySwitch = new DigitalInput(RobotMap.KEY_DIO);

  public AnalogInput swerve0Encoder = new AnalogInput(RobotMap.SWERVE0_ENCODER_ANALOG);

}
