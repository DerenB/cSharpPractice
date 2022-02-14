/*
 * Worker Class
 * Finds the Minimum value of the input list in Stats
 */

public class WorkerMinimum extends Thread {

    public WorkerMinimum(String name) {
        super(name);
    }

    public void run() {
        // Local variables
        int min = Stats.globalInputValues.get(0);
        int count = Stats.globalInputValues.size();

        // Loops through the input list for the lowest value
        for(int i = 1; i < count; i++) {
            if(Stats.globalInputValues.get(i) < min) {
                min = Stats.globalInputValues.get(i);
            }
        }

        // Assigns the value to the global variable
        Stats.globalMinVal = min;
    }
}
