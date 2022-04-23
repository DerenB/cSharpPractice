/*
 * Deren Bozer
 * COSC 525 MW 1:00pm
 * Disk Space Allocation
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Input file name
    private final static String INPUT_FILE_NAME = "input.txt";

    // Input String Array
    public static ArrayList<String> inputList;

    // Variables
    public static int numberOfBlocks;
    public static int numberOfHeadMoves;
    public static int numberOfFilesNotAllocated;
    public static boolean fileReadSuccess;

    public static void main(String[] args) {
        // Initializes Input List
        inputList = new ArrayList<String>();

        // Read input data method
        getFileData();

        // Contiguous Class
        Contiguous c = new Contiguous(inputList);
        Indexed d = new Indexed(inputList);

        // Indexed Class
    }

    public static void getFileData() {
        // Method for connecting to the input file and reading in the data
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("Input File, " + INPUT_FILE_NAME + ", not found.");
            System.exit(1);
        }

        while(fileIn.hasNextLine()) {
            inputList.add(fileIn.nextLine());
        }
    }
}
