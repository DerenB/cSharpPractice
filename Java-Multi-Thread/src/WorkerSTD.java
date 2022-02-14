import java.util.ArrayList;

public class WorkerSTD extends Thread {

    public WorkerSTD(String name) {
        super(name);
    }

    public void run() {
        // Copy the global list into a local list
        ArrayList<Integer> inputCopy = new ArrayList<>(Main.globalInputValues);

        // Local Variables
        int count = inputCopy.size();
        double total = 0.0;
        double average;
        double sumOfSquares = 0.0;

        // Calculates the total of the input list
        for(Integer num : inputCopy) {
            total += num;
        }

        // Calculates the average of the input list
        average = total / count;

        // Subtracts the average and squares each value in the input list
        for(Integer num : inputCopy) {
            double temp = (num - average) * (num - average);
            sumOfSquares += temp;
        }

        // Calculates the square root of the sum of squares
        double standardDeviation = Math.sqrt((sumOfSquares / (count - 1)));

        // Assigns the value to the global variable
        Main.globalSTD = Math.round(standardDeviation*100.0)/100.0;
    }
}
