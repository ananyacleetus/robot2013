package girlsofsteel.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import girlsofsteel.RobotMap;


public class Collector extends Subsystem{
    
    DigitalInput collectorLimitSwitch = new DigitalInput(RobotMap.COLLECTOR_LIMIT_SWITCH);
  
    Relay brushSpike = new Relay(RobotMap.BRUSH_SPIKE);
    Relay middleConveyor = new Relay(RobotMap.MIDDLE_COLLECTOR_SPIKE);
    
    public Collector () {
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 1,
                "New ball?" + getLimitSwitch());
        DriverStationLCD.getInstance().updateLCD();
    }
    
    // true == pressed (of getRealSwitch)
    private boolean getLimitSwitch () {
        return !collectorLimitSwitch.get();
    }

    protected void initDefaultCommand() {
    }
    
    public void reverseBrush(){
        brushSpike.set(Relay.Value.kForward);
    }
    
    public void forwardBrush(){
        brushSpike.set(Relay.Value.kReverse);
    }
    
    public void stopBrush(){
        brushSpike.set(Relay.Value.kOff);
    }
    
    public void forwardMiddleConveyor(){
        middleConveyor.set(Relay.Value.kReverse);
    }
    
    public void reverseMiddleConveyor(){
        middleConveyor.set(Relay.Value.kForward);
    }
    
    public void stopMiddleConveyor(){
        middleConveyor.set(Relay.Value.kOff);
    }
}