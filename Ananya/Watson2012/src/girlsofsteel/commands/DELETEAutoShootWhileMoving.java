package girlsofsteel.commands;

import girlsofsteel.objects.Camera;

public class DELETEAutoShootWhileMoving extends CommandBase {
    
    double xDistance;
    double theta;
    double robotVelocityX;
    double robotVelocityY;
    double ballVelocity;
    double angleCompensation;
    
    public DELETEAutoShootWhileMoving(){
        requires(shooter);
        requires(turret);
    }
    
    protected void initialize() {
        shooter.initEncoder();
        shooter.initPID();
    }

    protected void execute() {
        xDistance = shooter.getDistance();
        theta = chassis.getTheta();
        chassis.getRobotVelocityX(theta);
        chassis.getRobotVelocityY(theta);
        this.ballVelocity = shooter.getMovingBallVelocity(xDistance, robotVelocityY, robotVelocityX);
        angleCompensation = shooter.getAngleCompensation(robotVelocityX); //degrees
        turret.moveToAngleCompensation(angleCompensation); //degrees
        shooter.shootUsingBallVelocity(this.ballVelocity);
        if(shooter.isWithinSetPoint(this.ballVelocity) && !oi.areTopRollersOverriden()){
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