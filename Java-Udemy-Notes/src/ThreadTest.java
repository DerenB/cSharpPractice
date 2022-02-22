public class ThreadTest extends Thread {

    // Names the Thread
    public ThreadTest(String name) {
        super(name);
    }

    // Runs the Thread
    @Override
    public void run() {
        System.out.println("My thread " + Thread.currentThread().getName() + " is starting.");
        System.out.println("Poo");
        System.out.println("Poo");
        System.out.println("Poo");
        System.out.println("Poo");
        System.out.println("Poo");
        System.out.println("Poo");
    }
}
