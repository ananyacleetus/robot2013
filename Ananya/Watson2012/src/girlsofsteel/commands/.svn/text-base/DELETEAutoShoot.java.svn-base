package girlsofsteel.commands;

import edu.wpi.first.wpilibj.command.Command;

public class DELETEAutoShoot extends CommandBase {

    Command autoShootWhileMoving = new DELETEAutoShootWhileMoving();
    Command autoShootImmobile = new DELETEAutoShootImmobile();
    
    protected void initialize() {
        if(chassis.isMoving()){
            autoShootWhileMoving.start();
        }else{
            autoShootImmobile.start();
        }
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
    
}
