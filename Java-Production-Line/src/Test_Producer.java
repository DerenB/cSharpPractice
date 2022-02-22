import java.util.*;

public class Test_Producer extends Thread {
    public Test_Producer(Test_BoundedBuffer b) {
        buffer = b;
    }

    public void run()
    {
        Date message;

        while (true)
        {
            Test_BoundedBuffer.napping();

            // produce an item & enter it into the buffer
            message = new Date();
            System.out.println("Producer produced " + message);

            buffer.enter(message);
        }
    }

    private  Test_BoundedBuffer buffer;
}
