package girlsofsteel.commands;

import edu.wpi.first.wpilibj.Joystick;

public class PS3ManualTurret extends CommandBase {

    Joystick operatorJoystick;
    
    double speed;
    
    public PS3ManualTurret(){
        requires(turret);
    }
    
    protected void initialize() {
        operatorJoystick = oi.getOperatorJoystick();
    }

    protected void execute() {
        speed = operatorJoystick.getX()*.5;
        turret.setJagSpeed(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden  jaden jaden jaden jaden jaden jaden jaden jaden end() {
    }

    protected void interrupted() {
        end();
    }
    
}
