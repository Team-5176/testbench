/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TestbenchCommand extends Command {
  // private boolean talonsrx0InitialState = true;
  private boolean victorsp0InitialState = true;
  private boolean sparkmax0InitialState = true;
  private boolean air0InitialState = true;
  private boolean succc0InitialState = true;

  public TestbenchCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.testbenchSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // talonsrx0InitialState = Robot.testbenchSubsystem.talonsrx0Switch.get();
    victorsp0InitialState = Robot.testbenchSubsystem.victorsp0Switch.get();
    sparkmax0InitialState = Robot.testbenchSubsystem.sparkmax0Switch.get();
    air0InitialState = Robot.testbenchSubsystem.air0Switch.get();
    succc0InitialState = Robot.testbenchSubsystem.succc0Switch.get();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // DriverStation.reportWarning("talonsrx0switch:" + Robot.testbenchSubsystem.talonsrx0Switch.get(), false);
    // if (Robot.testbenchSubsystem.talonsrx0Switch.get() != talonsrx0InitialState) {
    //   Robot.testbenchSubsystem.talonsrx0.set(RobotMap.TALONSRX0_ONSPEED);
    // } else {
    //   Robot.testbenchSubsystem.talonsrx0.set(RobotMap.TALONSRX0_OFFSPEED);
    // }

    if (Robot.testbenchSubsystem.victorsp0Switch.get() != victorsp0InitialState) {
      Robot.testbenchSubsystem.victorsp0.set(RobotMap.VICTORSP0_ONSPEED);
    } else {
      Robot.testbenchSubsystem.victorsp0.set(RobotMap.VICTORSP0_OFFSPEED);
    }

    // DriverStation.reportWarning("sparkmax0switch:" + Robot.testbenchSubsystem.sparkmax0Switch.get(), false);
    if (Robot.testbenchSubsystem.sparkmax0Switch.get() != sparkmax0InitialState) {
      Robot.testbenchSubsystem.sparkmax0.set(RobotMap.SPARKMAX0_ONSPEED);
    } else {
      Robot.testbenchSubsystem.sparkmax0.set(RobotMap.SPARKMAX0_OFFSPEED);
    }
    
    if (Robot.testbenchSubsystem.air0Switch.get() != air0InitialState) {
      Robot.testbenchSubsystem.air0.setClosedLoopControl(true);
    } else {
      Robot.testbenchSubsystem.air0.setClosedLoopControl(false);
    }

    if (Robot.testbenchSubsystem.succc0Switch.get() != succc0InitialState) {
      Robot.testbenchSubsystem.succc0.set(RobotMap.SUCCC0_ONSPEED);
      DriverStation.reportWarning("SUCCC0_ON", false);
    } else {
      Robot.testbenchSubsystem.succc0.set(RobotMap.SUCCC0_OFFSPEED);
      DriverStation.reportWarning("SUCCC0_OFF", false);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
