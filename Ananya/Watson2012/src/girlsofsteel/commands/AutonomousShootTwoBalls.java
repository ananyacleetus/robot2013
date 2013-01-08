package girlsofsteel.commands;

public class AutonomousShootTwoBalls extends CommandBase {

    double timeToShootTwoBalls = 5.0; //TODO find how long shooting 2 balls takes
    double xDistance;
    double velocity;
    
    public AutonomousShootTwoBalls(){
        requires(shooter);
        requires(collector);
    }
    
    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
        turret.initEncoder();
        turret.enablePID();
    }
 jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden 
    protected void execute() {
        turret.autoTrack();
        shooter.autoShoot();
    }

    protected boolean isFinished() {
        if(timeSinceInitialized() > timeToShootTwoBalls){
            return true;
        }else{
            return false;
        }
    }

    protected void end() {
        shooter.disablePID();
        shooter.topRollersOff();
        collector.stopBrush();
        collector.stopMiddleConveyor();
    }

    protected void interrupted() {
        end();
    }
    
}
