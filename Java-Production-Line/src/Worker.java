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

                // ENTER OBJECT INTO OUTBOUND BELT
                bufferOut.enterScreen(Factory.cubeArray[unitNumber]);
                bufferOut.enter(newWidget, getName(), widgetModelNumber, Factory.cubeArray[unitNumber], unitNumber);
            } else {
                // REMOVES THE FIRST WIDGET FROM THE PRIOR BUFFER
                //bufferIn.nextBelt(Factory.cubeArray[unitNumber]);
                newWidget = bufferIn.remove(getName());

                System.out.println(getName() + " removed " + newWidget.getModelNumber() + ". Item Number: " + unitNumber);

                // ADDS THE WIDGET TO THE OUTPUT BUFFER
                newWidget.workUpon();
                produce();

                // CHECKS IF IT'S THE LAST WORKER
                if(finalWorker) {
                    Factory.cubeArray[unitNumber].exitScreen();
                    bufferOut.finalList(newWidget,getName(),newWidget.modelNumber);
                } else {
                    if(newWidget.numberOfWorkers == 2) {
                        bufferOut.secondBelt(Factory.cubeArray[unitNumber]);
                    } else if (newWidget.numberOfWorkers == 3) {
                        bufferOut.thirdBelt(Factory.cubeArray[unitNumber]);
                    }
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
        System.out.println(getName() + " Produced Widget #" + unitNumber + ". New Widget ID: "+ newWidget.getModelNumber());

    }

    // METHOD FOR PROCESSING THE WIDGET BY LATER WORKERS
    public void produce() {
        System.out.println(getName() + " Processed Widget " + newWidget.getModelNumber());

    }
}
