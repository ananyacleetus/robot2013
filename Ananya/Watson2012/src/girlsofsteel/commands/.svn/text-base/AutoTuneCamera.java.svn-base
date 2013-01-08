package girlsofsteel.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import girlsofsteel.objects.Camera;

public class AutoTuneCamera extends CommandBase {

    public static final double HalfCourt = 7.1; //meters (7.1)
    public static final double Step = .5; //meters
    public static final double ErrorThreshold = .01;
    
    public AutoTuneCamera() {
        requires(chassis);
    }

    //Returns average of a set of 10 data points from the camera if it's stable.
    private double getStableRatio() {
        int n = 10;
        double sumOfData = 0;
        double[] values = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = Camera.getImageTargetRatio();
            //System.out.println(values[i]);
            sumOfData += values[i];

            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
        }
        double dataAverage = (sumOfData / n);
        double errorSum = 0;
        for (int i = 0; i < n; i++) {
            errorSum += (values[i] - dataAverage) * (values[i] - dataAverage);
        }
        double averageError = Math.sqrt(errorSum) / n;
        if (averageError < ErrorThreshold) {
           // System.out.println(dataAverage);
            return dataAverage;
        }
        return -1;//-1 means that it can't use the data.
    }

    protected void initialize() {
        chassis.initEncoders();
        int nSteps = 10; //(int) (HalfCourt / Step);
        double[] imageTargetRatioData = new double[nSteps];
        double[] distanceData = new double[nSteps];
        int count = 0;
        while (count<10) {
                try {
                    Thread.sleep(2000);//2 seconds time out. 
                } catch (Exception ex) {
                }
            if (!chassis.isMoving()) {
                /*
                if ((chassis.getRightEncoderDistance()) > HalfCourt - 2) {           
                    break;
                }
                 */
                double ratio = 0;
                //Try 5 times for an aceptable average.
                for (int i = 0; i < 5; i++) {
                    ratio = this.getStableRatio();
                    //System.out.println("ratio=" + ratio);
                    if (ratio >= 0) {
                        break;
                    }
                }
                //Start against the bridge. distance to target is he initial distance minus the distance travled.
                //chassis.move(Step);
                
                if (ratio < 0) {
                    System.out.println("Drop bad data point. If you see me too often, re-tune RGB.");
                    continue;
                }
                
                double distCamera = Camera.getXDistance() - (38*0.0254) -
                        (11.5*0.0254) /*-(15.0*0.0254)*/; // meters -> from the center of the turret
                        //when it is facing the opposite side of the rollers
                        //11.5 -> no bumpers, 15 with bumpers
                imageTargetRatioData[count] = ratio;
                distanceData[count] = (chassis.getRightEncoderDistance()+((38+11.5)*0.0254));
                //returns the distance from the middle of the turret to the backboard
                SmartDashboard.putDouble("Chassis Encoder", chassis.getRightEncoderDistance());
                System.out.println(distanceData[count] + ", " + ratio 
                        + " CD=" + distCamera + "Err=" + (distCamera - distanceData[count]));
                count++;
            }
        }
        System.out.println("data collection done! cnt=" + count);
        double[] ab = LinearRegressionAuto.bestFit(imageTargetRatioData, distanceData, count);
        double a = ab[0];
        double b = ab[1];

        if (!Double.isNaN(a)) {
            
            NetworkTable table = NetworkTable.getTable("camera");
            table.putDouble("Slope", a);
            table.putDouble("yInt", b);
            // print results
            System.out.println("y   = " + a + " * x + " + b);
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

class LinearRegressionAuto {

    public static double[] bestFit(double[] x, double[] y, int size) {
        int n = 0;

        // first pass: read in data, compute xbar and ybar
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (; n < size; ++n) {
            sumx += x[n];
            sumx2 += x[n] * x[n];
            sumy += y[n];
            n++;
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;

        // print results
       // System.out.println("y   = " + beta1 + " * x + " + beta0);


        double[] aAndB = new double[2];
        aAndB[0] = beta1; // a in: aX + b
        aAndB[1] = beta0; // b in: aX + b
        return aAndB;
    }
}