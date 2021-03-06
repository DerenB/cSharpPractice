/*
 * DEREN BOZER
 * COSC-525 WIN22
 * MW 1:00P
 */

package scheduler;

/**
 * A factory class for generating JobWorkables to be placed in Jobs.
 * When I test your program I will replace this class with my own.
 * The only variability will be in createWork(), which will return
 * an instance of a class that I have created to implement JobWorkable.
 *
 * @author matt
 * @version 1.1
 * <p>Copyright: Copyright (c) 2016, 2015, 2004 by Matt Evett</p>
 */
public class WorkFactory {
    private int jobCount = 0;

    public JobWorkable createWork() {

        jobCount++;

//        Factory job = new Factory(jobCount);
//        return job;

        return new FactoryItem(jobCount);
    }
}
