import java.util.Random;

public class WorkerA extends Thread{

    public void run() {
        for(int i = 1; i < 25; i++) {

        }
    }

    public int RandomValue() {
        Random random = new Random();
        int value = random.nextInt(256);
        return value;
    }
}
