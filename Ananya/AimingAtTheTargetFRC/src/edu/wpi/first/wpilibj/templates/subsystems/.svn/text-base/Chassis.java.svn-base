/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;


/**
 *
 * @author tester
 */
public class Chassis extends Subsystem {

Jaguar frontLeft = new Jaguar(2);
Jaguar frontRight = new Jaguar(4);
Jaguar backLeft = new Jaguar(1);
Jaguar backRight = new Jaguar(3);

    protected void initDefaultCommand() {
   
    }
    public void tankDrive(double left, double right){

      frontLeft.set(-left);
      backLeft.set(-left);
      frontRight.set(right);
      backRight.set(right);

    }
}
