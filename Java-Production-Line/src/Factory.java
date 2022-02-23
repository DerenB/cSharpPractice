/*
 * DEREN BOZER
 * COSC-525 MW 1:00PM
 * WINTER 2022
 * PROGRAMMING ASSIGNMENT: PRODUCTION LINE
 */

public class Factory {
    public static AnimationCube[] cubeArray = new AnimationCube[26];

    public static void main(String[] args) {

        // CREATES THE ANIMATION WINDOW
        new AnimationFrame();

        // CREATE THE THREE BUFFER CONVEYOR BELTS
        BoundedBuffer bufferAtoB = new BoundedBuffer("Belt A-B");
        BoundedBuffer bufferBtoC = new BoundedBuffer("Belt B-C");
        BoundedBuffer bufferCtoD = new BoundedBuffer("Belt C-D");
        BoundedBuffer bufferDtoFinal = new BoundedBuffer("Exit Belt");

        // CREATE THE WORKERS
        Worker workerA = new Worker("Worker A", true, bufferAtoB);
        Worker workerB = new Worker("Worker B", false, bufferAtoB, bufferBtoC);
        Worker workerC = new Worker("Worker C", false, bufferBtoC, bufferCtoD);
        Worker workerD = new Worker("Worker D", false, bufferCtoD, bufferDtoFinal, true);

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

        // FINAL OUTPUT
        System.out.println("--------------------------------------------");
        System.out.println("Widget Processing complete. Final results:");
        System.out.println();
        bufferDtoFinal.print();
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("Program closing.");
    }
}
