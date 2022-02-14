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
        int median;
        int low = count / 2;
        int high = (count / 2) + 1;

        // Sorts the list
        Collections.sort(inputCopy);

        if(count % 2 == 0) {
            median = (inputCopy.get(low) + inputCopy.get(high)) / 2;
        } else {
            median = inputCopy.get(low);
        }
        Main.globalMedian = median;
    }
}
