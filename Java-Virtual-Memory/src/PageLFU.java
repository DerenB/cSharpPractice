/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT 4: VIRTUAL MEMORY
 */

import java.util.ArrayList;
import java.util.Collections;

public class PageLFU {
    // LEAST FREQUENTLY USED

    public int numberOfFrames;
    private ArrayList<Integer> frameArray;
    private ArrayList<Integer> pageLoadFrequency;


    public PageLFU(ArrayList<Integer> input, int frame) {
        numberOfFrames = frame;
        frameArray = new ArrayList<>();
        pageLoadFrequency = new ArrayList<>();
        for(int i = 0; i < frame; i++) {
            frameArray.add(0);
            pageLoadFrequency.add(0);
        }

        // OUTPUT
        print(input);

        int positionIncrement = 0;

        for(int i = 1; i < input.size(); i++) {
            int num = input.get(i);
            System.out.print(num + " : ");

            if(frameArray.contains(num)) {
                for(int k = 0; k < frame; k++) {
                    int frameArrayValue = frameArray.get(k);
                    int pageLoadValue = pageLoadFrequency.get(k);

                    if(frameArrayValue == num) {
                        pageLoadFrequency.set(k,0);
                    } else {
                        pageLoadFrequency.set(k,pageLoadValue+1);
                    }
                }
            } else {
                Pager.faultLFU++;

                if(positionIncrement<frame) {
                    frameArray.set(positionIncrement,num);
                    positionIncrement++;
                } else {
                    frameArray.set(MaxPosition(pageLoadFrequency),num);
                    pageLoadFrequency.set(MaxPosition(pageLoadFrequency),0);
                }

                System.out.print(frameArray);
            }
            //System.out.println(oldestAccess);
            System.out.println();
        }
    }

    private int MaxPosition(ArrayList<Integer> input) {
        int maxVal = Collections.max(input);

        return input.indexOf(maxVal);
    }

    private void print(ArrayList<Integer> input) {
        String listSummary = convertToString(input);
        System.out.println();
        System.out.println("LFU:");
        System.out.println(listSummary);
        for(int i = 0; i < listSummary.length(); i++) {
            System.out.print("_");
        }
        System.out.println();
    }

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
