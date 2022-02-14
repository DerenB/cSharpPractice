public class WorkerAverage extends Thread{

    public static int averageResult;

    public WorkerAverage(String name) {
        super(name);
    }

    public void run() {
        System.out.println("1: Average Worker ran");
        int count = Main.globalInputValues.size();
        System.out.println("2: Worker count: " + count);

        int total = 0;
        for(int num : Main.globalInputValues) {
            total += num;
        }
        System.out.println("3: Worker total: " + total);

        averageResult = total / count;
        Main.globalAverage = averageResult;
        System.out.println("4: Worker average: " + averageResult);
        System.out.println("5: Worker global average: " + Main.globalAverage);
    }
}
