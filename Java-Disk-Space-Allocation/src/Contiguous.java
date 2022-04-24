import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contiguous {

    // Variables
    private static ArrayList<String> taskList;
    private static int numberOfBlocks;
    private static int numberOfHeadMoves;
    private static int numberOfFilesNotAllocated;

    public Contiguous(ArrayList<String> inList) {
        // Variables
        taskList = new ArrayList<String>();
        taskList.addAll(inList);
        numberOfBlocks = Integer.parseInt(taskList.get(0));
        numberOfHeadMoves = 0;
        numberOfFilesNotAllocated = 0;

        // Initial simulation output
        StartOutput();

        // Run the program
        for(int i = 1; i < taskList.size(); i++) {
            String commandString = taskList.get(i);

            // Get the File name
            String fileName = "";
            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = p.matcher(commandString);
            while (m.find()) {
                fileName = m.group(1);
            }
            // Source for Pattern/Matcher code snippet:
            // https://www.codegrepper.com/code-examples/java/how+to+select+string+between+double+quotes+in+java

            // Get the task
            String command;
            int index = commandString.contains(" ") ? commandString.indexOf(" ") : 0;
            if(index == 0) {
                command = commandString;
            } else {
                command = commandString.substring(0, index);
            }

            // Get the file size
            String dataSize;
            int dataIndex = commandString.lastIndexOf(' ');
            if(dataIndex == -1) {
                dataIndex = 0;
            }
            dataSize = commandString.substring(dataIndex,commandString.length()).trim();
            int size = ParseInt(dataSize);

            // Execute line
            ExecuteCommands(command.trim(),fileName.trim(),size);
        }

        // End simulation output
        EndOutput();
    }

    private static void ExecuteCommands(String task, String fileName, int fileSize) {
        System.out.println("-----------------------------");
        System.out.println("Task: " + task);
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
        System.out.println();
    }

    private static void StartOutput() {
        // Method for the start of the program output
        System.out.println("--------------- START CONTIGUOUS SIMULATION ---------------");
        System.out.println("totBlock = " + numberOfBlocks);
    }

    private static void EndOutput() {
        System.out.println();
        System.out.println("========= Contiguous Allocation Statistics =============");
        System.out.println();
        System.out.println("During this simulation,");
        System.out.println("Total head moves = " + numberOfHeadMoves);
        System.out.println("Total number of files that could not be allocated = " + numberOfFilesNotAllocated);
        System.out.println();
        System.out.println("----------------- END of CONTIGUOUS SIMULATION ---------------");
        System.out.println();
    }

    // Parses a string for an integer with a try-catch
    public static Integer ParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
