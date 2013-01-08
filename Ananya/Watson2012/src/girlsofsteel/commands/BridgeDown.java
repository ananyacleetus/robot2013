package girlsofsteel.commands;

public class BridgeDown extends CommandBase {

    public BridgeDown() {
        requires(bridge);
    }

    protected void initialize() {
    }

    protected void execute() {
        bridge.downBridgeArm();
    }

    protected boolean isFinished() {
        return bridge.hasHitBridge();
    }

    protected void end() {
        bridge.stopBridgeArm();
    }

    protected void interrupted() {
        end();
    }
}
