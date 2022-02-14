public class WorkerMinimum extends Thread {

    public WorkerMinimum(String name) {
        super(name);
    }

    public void run() {
        System.out.println("1: Minimum Worker ran");
        int min = Main.globalInputValues.get(0);
        int count = Main.globalInputValues.size();

        System.out.println("2: Minimum worker ran");
        for(int i = 1; i < count; i++) {
            if(Main.globalInputValues.get(i) < min) {
                min = Main.globalInputValues.get(i);
            }
        }

        System.out.println("3: Minimum worker ran");
        Main.globalMinVal = min;
    }
}
