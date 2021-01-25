/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetSocketAddress;
import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  public static RobotContainer m_robotContainer;
  // public static FakeDS fakeDS;
  private Thread dsThread = new Thread(
    () -> {
      DatagramSocket socket;
      try {
        socket = new DatagramSocket();
      } catch (SocketException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        return;
      }
      InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 1110);
      byte[] sendData = new byte[6];
      DatagramPacket packet = new DatagramPacket(sendData, 0, 6, addr);
      short sendCount = 0;
      int initCount = 0;
      while (!Thread.currentThread().isInterrupted()) {
        if (m_robotContainer.testbenchSubsystem.keySwitch.get() == false) {
          try {
            Thread.sleep(20);
            generateEnabledDsPacket(sendData, sendCount++);
            // ~50 disabled packets are required to make the robot actually enable
            // 1 is definitely not enough.
            if (initCount < 50) {
              initCount++;
              sendData[3] = 0;
            }
            packet.setData(sendData);
            socket.send(packet);
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
          }
        }
      }
      socket.close();
    });;

  private void generateEnabledDsPacket(byte[] data, short sendCount) {
    data[0] = (byte) (sendCount >> 8);
    data[1] = (byte) sendCount;
    data[2] = 0x01; // general data tag
    data[3] = 0x04; // teleop enabled
    data[4] = 0x10; // normal data request
    data[5] = 0x00; // red 1 station
  }

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    dsThread.setDaemon(true);
    dsThread.start();
    // try {
    //   Runtime.getRuntime().exec(new String[] { "touch", "/home/lvuser/testing123" });
    // } catch (IOException e) {
    //   // TODO Auto-generated catch block
    //   e.printStackTrace();
    // }
    // ProcessBuilder pb = new ProcessBuilder("touch", "/home/lvuser/testing123");
    // try {
    //   Process p = pb.start();
    // } catch (IOException e) {
    //   // TODO Auto-generated catch block
    //   e.printStackTrace();
    // }
    // fakeDS = new FakeDS();
    // File f = new File("/home/lvuser/testing123");
    // try {
    //   f.createNewFile();
    // } catch (IOException e) {
    //   // TODO Auto-generated catch block
    //   e.printStackTrace();
    // }
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
    // ProcessBuilder pb = new ProcessBuilder("touch /home/lvuser/testing123");
    // try {
    //   Process p = pb.start();
    // } catch (IOException e) {
    //   // TODO Auto-generated catch block
    //   e.printStackTrace();
    // }
    // fakeDS.start();
    // File f = new File("/home/lvuser/testing123");
    // try {
    //   f.createNewFile();
    // } catch (IOException e) {
    //   // TODO Auto-generated catch block
    //   e.printStackTrace();
    // }
  }

  @Override
  public void disabledPeriodic() {
    // if (m_robotContainer.haveIStartedFakeDS == false) {
    //   if (m_robotContainer.testbenchSubsystem.keySwitch.get() == false) {
    //     m_robotContainer.ds.start();
    //     m_robotContainer.haveIStartedFakeDS = true;
    //   }
    // }
    // DriverStation.reportWarning("ehh", false);
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
