package girlsofsteel.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TESTChassis extends CommandBase {
    
    double speed;
    
    public TESTChassis(){
        requires(chassis);
        SmartDashboard.putBoolean("Right Jags", false);
        SmartDashboard.putBoolean("Left Jags", false);
        SmartDashboard.putDouble("Jag speed", 0.0);
    }
    
    protected void initialize() {
        chassis.initEncoders();
    }

    protected void execute() {
        speed = SmartDashboard.getDouble("Jag speed", 0.0);
        SmartDashboard.putDouble("Right Encoder:", chassis.getRightEncoderDistance());
        SmartDashboard.putDouble("Left Encoder", chassis.getLeftEncoderDistance());
        if(SmartDashboard.getBoolean("Right Jags", false)){
            chassis.setRightJags(speed);
        }
        if(SmartDashboard.getBoolean("Left Jags", false)){
            chassis.setLeftJags(speed);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        chassis.stopJags();
        chassis.endEncoders();
    }

    protected void interrupted() {
        end();
    }
    
}
