public class Test_Factory {
    public static void main(String args[]) {
        Test_BoundedBuffer server = new Test_BoundedBuffer();

        // now create the producer and consumer threads
        Test_Producer producerThread = new Test_Producer(server);
        Test_Consumer consumerThread = new Test_Consumer(server);

        producerThread.start();
        consumerThread.start();
    }
}
