/*
 * Worker Class
 * Finds the Maximum value of the input list in Stats
 */

public class WorkerMaximum extends Thread {

    public WorkerMaximum(String name) {
        super(name);
    }

    public void run() {
        // Local variables
        int max = Stats.globalInputValues.get(0);
        int count = Stats.globalInputValues.size();

        // Loops through the input list for the highest value
        for(int i = 1; i < count; i++) {
            if(Stats.globalInputValues.get(i) > max) {
                max = Stats.globalInputValues.get(i);
            }
        }

        // Assigns the value to the global variable
        Stats.globalMaxVal = max;
    }
}
