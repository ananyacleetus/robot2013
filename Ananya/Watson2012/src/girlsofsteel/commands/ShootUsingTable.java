package girlsofsteel.commands;

public class ShootUsingTable extends CommandBase {

    double distance;
    double speed;
    
    public ShootUsingTable() {
        requires(shooter);
    }

    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
    }
    
    protected void execute() {
        shooter.autoShoot();
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
