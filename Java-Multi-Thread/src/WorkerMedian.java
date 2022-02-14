import java.util.ArrayList;
import java.util.Collections;

public class WorkerMedian extends Thread {

    public WorkerMedian(String name) {
        super(name);
    }

    public void run() {
        // Copy the global list into a local list
        ArrayList<Integer> inputCopy = new ArrayList<>(Main.globalInputValues);

        // Local Variables
        int count = inputCopy.size();
        double median;
        int low = count / 2;
        int high = (count / 2) + 1;

        // Sorts the list, lowest to highest
        Collections.sort(inputCopy);

        // Finds the median based on if the input list has an even or odd length
        if(count % 2 == 0) {
            median = (inputCopy.get(low) + inputCopy.get(high)) / 2.0;
        } else {
            median = inputCopy.get(low);
        }

        // Assigns the value to the global variable
        Main.globalMedian = median;
    }
}
