import java.util.LinkedList;

public class Actual_BoundedBuffer {

    // VARIABLES
    public static final int NAP_TIME = 5;
    private static final int BUFFER_SIZE = 3;
    private LinkedList<Actual_Widget> widgetItems = new LinkedList<>(); // CREATING THE LINKED LIST
    private int numberOfItemsInBuffer; // NUMBER OF ITEMS IN THE BUFFER

    // CONSTRUCTOR
    public Actual_BoundedBuffer() {
        numberOfItemsInBuffer = 0;
    }

    // METHOD TO SLEEP THE THREAD FOR A PERIOD
    public static void napping() {
        int sleepTime = (int) (NAP_TIME * Math.random() );
        try {
            Thread.sleep(sleepTime*100); }
        catch(InterruptedException e) { }
    }

    // METHOD TO ENTER ITEMS ONTO THE BUFFER
    public synchronized void enter(Actual_Widget item, String worker, String widgetNumber) {
        // CHECKS TO SEE IF THE BUFFER IS FULL
        while (widgetItems.size() == 3) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }

        // INCREMENTS BUFFER COUNT
        numberOfItemsInBuffer++;

        // ADDS WIDGET TO BUFFER LIST
        widgetItems.add(item);

        // PROGRESS OUTPUT
        if(numberOfItemsInBuffer == BUFFER_SIZE) {
            System.out.println(worker + " entered Widget " + widgetNumber + ". Buffer FULL.");
        } else {
            System.out.println(worker + " entered Widget " + widgetNumber + ". Buffer size is " + numberOfItemsInBuffer);
        }

        // NOTIFIES NEXT THREAD
        notify();
    }

    // METHOD FOR REMOVING ITEMS FROM THE BUFFER
    public synchronized Actual_Widget remove(String worker) {
        Actual_Widget item;

        // CHECKS TO SEE IF THE INPUT LIST IS EMPTY
        while(widgetItems.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }

        numberOfItemsInBuffer--;
        item = widgetItems.removeFirst();

        notify();

        return item;
    }

    // METHOD FOR ADDING THE COMPLETED ITEMS TO THE FINAL OUTPUT LIST
    public synchronized  void finalList(Actual_Widget item, String worker, int widgetNumber) {
        widgetItems.add(item);
    }
}
