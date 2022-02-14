public class WorkerMinimum extends Thread {

    public WorkerMinimum(String name) {
        super(name);
    }

    public void run() {
        // Local variables
        int min = Main.globalInputValues.get(0);
        int count = Main.globalInputValues.size();

        // Loops through the input list for the lowest value
        for(int i = 1; i < count; i++) {
            if(Main.globalInputValues.get(i) < min) {
                min = Main.globalInputValues.get(i);
            }
        }

        // Assigns the value to the global variable
        Main.globalMinVal = min;
    }
}
