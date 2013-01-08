package girlsofsteel.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivePositionChassisTuning extends CommandBase{

    public DrivePositionChassisTuning(){
        requires(chassis);
        SmartDashboard.putDouble("DPST,P", 0.0);
        SmartDashboard.putDouble("DPST,D", 0.0);
        SmartDashboard.putDouble("DPST,setpoint", 0.0);
        SmartDashboard.putDouble("Right Encoder Position", 0.0);
        SmartDashboard.putDouble("Left Encoder Position", 0.0);
    }
    
    protected void initialize() {
        chassis.initEncoders();
        chassis.initPositionPIDs();
    }

    protected void execute() {
        chassis.setPositionPIDValues(SmartDashboard.getDouble("DPST,P", 0.0), 0.0, SmartDashboard.getDouble("DPST,D", 0.0));
//        chassis.setPIDsPosition();
        chassis.setPositionPIDSetPoint(SmartDashboard.getDouble("DPST,setpoint", 0.0));
        SmartDashboard.putDouble("Right Encoder Position", chassis.getRightEncoderDistance());
        SmartDashboard.putDouble("Left Encoder Position", chassis.getLeftEncoderDistance());
    }

    protected bo  jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden olean isFinished() {
        return false;
    }

    protected void end() {
        chassis.disablePositionPIDs();
        chassis.endEncoders();
    }

    protected void interrupted() {
        end();
    }
    
}
