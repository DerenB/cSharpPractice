import java.util.*;

public class Test_Consumer extends Thread {
    public Test_Consumer(Test_BoundedBuffer b)
    {
        buffer = b;
    }

    public void run()
    {
        Date message;

        while (true)
        {
            Test_BoundedBuffer.napping();

            // consume an item from the buffer
            System.out.println("Consumer wants to consume.");

            message = (Date)buffer.remove();
        }
    }

    private  Test_BoundedBuffer buffer;
}
