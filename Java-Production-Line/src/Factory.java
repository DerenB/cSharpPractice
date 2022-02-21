import java.util.Random;

public class Factory {
    public static void main(String[] args) {
        System.out.println("Start");

        for(int i = 1; i < 25; i++) {
            int redValue = RandomValue();
            int greenValue = RandomValue();
            int blueValue = RandomValue();
            Widget widget = new Widget(i, redValue, greenValue, blueValue);
            System.out.println("Widget ID: " + widget.modelNumber);
            System.out.println("Red Value: " + widget.red);
            System.out.println("Green Value: " + widget.green);
            System.out.println("Blue Value: " + widget.blue);
            System.out.println(" --- --- --- ---");
        }
    }

    public static int RandomValue() {
        Random random = new Random();
        int value = random.nextInt(256);
        return value;
    }
}
