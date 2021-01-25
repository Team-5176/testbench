/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.TestbenchSubsystem;

public class TestbenchCommand extends CommandBase {
  private boolean talonsrx0InitialState = true;
  private TestbenchSubsystem testbenchSubsystem;
  private boolean victorsp0InitialState = true;
  private boolean sparkmax0InitialState = true;
  private boolean air0InitialState = true;
  private boolean succc0InitialState = true;

  public TestbenchCommand(TestbenchSubsystem testbenchSubsystem) {
    this.testbenchSubsystem = testbenchSubsystem;
    addRequirements(this.testbenchSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    talonsrx0InitialState = testbenchSubsystem.talonsrx0Switch.get();
    // victorsp0InitialState = testbenchSubsystem.victorsp0Switch.get();
    sparkmax0InitialState = testbenchSubsystem.sparkmax0Switch.get();
    air0InitialState = testbenchSubsystem.air0Switch.get();
    succc0InitialState = testbenchSubsystem.succc0Switch.get();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    DriverStation.reportWarning("talonsrx0switch:" + testbenchSubsystem.talonsrx0Switch.get(), false);
    if (testbenchSubsystem.talonsrx0Switch.get() != talonsrx0InitialState) {
      testbenchSubsystem.talonsrx0.set(RobotMap.TALONSRX0_ONSPEED);
    } else {
      testbenchSubsystem.talonsrx0.set(RobotMap.TALONSRX0_OFFSPEED);
    }
    boolean thing = SmartDashboard.getBoolean("reset reed", false);
    if (thing) {
      SmartDashboard.putBoolean("reset reed", false);
    }
    DriverStation.reportWarning("key:"+testbenchSubsystem.keySwitch.get(), false);

    // if (testbenchSubsystem.victorsp0Switch.get() != victorsp0InitialState) {
    //   testbenchSubsystem.victorsp0.set(RobotMap.VICTORSP0_ONSPEED);
    // } else {
    //   testbenchSubsystem.victorsp0.set(RobotMap.VICTORSP0_OFFSPEED);
    // }

    // DriverStation.reportWarning("sparkmax0switch:" + testbenchSubsystem.sparkmax0Switch.get(), false);
    if (testbenchSubsystem.sparkmax0Switch.get() != sparkmax0InitialState) {
      testbenchSubsystem.sparkmax0.set(RobotMap.SPARKMAX0_ONSPEED);
    } else {
      testbenchSubsystem.sparkmax0.set(RobotMap.SPARKMAX0_OFFSPEED);
    }
    
    if (testbenchSubsystem.air0Switch.get() != air0InitialState) {
      testbenchSubsystem.air0.setClosedLoopControl(true);
    } else {
      testbenchSubsystem.air0.setClosedLoopControl(false);
    }

    if (testbenchSubsystem.succc0Switch.get() != succc0InitialState) {
      testbenchSubsystem.succc0.set(RobotMap.SUCCC0_ONSPEED);
      DriverStation.reportWarning("SUCCC0_ON", false);
    } else {
      testbenchSubsystem.succc0.set(RobotMap.SUCCC0_OFFSPEED);
      DriverStation.reportWarning("SUCCC0_OFF", false);
    }

    testbenchSubsystem.s0.set(true);
    testbenchSubsystem.s1.set(true);
    testbenchSubsystem.s2.set(true);
    testbenchSubsystem.s3.set(true);

    // SmartDashboard.putNumber("swerve0Encoder", testbenchSubsystem.swerve0Encoder.getRawAngle().getDegrees());
    SmartDashboard.putNumber("swerve0Encoder", testbenchSubsystem.swerve0Encoder.get5176Angle());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override 
  public void end(boolean interrupted) {
  }

}
