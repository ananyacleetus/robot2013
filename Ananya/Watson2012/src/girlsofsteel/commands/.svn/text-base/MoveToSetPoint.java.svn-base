package girlsofsteel.commands;

public class MoveToSetPoint extends CommandBase {

    double distanceToMove;

    public MoveToSetPoint(double distance){
        distanceToMove = distance;
        requires(chassis);
    }

    protected void initialize(){
        chassis.initEncoders();
        chassis.initPositionPIDs();
    }

    protected void execute(){
        chassis.setPIDsPosition();
        chassis.move(distanceToMove);
    }

    protected boolean isFinished(){
        return chassis.isMoveFinished(distanceToMove);
    }

    protected void end(){
        chassis.disablePositionPIDs();
        chassis.endEncoders();
    }

    protected void interrupted(){
        end();
    }
}