import javax.swing.*;
import java.awt.*;

public class LineCube {
    public int xPosition;
    public Image cubeImage;

    public LineCube(Image image, int xStart) {
        cubeImage = image;
        xPosition = xStart;
    }

    public void nextBelt() {
        xPosition = xPosition + 420;
    }

    public void nextSpot() {
        xPosition = xPosition + 105;
    }

    public void enterScreen() {
        //xPosition = 194;
        xPosition = 404;
    }

    public void exitScreen() {
        xPosition = 1800;
    }

    public void position(int num) {
        switch (num) {
            case 1:
                xPosition = 194;
                break;
            case 2:
                xPosition = 299;
                break;
            case 3:
                xPosition = 404;
                break;
            case 4:
                xPosition = 615;
                break;
            case 5:
                xPosition = 720;
                break;
            case 6:
                xPosition = 825;
                break;
            case 7:
                xPosition = 1036;
                break;
            case 8:
                xPosition = 1141;
                break;
            case 9:
                xPosition = 1246;
                break;
        }
    }

}
