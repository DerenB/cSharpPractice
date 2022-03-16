package scheduler;

public class Factory implements JobWorkable {
    public int job;

    public Factory(int inValue) {
        job = inValue;
        //System.out.println("Factory class did value: " + job);
    }

    @Override
    public void doWork() {
        String jobThread = Thread.currentThread().getName();


        String status = "Job " + job + " did blah on thread " + jobThread + ".";
        System.out.println(status);

        try {
            Thread.currentThread().sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
