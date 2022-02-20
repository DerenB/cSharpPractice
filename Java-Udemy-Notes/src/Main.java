public class Main {
    public static void main(String[] args) {

        // CREATE THE THREAD
        ThreadTest newThread = new ThreadTest("MyThreadName");

        // DISPLAYS THE THREAD THAT IS CURRENTLY RUNNING
        System.out.println("We are in thread: " + Thread.currentThread().getName());

        // STARTS THE THREAD
        newThread.start();

        System.out.println("We are in thread: " + Thread.currentThread().getName());
        System.out.println("We are in thread: " + Thread.currentThread().getName());
        System.out.println("We are in thread: " + Thread.currentThread().getName());
        System.out.println("We are in thread: " + Thread.currentThread().getName());

        // Changes the name of a thread from Main
        newThread.setName("ChangeMyName");

    }
}
