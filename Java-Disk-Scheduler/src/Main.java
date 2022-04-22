/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT: Disk Schedulers Assignment
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Input file name
    private final static String INPUT_FILE_NAME = "input.txt";

    // Input Array List
    public static ArrayList<Integer> inputList;

    // Input Items Organized
    public static int numberOfTracks;
    public static ArrayList<Integer> timeList;
    public static ArrayList<Integer> trackNumRequest;

    public static void main(String[] args) {
        // Initializes variables
        inputList = new ArrayList<Integer>();
        timeList = new ArrayList<Integer>();
        trackNumRequest = new ArrayList<Integer>();

        // Calls method to read file into arraylist
        getFileData();

        // Sorts the input data
        numberOfTracks = inputList.get(0);
        if((inputList.size()-1) % 2 != 0) {
            System.out.println("Input file format error.");
            System.exit(1);
        } else {
            for(int i = 1; i < inputList.size(); i++) {
                if(i % 2 == 0) {
                    trackNumRequest.add(inputList.get(i));
                } else {
                    timeList.add(inputList.get(i));
                }
            }
        }

        // Calls the Algorithm Classes
        FCFS fcfsAlgo = new FCFS(numberOfTracks,timeList,trackNumRequest);
        SSTF sstfAlgo = new SSTF(numberOfTracks,timeList,trackNumRequest);

        //Closing statement
        System.out.println();
        System.out.println("Program done, closing.");
    }

    public static void getFileData() {
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("Input File, " + INPUT_FILE_NAME + ", not found.");
            System.exit(1);
        }

        while(fileIn.hasNextInt()) {
            inputList.add(fileIn.nextInt());
        }

        // S : the number of milliseconds elapsed since the submission of the previous request
        // T : the track number requested
    }
}
