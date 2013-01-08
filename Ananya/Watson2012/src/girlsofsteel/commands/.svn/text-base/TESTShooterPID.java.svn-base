package girlsofsteel.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TESTShooterPID extends CommandBase {

    double speed;
    double setpoint;
    
    double p;
    double i;
    double d;
    
    double rate;
    double difference;
    
    double[] rateList;
    
    public TESTShooterPID() {
        requires(shooter);
        SmartDashboard.putDouble("Shooter Setpoint", 0.0);
        SmartDashboard.putDouble("Shooter,p", 0.0);
        SmartDashboard.putDouble("Shooter,i", 0.0);
        SmartDashboard.putDouble("Shooter,d", 0.0);
    }

    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
    }

    protected void execute() {
        p = SmartDashboard.getDouble("Shooter,p", 0.0);
        i = SmartDashboard.getDouble("Shooter,i",0.0);
        d = SmartDashboard.getDouble("Shooter,d",0.0);
        shooter.setPIDValues(p, i, d);
        setpoint = SmartDashboard.getDouble("Shooter Setpoint", 0.0);
        shooter.setPIDSpeed(setpoint);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.disablePID();
        shooter.stopEncoder();
        shooter.stopJags();
    }

    protected void interrupted() {
        end();
    }

}