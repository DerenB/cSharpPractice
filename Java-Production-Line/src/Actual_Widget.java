import java.util.Random;

public class Actual_Widget {
    // VARIABLES
    public int modelNumber, red, green, blue, numberOfWorkers;

    // CONSTRUCTOR
    public Actual_Widget(int productionCount) {
        modelNumber = productionCount;
        red = RandomValue();
        green = RandomValue();
        blue = RandomValue();
        numberOfWorkers = 1;
    }

    // GENERATES A RANDOM VALUE FROM 0-255
    public static int RandomValue() {
        Random random = new Random();
        return random.nextInt(256);
    }

    public int workUpon() {
        numberOfWorkers++;
        return numberOfWorkers;
    }

    public String getModelNumber() {
        return redToString() + "." + greenToString() + "." + blueToString();
    }

    public String redToString() {
        return String.valueOf(red);
    }

    public String greenToString() {
        return String.valueOf(green);
    }

    public String blueToString() {
        return String.valueOf(blue);
    }
}
