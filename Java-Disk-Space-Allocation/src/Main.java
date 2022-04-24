/*
 * Deren Bozer
 * COSC 525 MW 1:00pm
 * Disk Space Allocation
 */

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    // Input file name
    private final static String INPUT_FILE_NAME = "input.txt";

    // Input String Array
    public static ArrayList<String> inputList;

    public static void main(String[] args) {
        // Initializes Input List
        inputList = new ArrayList<String>();

        // Read input data method
        getFileData();

        // Contiguous Class
        Contiguous c = new Contiguous(inputList);

        // Indexed Class
        // Indexed d = new Indexed(inputList);

        /*
        for(String item : inputList) {
            System.out.println(item);

            // Get the File name
            String fileName = "";
            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = p.matcher(item);
            while (m.find()) {
                fileName = m.group(1);
            }

            // Get the task
            String command;
            int index = item.contains(" ") ? item.indexOf(" ") : 0;
            command = item.substring(0, index);

            // Get the file size
            String dataSize;
            int dataIndex = item.lastIndexOf(' ');
            if(dataIndex == -1) {
                dataIndex = 0;
            }
            dataSize = item.substring(dataIndex,item.length()).trim();
            int size = ParseInt(dataSize);

            // Test OutPut
            //System.out.println("Task:" + command);
            //System.out.println("File Name:" + fileName);
            //System.out.println("Data Size:" + dataSize);
            //System.out.println("Int Size:" + size);
            //System.out.println();
        }
         */
    }

    public static Integer ParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
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
