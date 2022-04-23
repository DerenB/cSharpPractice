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
        // Initializes Intput List
        inputList = new ArrayList<String>();

        // Read input data method
        getFileData();

        // Initializes variables
        numberOfBlocks = Integer.parseInt(inputList.get(0));
        numberOfHeadMoves = 0;
        numberOfFilesNotAllocated = 0;

        // Start output method
        StartOutput();

        // End output method
        EndOutput();
    }

    private static void StartOutput() {
        System.out.println("--------------- START CONTIGUOUS SIMULATION ---------------");
        System.out.println("totBlock = " + numberOfBlocks);
    }

    private static void EndOutput() {
        System.out.println("========= Indexed Allocation Statistics =============");
        System.out.println();
        System.out.println("During this simulation,");
        System.out.println("Total head moves = " + numberOfHeadMoves);
        System.out.println("Total number of files that could not be allocated = " + numberOfFilesNotAllocated);
        System.out.println();
        System.out.println("----------------- END of Indexed SIMULATION ---------------");
        System.out.println();
    }

    public static void getFileData() {
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
