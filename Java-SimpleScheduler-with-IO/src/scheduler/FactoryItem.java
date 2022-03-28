package scheduler;

public class FactoryItem implements JobWorkable {
    public int job;

    public FactoryItem(int inValue) {
        job = inValue;
    }

    @Override
    public void doWork() {
        String jobThread = Thread.currentThread().getName();

        String status = "Job " + job + " did some work on thread " + jobThread + ".";
        System.out.println(status);

        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
