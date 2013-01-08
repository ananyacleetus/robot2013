package girlsofsteel.commands;

import edu.wpi.first.wpilibj.Joystick;
import girlsofsteel.objects.Camera;

public class TurretTrackTarget extends CommandBase {

    Joystick operatorJoystick;
    
    double offSetAngle = turret.OFFSET_ANGLE;
    double difference;
    
    public TurretTrackTarget() {
        requires(turret);
    }

    protected void initialize() {
        turret.initEncoder();
        turret.enablePID();
        operatorJoystick = oi.getOperatorJoystick();
    }

    protected void execute() {
        if (Camera.foundTarget()) {
            turret.autoTrack();
        }else{
            difference = operatorJoystick.getX()*5.0;
            if(difference < -2.0 || difference > 2.0){
                turret.setPIDSetPoint(turret.getTurretAngle() + difference);
            }
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        turret.disablePID();
    }

    protected void interrupted() {
        end();
    }
}
