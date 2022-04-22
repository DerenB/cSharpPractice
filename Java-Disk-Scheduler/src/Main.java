import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Input file name
    private final static String INPUT_FILE_NAME = "input.txt";

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public static void getFileData() {
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("Input File, " + INPUT_FILE_NAME + ", not found.");
            System.exit(1);
        }
    }
}
