import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Global Variables
    public static int globalAverage;
    public static int globalMinVal;
    public static int globalMaxVal;
    public static double globalMedian;
    public static double globalSTD;

    public static ArrayList<Integer> globalInputValues = new ArrayList();

    public static void main(String[] args) {
        // Variables
        Scanner keyb = new Scanner(System.in);

        // Read in the values
        System.out.println("Enter the values on a single line, each item separated by a space.");
        System.out.println("Enter your list of numbers: ");
        String input = keyb.nextLine();
        keyb.close();

        // Split string input into string array
        String[] numbers = input.split(" ");

        // Convert string input array to integer and add to arraylist
        for(String item : numbers) {
            globalInputValues.add(Integer.parseInt(item));
        }

        // Create the threads
        WorkerAverage avg = new WorkerAverage("Average");
        WorkerMinimum min = new WorkerMinimum("Minimum");
        WorkerMaximum max = new WorkerMaximum("Maximum");
        WorkerMedian med = new WorkerMedian("Median");
        WorkerSTD std = new WorkerSTD("StandardDeviation");

        // Start the threads
        avg.start();
        min.start();
        max.start();
        med.start();

        // Join the threads
        try {
            avg.join();
            min.join();
            max.join();
            med.join();
        } catch(Exception ex) {
            System.out.println("Exception has been caught: " + ex);
        }

        // Start the Standard Deviation thread
        std.start();

        // Join the Standard Deviation thread
        try {
            std.join();
        } catch(Exception ex) {
            System.out.println("Exception has been caught: " + ex);
        }

        // Output
        System.out.println();
        System.out.println("Final results:");
        System.out.println("The average value is " + globalAverage);
        System.out.println("The minimum value is " + globalMinVal);
        System.out.println("The maximum value is " + globalMaxVal);
        System.out.println("The median value is " + globalMedian);
        System.out.println("The Standard Deviation is " + globalSTD);
        System.out.println("End of program.");
    }
}
