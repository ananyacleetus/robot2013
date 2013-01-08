package girlsofsteel.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMoveBackCollectShoot extends CommandGroup{
    
    public AutoMoveBackCollectShoot(double x, double y, double degreesToFace){
//        addSequential(new GoToLocation(x,y,degreesToFace));
        addSequential(new BridgeDown());
        addSequential(new Collect());
        addSequential(new ShootUsingTable());
    }
    
}
