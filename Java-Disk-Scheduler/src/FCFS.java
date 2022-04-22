/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT: Disk Schedulers Assignment
 */

import java.util.ArrayList;

public class FCFS {
    // F.C.F.S. - First Come First Serve

    private static int numberOfTracks;
    public static ArrayList<Integer> pendingRequests;

    public FCFS(int trackNum, ArrayList<Integer> timeList, ArrayList<Integer> trackNumRequest) {
        numberOfTracks = trackNum;
        pendingRequests = new ArrayList<Integer>();

        int time = 0;
        int projectedNextTime;
        int head = 0;
        int projectedNextHead;
        boolean headGoingUp = true;
        int timeListIteration = 1;
        int requestListIteration = 0;

        System.out.println("=======FCFS SCHEDULER=========================");
        System.out.println(trackNumRequest.size());
        System.out.println(pendingRequests.size());

        while(trackNumRequest.size() > 0 || pendingRequests.size() > 0) {
            if(pendingRequests.size() == 0) {
                int addVal = trackNumRequest.get(0);
                pendingRequests.add(trackNumRequest.get(0));
                trackNumRequest.remove(0);
                requestListIteration++;
                System.out.println("[Time=" + time + "] Adding request " + addVal);
                System.out.println("\t" + "Head @ " + head + ". Current target = " + addVal + " . Pending requests are now [" + convertToString(pendingRequests) + "]");
            } else {
                int currentTarget = pendingRequests.get(0);
                int distanceToNextRequest;
                if(headGoingUp) {
                    distanceToNextRequest = currentTarget - head;
                    if(timeListIteration < timeList.size()) {
                        projectedNextHead = head + timeList.get(timeListIteration);
                    } else {
                        // projectedNextHead = head + distanceToNextRequest;
                        projectedNextHead = currentTarget;
                    }
                    if(projectedNextHead > numberOfTracks || currentTarget < head) {
                        headGoingUp = false;
                        projectedNextHead = numberOfTracks;
                    } else {
                        if(projectedNextHead >= currentTarget) {
                            pendingRequests.remove(0);
                            System.out.println("[Time=" + time + "] >>>>SERVICING track " + currentTarget);
                            String outputList;
                            if(pendingRequests.size() == 0) {
                                outputList = " ";
                            } else {
                                outputList = convertToString(pendingRequests);
                            }
                            System.out.println("\t" + "Head @ " + currentTarget + ". Current target = " + currentTarget + " . Pending requests are now [" + outputList + "]");
                        } else if (trackNumRequest.size() != 0) {
                            int requestBeingAdded = trackNumRequest.get(0);
                            pendingRequests.add(requestBeingAdded);
                            trackNumRequest.remove(0);
                            if(timeListIteration < timeList.size()) {
                                head += timeList.get(timeListIteration);
                            } else {
                                head = currentTarget;
                            }
                            System.out.println("[Time=" + time + "] Adding request " + requestBeingAdded + ".");
                            System.out.println("\t" + "Head @ " + head + ". Current target = " + currentTarget + " . Pending requests are now [" + convertToString(pendingRequests) + "]");
                            timeListIteration++;
                        }
                    }
                } else if(!headGoingUp) {
                    distanceToNextRequest = head - currentTarget; // 146 = 183 - 37

                    if(timeListIteration < timeList.size()) {
                        projectedNextHead = head - timeList.get(timeListIteration); // 168 = 183 - 15
                    } else {
                        // projectedNextHead = head - distanceToNextRequest;
                        projectedNextHead = currentTarget;
                    }
                    if(projectedNextHead < 0) {
                        headGoingUp = true;
                        projectedNextHead = 0;
                    }
                    if(projectedNextHead <= currentTarget) {
                        pendingRequests.remove(0);
                        System.out.println("[Time=" + time + "] >>>>SERVICING track " + currentTarget);
                        String outputList;
                        if(pendingRequests.size() == 0) {
                            outputList = " ";
                        } else {
                            outputList = convertToString(pendingRequests);
                        }
                        System.out.println("\t" + "Head @ " + currentTarget + ". Current target = " + currentTarget + " . Pending requests are now [" + outputList + "]");
                    } else if(trackNumRequest.size() > 0) {
                        int requestBeingAdded = trackNumRequest.get(0);
                        pendingRequests.add(requestBeingAdded);
                        trackNumRequest.remove(0);
                        if(timeListIteration < timeList.size()) {
                            head -= timeList.get(timeListIteration);
                        } else {
                            head = currentTarget;
                        }
                        System.out.println("[Time=" + time + "] Adding request " + requestBeingAdded + ".");
                        System.out.println("\t" + "Head @ " + head + ". Current target = " + currentTarget + " . Pending requests are now [" + convertToString(pendingRequests) + "]");
                        timeListIteration++;
                    }
                }
            }
        }


        // trackNumRequest.size() != 0 && pendingRequests.size() != 0
    }



    // Converts the integer array list to a string
    static String convertToString(ArrayList<Integer> numbers) {
        StringBuilder builder = new StringBuilder();

        for(int num : numbers) {
            builder.append(num);
            builder.append(", ");
        }

        builder.deleteCharAt( builder.length()-1);
        builder.deleteCharAt( builder.length()-1);
        return builder.toString();

        /*
         * Code snippet source:
         * https://www.dotnetperls.com/convert-arraylist-string-java
         */
    }
}
