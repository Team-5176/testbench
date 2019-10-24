/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TestbenchCommand;

/**
 * Add your docs here.
 */
public class TestbenchSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // motor controllers
  public WPI_TalonSRX talonsrx0 = new WPI_TalonSRX(RobotMap.TALONSRX0_CAN);
  public CANSparkMax sparkmax0 = new CANSparkMax(RobotMap.SPARKMAX0_CAN, MotorType.kBrushless);
  
  // button board
  public DigitalInput talonsrx0Switch = new DigitalInput(RobotMap.TALONSRX0_DIO);
  public DigitalInput sparkmax0Switch = new DigitalInput(RobotMap.SPARKMAX0_DIO);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TestbenchCommand());
  }
}
