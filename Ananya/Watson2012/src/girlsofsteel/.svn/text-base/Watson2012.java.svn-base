package girlsofsteel;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import girlsofsteel.commands.AutonomousChooser;
import girlsofsteel.commands.CameraAuto;
import girlsofsteel.commands.CommandBase;
import girlsofsteel.commands.DriveSlowTurning;
import girlsofsteel.commands.TESTChassis;
import girlsofsteel.commands.TuningShooterPID;
import girlsofsteel.commands.TurretTrackTarget;
import girlsofsteel.objects.Camera;

public class Watson2012 extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autonomousChooser;
    
    Command buttons;
    Command driveJagsLinear;
    Command turretTracking;

    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        autonomousCommand = new AutonomousChooser();//uses the counter mapped
        //to the different autonomous commands to the counter
//        buttons = new Buttons();//runs different commands based on the physical buttons/switches
        driveJagsLinear = new DriveSlowTurning(1.0);
        turretTracking = new TurretTrackTarget();

        SmartDashboard.putData(new TuningShooterPID());
        SmartDashboard.putData(new TESTChassis());
       
        SmartDashboard.putData(new CameraAuto());
        
//        SmartDashboard.putData(new DrivePositionChassisTuning());
//        SmartDashboard.putData(new DriveVelocityChassisTuning());
//        SmartDashboard.putData(new TESTMoveToSetPoint());
//        SmartDashboard.putData(new TESTTurnToSetPoint());
//        SmartDashboard.putData(new TESTGoToLocation());
//        
//        SmartDashboard.putData(new TESTDriveSlowVelocity());

        SmartDashboard.putData(Scheduler.getInstance());
    }

    public void autonomousInit() {
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Camera is connected?", Camera.isConnected());
        SmartDashboard.putBoolean("Target is found?", Camera.foundTarget());
    }

    public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
//        buttons.start();
        driveJagsLinear.start();
//        turretTracking.start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Camera is connected?", Camera.isConnected());
        SmartDashboard.putBoolean("Target is found?", Camera.foundTarget());
    }

    public void disabledPeriodic() {
        SmartDashboard.putBoolean("Camera is connected?", Camera.isConnected());
        SmartDashboard.putBoolean("Target is found?", Camera.foundTarget());
        SmartDashboard.putDouble("Shooter Encoder Rate: ", CommandBase.shooter.getEncoderRate());

    }
}
