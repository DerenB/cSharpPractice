/*
 * Worker Class
 * Calculates the Average of the input list in Stats
 */

public class WorkerAverage extends Thread {

    public WorkerAverage(String name) {
        super(name);
    }

    public void run() {
        // Local variable
        int averageResult;
        int total = 0;

        // Gets the size of the input list
        int count = Stats.globalInputValues.size();

        // Adds up the values in the input list
        for(int num : Stats.globalInputValues) {
            total += num;
        }

        // Gets the average
        averageResult = total / count;

        // Assigns the value to the global variable
        Stats.globalAverage = averageResult;
    }
}
