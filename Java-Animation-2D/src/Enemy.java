import javax.swing.*;
import java.awt.*;

public class Enemy {
    public int xPosition;
    public int yPosition;
    public int xVelocity;
    public int yVelocity;
    public Image enemyImage;

    public Enemy(Image image, int xStart, int yStart) {
        xPosition = xStart;
        yPosition = yStart;
        xVelocity = 2;
        yVelocity = 2;
        enemyImage = image;
    }

    // CHECKS THE X AXIS BOUNDARY
    public void widthCheck(int width) {
        if (xPosition >= width || xPosition < 0) {
            xVelocity = xVelocity * -1;
        }
    }

    // CHECKS THE Y AXIS BOUNDARY
    public void heightCheck(int height) {
        if (yPosition >= height || yPosition < 0) {
            yVelocity = yVelocity * -1;
        }
    }

    // MOVES THE IMAGE ALONG THE X AXIS
    public void moveXAxis() {
        xPosition = xPosition + xVelocity;
    }

    // MOVES THE IMAGE ALONG THE Y AXIS
    public void moveYAxis() {
        yPosition = yPosition + yVelocity;
    }
}
