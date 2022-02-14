public class WorkerMaximum extends Thread {

    public WorkerMaximum(String name) {
        super(name);
    }

    public void run() {
        // Local variables
        int max = Main.globalInputValues.get(0);
        int count = Main.globalInputValues.size();

        // Loops through the input list for the highest value
        for(int i = 1; i < count; i++) {
            if(Main.globalInputValues.get(i) > max) {
                max = Main.globalInputValues.get(i);
            }
        }

        // Assigns the value to the global variable
        Main.globalMaxVal = max;
    }
}
