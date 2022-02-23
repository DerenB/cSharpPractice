/*
 * DEREN BOZER
 * COSC-525 MW 1:00PM
 * WINTER 2022
 * PROGRAMMING ASSIGNMENT: PRODUCTION LINE
 */

import java.util.Random;

public class Widget {
    // VARIABLES
    public int modelNumber, red, green, blue, numberOfWorkers, beltPosition;

    // CONSTRUCTOR
    public Widget(int productionCount) {
        modelNumber = productionCount;
        red = RandomValue();
        green = RandomValue();
        blue = RandomValue();
        numberOfWorkers = 1;
        beltPosition = 0;
    }

    // GENERATES A RANDOM VALUE FROM 0-255
    public static int RandomValue() {
        Random random = new Random();
        return random.nextInt(256);
    }

    public void workUpon() {
        numberOfWorkers++;
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
