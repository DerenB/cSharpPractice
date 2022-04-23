import java.util.ArrayList;

public class Indexed {

    // Variables
    private static ArrayList<String> inputList;
    private static int numberOfBlocks;
    private static int numberOfHeadMoves;
    private static int numberOfFilesNotAllocated;

    public Indexed(ArrayList<String> inList) {
        inputList = new ArrayList<String>();
        inputList.addAll(inList);
        numberOfBlocks = Integer.parseInt(inputList.get(0));
        numberOfHeadMoves = 0;
        numberOfFilesNotAllocated = 0;

        // Initial simulation output
        StartOutput();

        // End simulation output
        EndOutput();
    }

    private static void StartOutput() {
        // Method for the start of the program output
        System.out.println("--------------- START INDEXED SIMULATION ---------------");
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
}
