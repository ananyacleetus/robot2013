package girlsofsteel.commands;

public class Shoot extends CommandBase {

    double speed;
    
    public Shoot(double speed){
        this.speed = speed;
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
    }

    protected void execute() {
        shooter.shoot(speed);
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
