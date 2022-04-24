/*
 * Deren Bozer
 * COSC 525 MW 1:00pm
 * Disk Space Allocation
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Indexed {

    // Variables
    private static ArrayList<String> taskList;
    private static int numberOfBlocks;
    private static int numberOfHeadMoves;
    private static int numberOfFilesNotAllocated;
    private static ArrayList<Integer> dataDisk;
    private static int availableDiskSpace;
    private static int currentHeadLocation;
    private static int taskID;
    private static int itemsInDirectory;

    private static ArrayList<ArrayList<String>> directoryList;

    public Indexed(ArrayList<String> inList) {
        // Variables
        taskList = new ArrayList<String>();
        taskList.addAll(inList);
        numberOfBlocks = Integer.parseInt(taskList.get(0));
        numberOfHeadMoves = 0;
        numberOfFilesNotAllocated = 0;
        taskID = 0;

        // Initialize the "Disk"
        dataDisk = new ArrayList<Integer>();
        availableDiskSpace = numberOfBlocks;
        currentHeadLocation = 0;
        itemsInDirectory = 0;
        for(int i = 0; i < numberOfBlocks; i++) {
            dataDisk.add(-1);
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
            AddToDisk(fileName, fileSize);
        } else if(task.equals("print")) {
            PrintDataContents();
        } else if(task.equals("read")) {
            ReadDisk(fileName);
        } else if(task.equals("del")) {
            DeleteDirItem(fileName);
        }
    }

    private static void AddToDisk(String fileName, int fileSize) {
        boolean addedToDisk = false;
        int searchStart = 0;
        if(fileSize > availableDiskSpace) {
            // Checks if there is space on the disk
            numberOfFilesNotAllocated++;
        } else {
            int diskMoveCount = numberOfBlocks;
            int availableSpace = 0;
            while(diskMoveCount > 0) {
                if(dataDisk.get(searchStart) == -1) {
                    availableSpace++;
                    if(availableSpace == fileSize) {
                        addedToDisk = true;
                        break;
                    }
                }
                searchStart++;
                diskMoveCount--;
            }
        }

        if(addedToDisk) {
            // Adds the item to the directory
            itemsInDirectory++;
            ArrayList<Integer> blockItems = new ArrayList<Integer>();

            // Gets the current head location
            int sizeOfFileToAdd = fileSize;

            for(int i = 0; i < dataDisk.size(); i++) {
                if(dataDisk.get(i) == -1 && sizeOfFileToAdd > 0) {
                    dataDisk.set(i,itemsInDirectory);
                    blockItems.add(i);
                    sizeOfFileToAdd--;
                }
            }

            AddItemToDirectory(itemsInDirectory, fileName, blockItems, itemsInDirectory);

            // Replaces the asterisks in the directory with the task num
            for(int item : blockItems) {
                dataDisk.set(item, itemsInDirectory);
            }

            System.out.println("File " + fileName + " was added successfully");
        } else {
            System.out.println("File " + fileName + " could not be added.");
        }
    }

    private static void AddItemToDirectory(int itemNum, String fileNa, ArrayList<Integer> blockLocations, int dirNum) {
        // Adds an item list to the directory list
        ArrayList<String> newDirectoryItem = new ArrayList<>();
        newDirectoryItem.add(String.valueOf(itemNum));
        newDirectoryItem.add(fileNa);
        newDirectoryItem.add(",");
        newDirectoryItem.add("Blocks ");
        newDirectoryItem.add(convertIntListToString(blockLocations));
        newDirectoryItem.add(String.valueOf(dirNum));

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
        int printIterate = 10;
        System.out.println("DETAILS:");

        for(int item : dataDisk) {
            if(printIterate == 1) {
                if(item == -1) {
                    System.out.print("*" + " " + "\n");
                } else {
                    System.out.print(item + " " + "\n");
                }
                printIterate = 10;
            } else {
                if(item == -1) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(item + " ");
                }
                printIterate--;
            }
        }
        System.out.println();
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

    private static void DeleteDirItem(String fileNameToDelete) {
        // Method for deleting an item from the disk and the directory
        boolean itemRead = false;
        ArrayList<String> listToBeDeleted;

        // Loops through the Directory
        for(ArrayList<String> dirItem : directoryList) {
            if(dirItem.get(1).equals(fileNameToDelete)) {
                itemRead = true;

                int indexItemsToDelete = Integer.parseInt(dirItem.get(5));

                // Changes the items back to asterisks
                AdjustAsterisks(indexItemsToDelete);

                // Adjust Directory Numbering and Removes the directory item
                int indexOfDeletion = directoryList.indexOf(dirItem);
                directoryList.remove(dirItem);
                AdjustDirectoryNumbering(indexOfDeletion);
                // Decrements the item directory count
                itemsInDirectory--;

                break;
            }
        }

        if(itemRead) {
            System.out.println("File " + fileNameToDelete + " was deleted successfully");
        } else {
            System.out.println("File " + fileNameToDelete + " was not found or could not be read");
        }
    }

    private static void AdjustAsterisks(int delItem) {
        int asteriskToChange = delItem;
        for(int i = 0; i < numberOfBlocks; i++) {
            //System.out.println("CHECK VAL:  " + dataDisk.get(i));
            int newVal = dataDisk.get(i)-1;
            if(dataDisk.get(i) == delItem) {
                dataDisk.set(i,-1);
            } else if (dataDisk.get(i) > delItem) {
                dataDisk.set(i,newVal);
            }
            //System.out.println("NEW VAL: " + dataDisk.get(i));
        }
    }

    private static void AdjustDirectoryNumbering(int dirStart) {
        for(ArrayList<String> dirItem : directoryList) {
            int directoryNum = Integer.parseInt(dirItem.get(0));
            if(dirStart < directoryNum) {
                directoryNum--;
                dirItem.set(0,String.valueOf(directoryNum));
            }
        }
    }

    private static void StartOutput() {
        // Method for the start of the program output
        System.out.println("--------------- START INDEXED SIMULATION ---------------");
        System.out.println("totBlock = " + numberOfBlocks);
    }

    private static void EndOutput() {
        // Method for the end of the program output
        System.out.println();
        System.out.println("========= Indexed Allocation Statistics =============");
        System.out.println();
        System.out.println("During this simulation,");
        System.out.println("Total head moves = " + numberOfHeadMoves);
        System.out.println("Total number of files that could not be allocated = " + numberOfFilesNotAllocated);
        System.out.println();
        System.out.println("----------------- END of Indexed SIMULATION ---------------");
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

    // Converts the Integer array list to a string
    static String convertIntListToString(ArrayList<Integer> directoryListItem) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < directoryListItem.size(); i++) {
            builder.append(directoryListItem.get(i));
            builder.append(" ");
        }
        return builder.toString();
    }

    // Converts the String array list to a string
    static String convertToString(ArrayList<String> directoryListItem) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < directoryListItem.size()-1; i++) {
            builder.append(directoryListItem.get(i));
            builder.append(" ");
        }
        return builder.toString();
        /*
         * Modified version of code snippet source:
         * https://www.dotnetperls.com/convert-arraylist-string-java
         */
    }
}
