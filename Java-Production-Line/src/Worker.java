/*
 * DEREN BOZER
 * COSC-525 MW 1:00PM
 * WINTER 2022
 * PROGRAMMING ASSIGNMENT: PRODUCTION LINE
 */

public class Worker extends Thread {
    // VARIABLES
    final private boolean producer; // BOOLEAN TO LABEL WORKER AS FIRST PRODUCER
    private boolean finalWorker = false; // BOOLEAN TO LABEL WORKER AS FINAL PRODUCER
    final private int numberOfUnits = 24; // NUMBER OF WIDGETS TO CREATE
    private int unitNumber = 1; // CURRENT WIDGET BEING PRODUCED

    // BUFFER OBJECT
    private BoundedBuffer bufferIn;
    final private BoundedBuffer bufferOut;

    // WIDGET OBJECT
    private Widget newWidget;
    private String widgetModelNumber;

    // DEFAULT CONSTRUCTOR FOR PRODUCER-ONLY
    public Worker(String name, boolean newProducer, BoundedBuffer b) {
        super(name);
        producer = newProducer;
        bufferOut = b;
    }

    // DEFAULT CONSTRUCTOR FOR PRODUCER-CONSUMER
    public Worker(String name, boolean newProducer, BoundedBuffer in, BoundedBuffer out) {
        super(name);
        producer = newProducer;
        bufferIn = in;
        bufferOut = out;
    }

    // DEFAULT CONSTRUCTOR FOR CONSUMER-ONLY
    public Worker(String name, boolean newProducer, BoundedBuffer in, BoundedBuffer out, boolean end) {
        super(name);
        producer = newProducer;
        bufferIn = in;
        bufferOut = out;
        finalWorker = end;
    }

    public void run() {
        // RUNS UNTIL 24 UNITS ARE PROCESSES
        while(unitNumber <= numberOfUnits) {
            // SLEEPS THE THREAD FOR A PERIOD
            BoundedBuffer.napping();

            // CHECKS IF IT'S THE FIRST WORKER
            if(producer) {
                // CREATES THE NEW WIDGET
                produceNewWidget();

                // ENTERS THE CUBE INTO THE ANIMATION
                bufferOut.enterScreen(Factory.cubeArray[unitNumber]);

                // ENTER OBJECT INTO OUTBOUND BELT
                bufferOut.enter(newWidget, getName(), widgetModelNumber, Factory.cubeArray[unitNumber], unitNumber);
            } else {
                // REMOVES THE FIRST WIDGET FROM THE PRIOR BUFFER
                newWidget = bufferIn.remove(getName());

                // WIDGET RETRIEVAL MESSAGE
                System.out.println(getName() + " is retrieving " + newWidget.getModelNumber() + " from Belt "+ bufferIn.bufferName + ". Item Number: " + unitNumber);

                // ADDS THE WIDGET TO THE OUTPUT BUFFER
                newWidget.workUpon();
                produce();

                // CHECKS IF IT'S THE LAST WORKER
                if(finalWorker) {
                    // REMOVES THE CUBE FROM THE ANIMATION
                    Factory.cubeArray[unitNumber].exitScreen();

                    // REMOVES THE WIDGET FROM THE LAST BELT AND ADDS IT TO THE FINAL OUTPUT
                    bufferOut.finalList(newWidget,getName(),newWidget.modelNumber);
                } else {
                    // CHECKS IF IT'S GOING TO THE SECOND OR THIRD BELT FOR THE ANIMATION
                    if(newWidget.numberOfWorkers == 2) {
                        bufferOut.secondBelt(Factory.cubeArray[unitNumber]);
                    } else if (newWidget.numberOfWorkers == 3) {
                        bufferOut.thirdBelt(Factory.cubeArray[unitNumber]);
                    }
                    // ADDS THE WIDGET TO THE NEXT BELT
                    bufferOut.enter(newWidget,getName(), newWidget.getModelNumber(), Factory.cubeArray[unitNumber], unitNumber);
                }
            }
            // INCREMENT THE UNIT NUMBER
            unitNumber++;
        }
    }

    // METHOD FOR THE INITIAL CREATION OF THE WIDGET
    public void produceNewWidget() {
        newWidget = new Widget(unitNumber);
        widgetModelNumber = newWidget.getModelNumber();
        System.out.println(getName() + " is working on Widget #" + unitNumber + ". New Widget ID: "+ newWidget.getModelNumber());
    }

    // METHOD FOR PROCESSING THE WIDGET BY LATER WORKERS
    public void produce() {
        System.out.println(getName() + " is working on Widget " + newWidget.getModelNumber());
    }
}
