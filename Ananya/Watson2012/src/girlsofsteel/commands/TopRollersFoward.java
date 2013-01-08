/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package girlsofsteel.commands;

/**
 *
 * @author tester
 */
public class TopRollersFoward extends CommandBase {

    double time;
    protected void initialize() {
     time=System.currentTimeMillis();   
    }

    protected void execute() {
        shooter.topRollersForward();
    }

    protected boolean isFinished() {
        if (System.currentTimeMillis()-time>2000){
        return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
