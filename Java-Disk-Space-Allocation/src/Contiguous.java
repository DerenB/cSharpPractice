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

    private static ArrayList<ArrayList<String>> directoryList;

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

        // Directory List
        directoryList = new ArrayList<>();

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
        } else if(task.equals("read")) {
            ReadDisk(fileName);
        }
    }

    private static void AddToDisk(String fileName, int filesize, int taskNum) {
        boolean addedToDisk = false;
        if(filesize > availableDiskSpace) {
            // Checks if there is space on the disk
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
            // Gets the current head location
            int endIndex = currentHeadLocation;
            int startIndex = endIndex - (filesize-1);

            // Adds the item to the directory
            itemsInDirectory++;
            AddItemToDirectory(itemsInDirectory, fileName, taskNum, startIndex, endIndex);

            // Replaces the asterisks in the directory with the task num
            for(int i = filesize; i > 0; i--) {
                dataDisk.set(endIndex,String.valueOf(taskNum));
                endIndex--;
            }
            System.out.println("File " + fileName + " was added successfully");
        } else {
            System.out.println("File " + fileName + " could not be added.");
        }
    }

    private static void AddItemToDirectory(int directNum, String fileNa, int dirNum, int stIndex, int enIndex) {
        // Adds an item list to the directory list
        ArrayList<String> newDirectoryItem = new ArrayList<>();
        newDirectoryItem.add(dirNum + ".");
        newDirectoryItem.add(fileNa);
        newDirectoryItem.add(",");
        newDirectoryItem.add("Blocks");
        for(int i = stIndex; i <= enIndex; i++) {
            newDirectoryItem.add(String.valueOf(i));
        }
        directoryList.add(newDirectoryItem);
    }

    private static void PrintDataContents() {
        // Header
        System.out.println();
        System.out.println("============== Current Drive Contents =================");
        System.out.println();

        // Directory Items
        System.out.println("DIRECTORY:");
        for(ArrayList<String> dirItem : directoryList) {
            System.out.println(convertToString(dirItem));
        }
        System.out.println();

        // Detail Items
        int iterate = 10;
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
        System.out.println();
    }

    private static void IterateHeadLocation() {
        // Moves the header
        if(currentHeadLocation == 29) {
            currentHeadLocation = 0;
            numberOfHeadMoves++;
        } else {
            currentHeadLocation++;
        }
    }

    private static void ReadDisk(String fileNameToRead) {
        // Method for reading the disk
        boolean itemRead = false;

        // Loops through the Directory
        for(ArrayList<String> dirItem : directoryList) {
            if(dirItem.get(1).equals(fileNameToRead)) {
                itemRead = true;
                break;
            }
        }
        if(itemRead) {
            System.out.println("File " + fileNameToRead + " was read successfully with 1 head move(s).");
        } else {
            System.out.println("File " + fileNameToRead + " was not found or could not be read");
        }
    }

    private static void StartOutput() {
        // Method for the start of the program output
        System.out.println("--------------- START CONTIGUOUS SIMULATION ---------------");
        System.out.println("totBlock = " + numberOfBlocks);
    }

    private static void EndOutput() {
        // Method for the end of the program output
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

    // Converts the integer array list to a string
    static String convertToString(ArrayList<String> numbers) {
        StringBuilder builder = new StringBuilder();

        for(String num : numbers) {
            builder.append(num);
            builder.append(" ");
        }

        // builder.deleteCharAt(0);
        // builder.deleteCharAt(0);
        return builder.toString();

        /*
         * Code snippet source:
         * https://www.dotnetperls.com/convert-arraylist-string-java
         */
    }
}
