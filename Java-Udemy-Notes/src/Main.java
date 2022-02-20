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

        // CHANGES THE NAME OF A THREAD FROM MAIN
        newThread.setName("ChangeMyName");

        // PAUSES THE THREAD FOR A PERIOD
        // newThread.sleep(1000);

        // SETS THE PRIORITY OF THE THREAD
        // RANGE OF 1-10, MAX 10
        newThread.setPriority(Thread.MAX_PRIORITY);

        // RETURNS THE PRIORITY OF THE THREAD
        System.out.println("Priority Thread: " + newThread.getPriority());

    }
}
