/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT 4: VIRTUAL MEMORY
 */

import java.util.ArrayList;
import java.util.Collections;

public class PageLRU {
    // LEAST RECENTLY USED

    public int numberOfFrames;
    private ArrayList<Integer> frameArray;
    private ArrayList<Integer> oldestAccess;

    public PageLRU(ArrayList<Integer> input, int frame) {
        numberOfFrames = frame;
        frameArray = new ArrayList<>();
        oldestAccess = new ArrayList<>();

        // Adds starting values
        for(int i = 0; i < frame; i++) {
            frameArray.add(0);
            oldestAccess.add(0);
        }

        // OUTPUT
        print(input);

        // Position next position
        int positionIncrement = 0;

        for(int i = 1; i < input.size(); i++) {
            int num = input.get(i);
            System.out.print(num + " : ");

            if(frameArray.contains(num)) {
                // Checks if num already in memory
                for(int k = 0; k < frame; k++) {
                    int frameArrayValue = frameArray.get(k);
                    int oldestAccessValue = oldestAccess.get(k);

                    if(frameArrayValue == num) {
                        // Resets access timer to 0 if num matches
                        oldestAccess.set(k,0);
                    } else {
                        // Increments access time if num does not match
                        oldestAccess.set(k,oldestAccessValue+1);
                    }
                }

            } else {
                // Num not in memory
                Pager.faultLRU++;

                // Setting new value for access timer
                for(int k = 0; k < frame; k++) {
                    if(frameArray.get(k) == num) {
                        // Resets timer to 0 if num value matches
                        oldestAccess.set(k,0);
                    } else {
                        // Increments access timer if num does not match
                        int temp = oldestAccess.get(k);
                        oldestAccess.set(k,temp+1);
                    }
                }

                // Adds to empty position when memory empty
                if(positionIncrement<frame) {
                    frameArray.set(positionIncrement,num);
                    positionIncrement++;
                } else {
                    // Uses max value to set num to the oldest access
                    frameArray.set(MaxPosition(oldestAccess),num);
                    oldestAccess.set(MaxPosition(oldestAccess),0);
                }
                System.out.print(frameArray);
            }
            //System.out.println(oldestAccess);
            System.out.println();
        }
    }

    // Returns the maximum value of the list parameter
    private int MaxPosition(ArrayList<Integer> input) {
        int maxVal = Collections.max(input);

        return input.indexOf(maxVal);
    }

    // Print Method
    private void print(ArrayList<Integer> input) {
        String listSummary = convertToString(input);
        System.out.println();
        System.out.println("LRU:");
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
