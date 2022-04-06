import java.util.ArrayList;
import java.util.Collections;

public class PageOPT {
    // FIRST IN FIRST OUT

    public int numberOfFrames;
    private ArrayList<Integer> frameArray;
    private ArrayList<Integer> nextUse;

    public PageOPT(ArrayList<Integer> input, int frame) {
        numberOfFrames = frame;
        frameArray = new ArrayList<>();
        nextUse = new ArrayList<>();
        for(int i = 0; i < frame; i++) {
            frameArray.add(0);
            nextUse.add(0);
        }

        // OUTPUT
        print(input);

        int positionIncrement = 0;

        for(int i = 1; i < input.size(); i++) {
            int num = input.get(i);
            System.out.print(num + " : ");

            if(frameArray.contains(num)) {
                //System.out.print();
            } else {
                Pager.faultOPT++;

                if(positionIncrement<frame) {
                    frameArray.set(positionIncrement,num);
                    positionIncrement++;
                } else {
                    for(int k = 0; k < frameArray.size(); k++) {
                        int temp = frameArray.get(k);
                        int distance = FindDistanceToNextOccurance(temp,i,input);
                        nextUse.set(k,distance);
                    }

                    frameArray.set(MaxPosition(nextUse),num);
                    for(int k = 0; k < nextUse.size(); k++) {
                        nextUse.set(k,0);
                    }
                }
                System.out.print(frameArray);
            }
            System.out.println();
        }
    }

    private int FindDistanceToNextOccurance(int checkVal, int startPosition, ArrayList<Integer> list) {
        int distanceToNextOccurance = 0;
        for(int i = startPosition; i < list.size(); i++) {
            if(list.get(i) == checkVal) {
                break;
            } else {
                distanceToNextOccurance++;
            }
        }
        return distanceToNextOccurance;
    }

    private int MaxPosition(ArrayList<Integer> input) {
        int maxVal = Collections.max(input);

        return input.indexOf(maxVal);
    }

    private void print(ArrayList<Integer> input) {
        String listSummary = convertToString(input);
        System.out.println();
        System.out.println("Optimal:");
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
