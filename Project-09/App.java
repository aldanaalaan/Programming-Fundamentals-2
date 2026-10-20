import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CampusRobot robot = null;
        int robotType;
        String robotId;
        double batteryPercent, distanceMiles;

        System.out.println("*********************************************");
        System.out.println("Campus Delivery Robot Simulator (Week 1)");
        System.out.println("*********************************************");

        System.out.print("Select robot type - [1]Food, [2]Library: ");
        robotType = in.nextInt();
        in.nextLine(); // Consume \n

        System.out.print("Enter robot ID: ");
        robotId = in.nextLine();

        System.out.print("Enter battery percent: ");
        batteryPercent = in.nextDouble();

        System.out.print("Enter delivery distance (miles): ");
        distanceMiles = in.nextDouble();

        if (robotType == 1) {
            robot = new FoodRobot(robotId, batteryPercent);
        } else if (robotType == 2) {
            robot = new LibraryRobot(robotId, batteryPercent);
        }

        if (robot != null) {
            System.out.println("\n" + robot.getSummary());

            // Consume battery
            double prevBattery = robot.getBatteryPercent();
            robot.drainBattery(distanceMiles * 5);

            System.out.println("Estimated delivery time: " + robot.estimateMinutes(distanceMiles) + " minutes");
            System.out.println("Battery used: " + (prevBattery - robot.getBatteryPercent()) + "%");
            System.out.println(robot.getSummary());
        } else
            System.out.println("Robot type [" + robotType + "] not valid");
        System.out.println("*********************************************");

    }

}

abstract class CampusRobot {
    private String robotId;
    // (0-100)
    private double batteryPercent;

    public CampusRobot(String robotId, double batteryPercent) {
        this.robotId = robotId;
        if (batteryPercent > 100)
            this.batteryPercent = 100;
        else if (batteryPercent >= 0)
            this.batteryPercent = batteryPercent;
    }

    public String getRobotId() {
        return robotId;
    }

    public double getBatteryPercent() {
        return batteryPercent;
    }

    // Not under 0%
    public void drainBattery(double amount) {
        if (amount < 0)
            return;
        if (batteryPercent != 0 && amount < batteryPercent) {
            batteryPercent -= amount;
        } else {
            batteryPercent = 0;
        }
    }

    public String getSummary() {
        return getType() + " | ID: " + robotId + " | Battery: " + batteryPercent + "%";
    }

    public abstract String getType();

    public abstract double estimateMinutes(double distanceMiles);
}

class FoodRobot extends CampusRobot {
    private static final double MINUTES_PER_MILE = 12;

    public FoodRobot(String robotId, double batteryPercent) {
        super(robotId, batteryPercent);
    }

    @Override
    public String getType() {
        return "FoodRobot";
    }

    @Override
    public double estimateMinutes(double distanceMiles) {
        return distanceMiles * MINUTES_PER_MILE;
    }
}

class LibraryRobot extends CampusRobot {
    private static final double MINUTES_PER_MILE = 8;

    public LibraryRobot(String robotId, double batteryPercent) {
        super(robotId, batteryPercent);
    }

    @Override
    public String getType() {
        return "LibraryRobot";
    }

    @Override
    public double estimateMinutes(double distanceMiles) {
        return distanceMiles * MINUTES_PER_MILE;
    }

}
