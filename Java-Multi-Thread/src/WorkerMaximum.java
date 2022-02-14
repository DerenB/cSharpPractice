public class WorkerMaximum extends Thread {

    public WorkerMaximum(String name) {
        super(name);
    }

    public void run() {
        System.out.println("1: Maximum Worker ran");
        int max = Main.globalInputValues.get(0);
        int count = Main.globalInputValues.size();

        System.out.println("2: Maximum worker ran");
        for(int i = 1; i < count; i++) {
            if(Main.globalInputValues.get(i) > max) {
                max = Main.globalInputValues.get(i);
            }
        }

        System.out.println("3: Maximum worker ran");
        Main.globalMaxVal = max;
    }
}
