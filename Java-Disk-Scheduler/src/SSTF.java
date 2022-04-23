/*
 * DEREN BOZER
 * COSC-525
 * MW 1:00PM-2:50PM
 * PROJECT: Disk Schedulers Assignment
 */

import java.util.ArrayList;

public class SSTF {
    // S.S.T.F - Shortest Seek Time First

    private static int numberOfTracks;
    private static ArrayList<Integer> timeList;
    private static ArrayList<Integer> trackNumRequest;

    private static ArrayList<Integer> pendingRequests;

    public SSTF(int trackNum, ArrayList<Integer> inputTimeList, ArrayList<Integer> inputTrackNumRequest) {
        numberOfTracks = trackNum;
        pendingRequests = new ArrayList<Integer>();
        timeList = new ArrayList<Integer>();
        trackNumRequest = new ArrayList<Integer>();

        timeList.addAll(inputTimeList);
        trackNumRequest.addAll(inputTrackNumRequest);

        int time = 0;
        int timeInter = 1;
        int head = 0;
        int nextHeadTarget = 0;
        int currentTarget = 0;
        boolean newTargetNeeded = false;

        System.out.println("=======SSTF SCHEDULER=========================");
        while(trackNumRequest.size() > 0 || pendingRequests.size() > 0) {
            if(pendingRequests.size() == 0) {
                int newReq = trackNumRequest.get(0);
                pendingRequests.add(newReq);
                trackNumRequest.remove(0);
                currentTarget = pendingRequests.get(0);
                String output;
                if(pendingRequests.size() == 0) {
                    output = " ";
                } else {
                    output = convertToString(pendingRequests);
                }
                System.out.println("[Time=" + time + "] Adding request " + newReq + ".");
                System.out.println("\t" + "Head @ " + head + ". Current target = " + currentTarget + " Pending requests are now [" + output + "].");
            } else {
                int distanceToHead;
                if(currentTarget > head) {
                    distanceToHead = currentTarget - head;
                } else {
                    distanceToHead = head - currentTarget;
                }
                if(newTargetNeeded) {
                    int shortestDistance = numberOfTracks;
                    currentTarget = pendingRequests.get(0);

                    for(int reqItem : pendingRequests) {
                        int temp;
                        if(reqItem > head) {
                            temp = reqItem - head;
                        } else {
                            temp = head - reqItem;
                        }
                        if(temp <= shortestDistance) {
                            shortestDistance = temp;
                            currentTarget = reqItem;
                        }
                    }
                    newTargetNeeded = false;
                }
                if(timeInter < timeList.size()) {
                    nextHeadTarget = head + timeList.get(timeInter);
                } else {
                    nextHeadTarget = currentTarget;
                }
                if(currentTarget > head) {
                    if(currentTarget > nextHeadTarget) {
                        if(timeInter < timeList.size()) {
                            head += timeList.get(timeInter);
                        } else {
                            time += distanceToHead;
                            head = currentTarget;
                        }
                        if(trackNumRequest.size() > 0) {
                            int nextItem = trackNumRequest.get(0);
                            trackNumRequest.remove(0);
                            pendingRequests.add(nextItem);
                            String output;
                            if(pendingRequests.size() == 0) {
                                output = " ";
                            } else {
                                output = convertToString(pendingRequests);
                            }
                            time += timeList.get(timeInter);
                            System.out.println("[Time=" + time + "] Adding request " + nextItem + ".");
                            System.out.println("\t" + "Head @ " + head + ". Current target = " + currentTarget + " Pending requests are now [" + output + "].");
                        }
                        timeInter++;
                    } else {
                        int tempTime = 0;
                        int tempHead = 0;
                        int itemToRemove = pendingRequests.indexOf(currentTarget);
                        pendingRequests.remove(itemToRemove);
                        if(timeInter < timeList.size()) {
                            tempTime = currentTarget;
                            tempHead = currentTarget;
                            String output;
                            if(pendingRequests.size() == 0) {
                                output = " ";
                            } else {
                                output = convertToString(pendingRequests);
                            }
                            System.out.println("[Time=" + tempTime + "] >>>>SERVICING track " + currentTarget + ".");
                            System.out.println("\t" + "Head @ " + tempHead + ". Current target = " + currentTarget + " Pending requests are now [" + output + "].");
                        } else {
                            time += distanceToHead;
                            head = currentTarget;
                            String output;
                            if(pendingRequests.size() == 0) {
                                output = " ";
                            } else {
                                output = convertToString(pendingRequests);
                            }
                            time += distanceToHead;
                            System.out.println("[Time=" + time + "] >>>>SERVICING track " + currentTarget + ".");
                            System.out.println("\t" + "Head @ " + head + ". Current target = " + currentTarget + " Pending requests are now [" + output + "].");
                        }
                        newTargetNeeded = true;
                    }
                } else {
                    if(nextHeadTarget > currentTarget) {
                        if(timeInter < timeList.size()) {
                            time += timeList.get(timeInter);
                            head -= timeList.get(timeInter);
                        } else {
                            head = currentTarget;
                        }
                        if(trackNumRequest.size() > 0) {
                            int nextItem = trackNumRequest.get(0);
                            trackNumRequest.remove(0);
                            pendingRequests.add(nextItem);
                            String output;
                            if(pendingRequests.size() == 0) {
                                output = " ";
                            } else {
                                output = convertToString(pendingRequests);
                            }
                            System.out.println("[Time=" + time + "] Adding request " + nextItem + ".");
                            System.out.println("\t" + "Head @ " + head + ". Current target = " + currentTarget + " Pending requests are now [" + output + "].");
                            timeInter++;
                        }
                    } else {
                        int tempTime = 0;
                        int tempHead = 0;
                        int itemToRemove = pendingRequests.indexOf(currentTarget);
                        pendingRequests.remove(itemToRemove);
                        if(timeInter < timeList.size()) {
                            tempTime = currentTarget;
                            tempHead = currentTarget;
                            String output;
                            if(pendingRequests.size() == 0) {
                                output = " ";
                            } else {
                                output = convertToString(pendingRequests);
                            }
                            time += distanceToHead;
                            System.out.println("[Time=" + tempTime + "] >>>>SERVICING track " + currentTarget + ".");
                            System.out.println("\t" + "Head @ " + tempHead + ". Current target = " + currentTarget + " Pending requests are now [" + output + "].");
                        }
                        newTargetNeeded = true;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Total run-time was " + time);
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
