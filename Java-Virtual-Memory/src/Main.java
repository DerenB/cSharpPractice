/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT 4: VIRTUAL MEMORY
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Input file name
    private final static String INPUT_FILE_NAME = "pages.txt";

    // Input Array List
    public static ArrayList<Integer> inputList;

    public static void main(String[] args) {
        // Initializes variables
        inputList = new ArrayList<Integer>();
        int numberOfSequences = 0;

        // Calls method to read file into arraylist
        getFileData();

        // Counts the number of sequences
        for(Integer item : inputList) {
            if(item == -1) {
                numberOfSequences++;
            }
        }

        // Starts the Pager class
        Pager startProgram = new Pager(inputList, numberOfSequences);

        //Closing statement
        System.out.println();
        System.out.println("Program done, closing.");
    }

    // Method to read file into array list
    public static void getFileData() {
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("Input file " + INPUT_FILE_NAME + " not found.");
            System.exit(1);
        }
        while(fileIn.hasNextInt()) {
            inputList.add(fileIn.nextInt());
        }
    }
}
