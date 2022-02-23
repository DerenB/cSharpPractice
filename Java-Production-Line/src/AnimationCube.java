import java.awt.*;

public class AnimationCube {
    // VARIABLES
    public int xPosition;
    public Image cubeImage;
    public String name;
    public int cubeBeltPosition;

    // DEFAULT CONSTRUCTOR
    public AnimationCube(Image image, int xStart, String n) {
        cubeImage = image;
        xPosition = xStart;
        name = n;
        cubeBeltPosition = 0;
    }

    // CUBE EXITS THE SCREEN
    public void exitScreen() {
        xPosition = 1800;
    }

    public void setPosition(int input) {
        xPosition = input;
    }
}
