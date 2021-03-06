/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT 4: VIRTUAL MEMORY
 */

import java.util.ArrayList;

public class PageFIFO {
    // FIRST IN FIRST OUT

    public int numberOfFrames;
    private ArrayList<Integer> frameArray;

    public PageFIFO(ArrayList<Integer> input, int frame) {
        numberOfFrames = frame;
        frameArray = new ArrayList<>();

        // Adds starting values
        for(int i = 0; i < frame; i++) {
            frameArray.add(0);
        }

        // OUTPUT
        print(input);

        // Position next position
        int positionIncrement = 0;


        for(int i = 1; i < input.size(); i++) {
            int num = input.get(i);
            System.out.print(num + " : ");

            if(frameArray.contains(num)) {
                // Skips num if already in the memory
                System.out.print("");
            } else {
                // Increments the faults
                Pager.faultFIFO++;

                // Sets the position for the new num
                frameArray.set(positionIncrement,num);
                System.out.print(frameArray);

                // Increments the position
                if(positionIncrement == frame-1) {
                    positionIncrement = 0;
                } else {
                    positionIncrement++;
                }
            }
            System.out.println();
        }
    }

    // Print Method
    private void print(ArrayList<Integer> input) {
        String listSummary = convertToString(input);
        System.out.println("FIFO:");
        System.out.println(listSummary);
        for(int i = 0; i < listSummary.length(); i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    // Converts the integer array list to a string
    static String convertToString(ArrayList<Integer> numbers) {
        StringBuilder builder = new StringBuilder();

        for(int num : numbers) {
            builder.append(num);
            builder.append(" ");
        }

        builder.deleteCharAt(0);
        builder.deleteCharAt(0);
        return builder.toString();

        /*
         * Code snippet source:
         * https://www.dotnetperls.com/convert-arraylist-string-java
         */
    }
}
