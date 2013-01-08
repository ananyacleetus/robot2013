package girlsofsteel.commands;

import girlsofsteel.objects.Camera;

public class DELETEAutoShootImmobile extends CommandBase {
    
    double xDistance;
    double ballVelocity;
    
    public DELETEAutoShootImmobile(){
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
    }

    protected void execute() {
        xDistance = shooter.getDistance();
        this.ballVelocity = shooter.getImmobileBallVelocity(xDistance);
        shooter.shootUsingBallVelocity(this.ballVelocity);
        if(shooter.isWithinSetPoint(this.ballVelocity)
                && !oi.areTopRollersOverriden()){
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