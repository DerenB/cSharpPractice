import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //new MyFrame();
        new LineFrame();

        int input;

        System.out.println("Do the thing?");
        input = scanner.nextInt();
        while(input != 6) {
            System.out.println("Now What?");
            System.out.println("1: Create Cube");
            System.out.println("2: Advance Line");
            System.out.println("3: Next Belt");
            System.out.println("4: Exit Screen");
            System.out.println("5: Position Test");
            System.out.println("6: Quit");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    LinePanel.cube1.enterScreen();
                    break;
                case 2:
                    LinePanel.cube1.nextSpot();
                    break;
                case 3:
                    LinePanel.cube1.nextBelt();
                    break;
                case 4:
                    LinePanel.cube1.exitScreen();
                    break;
                case 5:
                    System.out.println("ENTER POOP");
                    int turd = scanner.nextInt();
                    LinePanel.cube1.position(turd);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not valid option.");
                    break;
            }
        }
    }
}
