package frc.robot;

import frc.robot.commands.ElevL1Cmd;
import frc.robot.commands.ElevL2Cmd;
import frc.robot.commands.ElevL3Cmd;
import frc.robot.commands.ArmElevStopCmd;
import frc.robot.commands.ElevDownCmd;
import frc.robot.commands.ElevUpCmd;
import frc.robot.commands.ArmElevResetCmd;
import frc.robot.commands.ArmBwdCmd;
import frc.robot.commands.ArmFwdCmd;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveTestCmd;
import frc.robot.commands.ElevCmd;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ElevSubsystem elevSubsystem = new ElevSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  //private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  //private final DriveTestCmd driveTestCmd = new DriveTestCmd(driveSubsystem);
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final Joystick stick = new Joystick(0);
  private final XboxController xController = new XboxController(3);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
      //new JoystickButton(xController, 2).onTrue(new DriveTestCmd(driveSubsystem));
      //new JoystickButton(xController, 1).onTrue(new ElevCmd(elevSubsystem));
      //new JoystickButton(xController, 1).whileTrue(new ElevDownCmd(elevSubsystem));new JoystickButton(xController, 1).whileFalse(new ArmElevStopCmd(armSubsystem, elevSubsystem));
      //new JoystickButton(xController, 4).whileTrue(new ElevUpCmd(elevSubsystem));new JoystickButton(xController, 4).whileFalse(new ArmElevStopCmd(armSubsystem, elevSubsystem));
      //new JoystickButton(xController, 2).whileTrue(new ArmBwdCmd(armSubsystem));new JoystickButton(xController, 2).whileFalse(new ArmElevStopCmd(armSubsystem, elevSubsystem));
      //new JoystickButton(xController, 3).whileTrue(new ArmFwdCmd(armSubsystem));new JoystickButton(xController, 3).whileFalse(new ArmElevStopCmd(armSubsystem, elevSubsystem));
      new JoystickButton(xController, 1).onTrue(new ElevL1Cmd(elevSubsystem));
      new JoystickButton(xController, 2).onTrue(new ElevL2Cmd(elevSubsystem));
      new JoystickButton(xController, 3).onTrue(new ElevL3Cmd(elevSubsystem));
      new JoystickButton(xController, 5).onTrue(new ArmElevResetCmd(armSubsystem, elevSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
