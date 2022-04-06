import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Input file name
    private final static String INPUT_FILE_NAME = "pages.txt";

    // Input Array List
    public static ArrayList<Integer> inputList;

    public static void main(String[] args) {
        // Initializes list
        inputList = new ArrayList<Integer>();

        // Calls method to read file into arraylist
        getFileData();

        System.out.println("List Start");
        for(Integer item : inputList) {
            if(item == -1) {
                System.out.println("End of section");
            } else {
                System.out.println(item);
            }
        }
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
