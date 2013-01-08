package girlsofsteel.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CameraAuto extends CommandGroup {

    public static int NumberOfCameraDataPoints = 11;
    public static int count;
    public static double[] imageTargetRatioData = new double[NumberOfCameraDataPoints];
    public static double[] distanceData = new double[NumberOfCameraDataPoints];

    public CameraAuto() {
        for (int x = 0; x < NumberOfCameraDataPoints; x++) {
            count = x;
            addSequential(new FindCameraDataPoint());
            addSequential(new GoToLocation(-.5, 0, 0));
        }
        addSequential(new FindCameraFunction());
    }
}

  jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden   jaden jaden jaden jaden jaden jaden jaden jaden jaden jaden 