import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Scanner keyb = new Scanner(System.in);
        ArrayList<Integer> inputValues = new ArrayList();

        System.out.println("Enter your list of numbers: ");
        String input = keyb.nextLine();
        keyb.close();
        String[] numbers = input.split(" ");

        for(String item : numbers) {
            inputValues.add(Integer.parseInt(item));
        }

        System.out.println();
        System.out.println("Done");
    }
}
