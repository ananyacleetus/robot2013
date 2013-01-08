package girlsofsteel.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TESTShootUsingTable extends CommandBase {

    double distance;
    double speed;
    
    public TESTShootUsingTable() {
        requires(shooter);
        SmartDashboard.putDouble("Shooting Distance", 0.0);
    }

    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
    }

    protected void execute() {
        shooter.setPIDValues();
        distance = SmartDashboard.getDouble("Shooting Distance", 0.0);
        speed = shooter.getVelocityFrTable(distance);
        shooter.setPIDSpeed(speed);
        if (shooter.isWithinSetPoint(speed) && !oi.areTopRollersOverriden()) {
            shooter.topRollersForward();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        if(!oi.areTopRollersOverriden()){
            shooter.topRollersOff();
        }
        shooter.disablePID();
        shooter.stopEncoder();
    }

    protected void interrupted() {
        end();
    }
}