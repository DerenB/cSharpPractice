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

    public static void main(String[] args) {
        // Initializes variables
        inputList = new ArrayList<Integer>();

        // Calls method to read file into arraylist
        getFileData();
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
