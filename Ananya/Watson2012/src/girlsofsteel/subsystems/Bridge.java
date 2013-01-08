package girlsofsteel.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import girlsofsteel.RobotMap;

public class Bridge extends Subsystem {
    //Change the parameter to the correct number.
    //public Jaguar bridgeArmJag = new Jaguar(RobotMap.BRIDGE_ARM_JAG);
    public Relay bridgeArmSpike = new Relay(RobotMap.BRIDGE_ARM_SPIKE);
    public DigitalInput upLimitSwitch = new DigitalInput(RobotMap.BRIDGE_UP_LIMIT_SWITCH);
    public DigitalInput downLimitSwitch = new DigitalInput(RobotMap.BRIDGE_DOWN_LIMIT_SWITCH);
    public boolean goingUp;
            
    public boolean isFullyUp() {//False is True, True is False.
        return upLimitSwitch.get();
    }

    public boolean hasHitBridge() {
        return downLimitSwitch.get();
    }

    public void downBridgeArm(){
        bridgeArmSpike.set(Relay.Value.kForward);
        goingUp = false;
    }
    
    public void upBridgeArm(){
        bridgeArmSpike.set(Relay.Value.kReverse);
        goingUp = true;
    }
    
    public void stopBridgeArm(){
        bridgeArmSpike.set(Relay.Value.kOff);
    }
    
    public Bridge(){
        new Thread() {
            public void run() {
                while (true) {
                    safetyCheck();
                    Timer.delay(.01);
                }
            }
        }.start();
    }
    
    //the safety check is important -> stops the bridge arm when it is running
    //constantly into the limit switches
    private void safetyCheck() {
        if(isFullyUp() && goingUp)
        {
            bridgeArmSpike.set(Relay.Value.kOff);
        }
        if(hasHitBridge() && !goingUp)
        {
            bridgeArmSpike.set(Relay.Value.kOff);
        }
    }
    
    protected void initDefaultCommand() {
    }
}