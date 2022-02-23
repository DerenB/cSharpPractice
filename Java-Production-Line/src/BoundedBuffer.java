import java.util.LinkedList;

public class BoundedBuffer {

    // VARIABLES
    public static final int NAP_TIME = 5;
    private static final int BUFFER_SIZE = 3;
    public String bufferName;
    private LinkedList<Widget> widgetItems = new LinkedList<>(); // CREATING THE LINKED LIST
    private int numberOfItemsInBuffer; // NUMBER OF ITEMS IN THE BUFFER

    // CONSTRUCTOR
    public BoundedBuffer(String name) {
        numberOfItemsInBuffer = 0;
        bufferName = name;
    }

    // METHOD TO SLEEP THE THREAD FOR A PERIOD
    public static void napping() {
        int sleepTime = (int) (NAP_TIME * Math.random() );
        try {
            Thread.sleep(sleepTime*800); }
        catch(InterruptedException e) { }
    }

    // ANIMATION METHOD FOR ADDING NEW CUBES TO THE SCREEN
    public void enterScreen(AnimationCube cube) {
        switch (numberOfItemsInBuffer) {
            case 0:
                cube.setPosition(404);
                break;
            case 1:
                cube.setPosition(299);
                break;
            case 2:
                cube.setPosition(194);
                break;
        }
    }

    // METHOD TO ENTER ITEMS ONTO THE BUFFER
    public synchronized void enter(Widget item, String worker, String widgetNumber, AnimationCube cube, int unitNumber) {
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
            System.out.println(worker + " entered Widget " + widgetNumber + " onto Belt " + bufferName + ". Buffer FULL.");
        } else {
            System.out.println(worker + " entered Widget " + widgetNumber + " onto Belt " + bufferName + ". Buffer size is " + numberOfItemsInBuffer);
        }

        // NOTIFIES NEXT THREAD
        notify();
    }

    // ANIMATION METHOD FOR MOVING CUBES FROM THE FIRST BELT TO THE SECOND BELT
    public void secondBelt(AnimationCube cube) {
        switch (numberOfItemsInBuffer) {
            case 0:
                cube.setPosition(825);
                break;
            case 1:
                cube.setPosition(720);
                break;
            case 2:
                cube.setPosition(615);
                break;
        }
    }

    // ANIMATION METHOD FOR MOVING CUBES FROM THE SECOND BELT TO THE THIRD BELT
    public void thirdBelt(AnimationCube cube) {
        switch (numberOfItemsInBuffer) {
            case 0:
                cube.setPosition(1246);
                break;
            case 1:
                cube.setPosition(1141);
                break;
            case 2:
                cube.setPosition(1036);
                break;
        }
    }

    // METHOD FOR REMOVING ITEMS FROM THE BUFFER
    public synchronized Widget remove(String worker) {
        Widget item;

        // CHECKS TO SEE IF THE INPUT LIST IS EMPTY
        while(widgetItems.size() == 0) {
            System.out.println(worker + " is waiting.");
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
    public synchronized  void finalList(Widget item, String worker, int widgetNumber) {
        widgetItems.add(item);
        System.out.println(worker + " completed work on Widget " + widgetNumber + ". Widget exiting production line.");
    }


    // METHOD TO PRINT THE FINAL RESULT
    public void print() {
        for(int i = 0; i < widgetItems.size(); i++) {
            int widgetNum = i+1;
            System.out.println("--------------------------------------------");
            System.out.println("Widget # " + widgetNum);
            System.out.println("Widget ID: " + widgetItems.get(i).getModelNumber());
            System.out.println("Number of Workers that Processed: " + widgetItems.get(i).numberOfWorkers);
        }
    }
}
