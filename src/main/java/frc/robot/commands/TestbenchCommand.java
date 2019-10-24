/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TestbenchCommand extends Command {
  public TestbenchCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.testbenchSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.testbenchSubsystem.talonsrx0Switch.get()) {
      Robot.testbenchSubsystem.talonsrx0.set(RobotMap.TALONSRX0_ONSPEED);
    } else {
      Robot.testbenchSubsystem.talonsrx0.set(RobotMap.TALONSRX0_OFFSPEED);
    }

    if (Robot.testbenchSubsystem.sparkmax0Switch.get()) {
      Robot.testbenchSubsystem.sparkmax0.set(RobotMap.SPARKMAX0_ONSPEED);
    } else {
      Robot.testbenchSubsystem.sparkmax0.set(RobotMap.SPARKMAX0_OFFSPEED);
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
