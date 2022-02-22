public class Actual_Factory {
    public static void main(String[] args) {

        // CREATE THE THREE BUFFER CONVEYOR BELTS
        Actual_BoundedBuffer bufferAtoB = new Actual_BoundedBuffer();
        Actual_BoundedBuffer bufferBtoC = new Actual_BoundedBuffer();
        Actual_BoundedBuffer bufferCtoD = new Actual_BoundedBuffer();
        Actual_BoundedBuffer bufferDtoFinal = new Actual_BoundedBuffer();

        // CREATE THE WORKERS
        Actual_Worker workerA = new Actual_Worker("Worker A", true, bufferAtoB);
        Actual_Worker workerB = new Actual_Worker("Worker B", false, bufferAtoB, bufferBtoC);
        Actual_Worker workerC = new Actual_Worker("Worker C", false, bufferBtoC, bufferCtoD);
        Actual_Worker workerD = new Actual_Worker("Worker D", false, bufferCtoD, bufferDtoFinal, true);

        // START THE WORKER THREADS
        workerA.start();
        workerB.start();
        workerC.start();
        workerD.start();

        // JOINS THE THREADS WHEN THEY ARE FINISHED
        try {
            workerA.join();
            workerB.join();
            workerC.join();
            workerD.join();
        } catch (Exception e) { }


    }
}
