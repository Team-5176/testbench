/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.TestbenchCommand;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.commands.ExampleCommand;
// import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.TestbenchSubsystem;

public class RobotContainer {
  // public static ExampleSubsystem subsystem = new ExampleSubsystem();
  // public static OI oi;
  public final Joystick stick = new Joystick(0);
  public final TestbenchSubsystem testbenchSubsystem = new TestbenchSubsystem();

  public final TestbenchCommand testbenchCommand = new TestbenchCommand(testbenchSubsystem);

  // public static FakeDS ds;
  public boolean haveIStartedFakeDS = false;

  // Command autonomousCommand;
  // SendableChooser<Command> chooser = new SendableChooser<>();

  public RobotContainer() {
    testbenchSubsystem.setDefaultCommand(testbenchCommand);
    // ds = new FakeDS();
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    // return null;
    return null;
  }

  // /**
  //  * This function is run when the robot is first started up and should be
  //  * used for any initialization code.
  //  */
  // @Override
  // public void robotInit() {
  //   testbenchSubsystem = new TestbenchSubsystem();
  //   //oi = new OI();
  //   ds = new FakeDS();
  //   // if (testbenchSubsystem.keySwitch.get() == true) {
  //   //   ds.start();
  //   //   haveIStartedFakeDS = true;
  //   // }
  //   // chooser.setDefaultOption("Default Auto", new ExampleCommand());
  //   // chooser.addOption("My Auto", new MyAutoCommand());
  //   // SmartDashboard.putData("Auto mode", chooser);
  // }

  // /**
  //  * This function is called every robot packet, no matter the mode. Use
  //  * this for items like diagnostics that you want ran during disabled,
  //  * autonomous, teleoperated and test.
  //  *
  //  * <p>This runs after the mode specific periodic functions, but before
  //  * LiveWindow and SmartDashboard integrated updating.
  //  */
  // @Override
  // public void robotPeriodic() {
  // }

  // /**
  //  * This function is called once each time the robot enters Disabled mode.
  //  * You can use it to reset any subsystem information you want to clear when
  //  * the robot is disabled.
  //  */
  // @Override
  // public void disabledInit() {
  // }

  // @Override
  // public void disabledPeriodic() {
  //   Scheduler.getInstance().run();
  //   if (haveIStartedFakeDS == false) {
  //     if (testbenchSubsystem.keySwitch.get() == false) {
  //       ds.start();
  //       haveIStartedFakeDS = true;
  //     }
  //   }
  // }

  // /**
  //  * This autonomous (along with the chooser code above) shows how to select
  //  * between different autonomous modes using the dashboard. The sendable
  //  * chooser code works with the Java SmartDashboard. If you prefer the
  //  * LabVIEW Dashboard, remove all of the chooser code and uncomment the
  //  * getString code to get the auto name from the text box below the Gyro
  //  *
  //  * <p>You can add additional auto modes by adding additional commands to the
  //  * chooser code above (like the commented example) or additional comparisons
  //  * to the switch structure below with additional strings & commands.
  //  */
  // @Override
  // public void autonomousInit() {
  //   // autonomousCommand = chooser.getSelected();

  //   /*
  //    * String autoSelected = SmartDashboard.getString("Auto Selector",
  //    * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
  //    * = new MyAutoCommand(); break; case "Default Auto": default:
  //    * autonomousCommand = new ExampleCommand(); break; }
  //    */

  //   // schedule the autonomous command (example)
  //   // if (autonomousCommand != null) {
  //     // autonomousCommand.start();
  //   // }
  // }

  // /**
  //  * This function is called periodically during autonomous.
  //  */
  // @Override
  // public void autonomousPeriodic() {
  //   Scheduler.getInstance().run();
  // }

  // @Override
  // public void teleopInit() {
  //   // This makes sure that the autonomous stops running when
  //   // teleop starts running. If you want the autonomous to
  //   // continue until interrupted by another command, remove
  //   // this line or comment it out.
  //   // if (autonomousCommand != null) {
  //     // autonomousCommand.cancel();
  //   // }
  // }

  // /**
  //  * This function is called periodically during operator control.
  //  */
  // @Override
  // public void teleopPeriodic() {
  //   Scheduler.getInstance().run();
  // }

  // /**
  //  * This function is called periodically during test mode.
  //  */
  // @Override
  // public void testPeriodic() {
  // }
}
