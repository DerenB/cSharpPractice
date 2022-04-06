/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT 4: VIRTUAL MEMORY
 */

import java.util.ArrayList;

public class Pager {
    // Count of sequences
    public int sequenceCount;

    // Count the number of faults
    public static int faultFIFO;
    public static int faultLRU;
    public static int faultLFU;
    public static int faultOPT;

    public Pager(ArrayList<Integer> input, int numberOfSequences) {
        // Initialize
        sequenceCount = numberOfSequences;

        // Splits the into individual lists
        ArrayList<ArrayList<Integer>> sortedList = new ArrayList<ArrayList<Integer>>(numberOfSequences);
        for(int i = 0; i < sequenceCount; i++) {
            int k = 0;
            ArrayList<Integer> tempList = new ArrayList<>();
            while(input.get(0) != -1) {
                tempList.add(input.get(0));
                input.remove(0);
            }
            input.remove(0);
            sortedList.add(tempList);
        }

        // Loop to go through every List in every type
        for(ArrayList<Integer> list : sortedList) {
            // Sets the faults to 0
            faultFIFO = 0;
            faultLRU = 0;
            faultLFU = 0;
            faultOPT = 0;

            // Sends the list to each page replacement class
            PageFIFO setFIFO = new PageFIFO(list, list.get(0));
            PageLRU setLRU = new PageLRU(list, list.get(0));
            PageLFU setLFU = new PageLFU(list,list.get(0));
            PageOPT setOPT = new PageOPT(list,list.get(0));
            System.out.println();

            // Outputs the results
            System.out.println("Using " + list.get(0) + " frames, the reference string yielded:");
            System.out.printf("%5s\t%5s\t%5s\n","Scheme","#Faults","%Optimal");
            System.out.printf("%s\t%d\t\t%.1f%s\n","FIFO",faultFIFO, Percentage(faultFIFO),"%");
            System.out.printf("%s\t\t%d\t\t%.1f%s\n","LRU",faultLRU, Percentage(faultLRU),"%");
            System.out.printf("%s\t\t%d\t\t%.1f%s\n","LFU",faultLFU, Percentage(faultLFU),"%");
            System.out.printf("%s\t%d\t\t%.1f%s\n","Optimal",faultOPT, Percentage(faultOPT),"%");
            System.out.println();
        }
    }

    // Returns a double as a percentage
    public double Percentage(double num) {
        return (num / faultOPT) * 100;
    }
}
