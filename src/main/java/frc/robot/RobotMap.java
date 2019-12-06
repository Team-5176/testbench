/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int SUCCC0_DIO = 0;
  public static final int AIR0_DIO = 1;
  // public static final int TALONSRX0_DIO = 2;
  public static final int VICTORSP0_DIO = 2;
  public static final int SPARKMAX0_DIO = 3;
  public static final int KEY_DIO = 9;

  // public static final int TALONSRX0_CAN = 2;
  public static final int SPARKMAX0_CAN = 3;
  public static final int AIR0_CAN = 1;

  public static final int SUCCC0_PWM = 0;
  public static final int VICTORSP0_PWM = 1;

  // public static final double TALONSRX0_ONSPEED = 1.00;
  // public static final double TALONSRX0_OFFSPEED = 0.00;
  public static final double VICTORSP0_ONSPEED = 1.00;
  public static final double VICTORSP0_OFFSPEED = 0.00;
  public static final double SPARKMAX0_ONSPEED = 1.00;
  public static final double SPARKMAX0_OFFSPEED = 0.00;
  public static final double SUCCC0_ONSPEED = 1.00;
  public static final double SUCCC0_OFFSPEED = 0.00;

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
