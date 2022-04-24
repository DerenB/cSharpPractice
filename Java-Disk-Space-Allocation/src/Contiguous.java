import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contiguous {

    // Variables
    private static ArrayList<String> taskList;
    private static int numberOfBlocks;
    private static int numberOfHeadMoves;
    private static int numberOfFilesNotAllocated;
    private static ArrayList<String> dataDisk;
    private static int availableDiskSpace;
    private static int currentHeadLocation;
    private static int taskID;
    private static int itemsInDirectory;

    public Contiguous(ArrayList<String> inList) {
        // Variables
        taskList = new ArrayList<String>();
        taskList.addAll(inList);
        numberOfBlocks = Integer.parseInt(taskList.get(0));
        numberOfHeadMoves = 0;
        numberOfFilesNotAllocated = 0;
        taskID = 0;

        // Initialize the "Disk"
        dataDisk = new ArrayList<String>();
        availableDiskSpace = numberOfBlocks;
        currentHeadLocation = 0;
        itemsInDirectory = 0;
        for(int i = 0; i < numberOfBlocks; i++) {
            dataDisk.add("*");
        }

        // Initial simulation output
        StartOutput();

        // Run the program
        for(int i = 1; i < taskList.size(); i++) {
            String commandString = taskList.get(i);
            taskID++;

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
            ExecuteCommands(command.trim().toLowerCase(),fileName.trim(),size, taskID);
        }

        // End simulation output
        EndOutput();
    }

    private static void ExecuteCommands(String task, String fileName, int fileSize, int taskNum) {
        if(task.equals("add")) {
            AddToDisk(fileName, fileSize, taskNum);
        } else if(task.equals("print")) {
            PrintDataContents();
        }
    }

    private static void AddToDisk(String fileName, int filesize, int taskNum) {
        boolean addedToDisk = false;
        if(filesize > availableDiskSpace) {
            numberOfFilesNotAllocated++;
        } else {
            int diskMoveCount = numberOfBlocks;
            int availableSpace = 0;
            while(diskMoveCount > 0) {
                if(dataDisk.get(currentHeadLocation).equals("*")) {
                    availableSpace++;
                    if(availableSpace == filesize) {
                        addedToDisk = true;
                        break;
                    }
                }
                IterateHeadLocation();
                diskMoveCount--;
            }
        }

        if(addedToDisk) {
            int endIndex = currentHeadLocation;
            for(int i = filesize; i > 0; i--) {
                dataDisk.set(endIndex,"b");
                endIndex--;
            }
            System.out.println("File " + fileName + " was added successfully");
            itemsInDirectory++;
        } else {
            System.out.println("File " + fileName + " could not be added.");
        }
        System.out.println();
    }

    private static void PrintDataContents() {
        int listNums = itemsInDirectory;
        int iterate = 10;
        System.out.println("============== Current Drive Contents =================");
        System.out.println();
        System.out.println("DETAILS:");
        for(String item : dataDisk) {
            if(iterate == 1) {
                System.out.print(item + " " + "\n");
                iterate = 10;
            } else {
                System.out.print(item + " ");
                iterate--;
            }
        }
    }

    private static void IterateHeadLocation() {
        if(currentHeadLocation == 29) {
            currentHeadLocation = 0;
            numberOfHeadMoves++;
        } else {
            currentHeadLocation++;
        }
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
