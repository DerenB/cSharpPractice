import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    // CREATES A SQUARE
    final int PANEL_WIDTH = 600;
    final int PANEL_HEIGHT = 1066;
    Image backgroundImage;
    Timer timer;

    // CREATES TWO INSTANCES OF ENEMY OBJECT
    public Enemy val1 = new Enemy(new ImageIcon("Protoss.png").getImage(),0,0);
    public Enemy val2 = new Enemy(new ImageIcon("Yrel.png").getImage(),300,0);
    public Enemy val3 = new Enemy(new ImageIcon("base.png").getImage(),0,0);


    MyPanel() {
        // SETS THE PANEL DIMENSION
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        // SETS THE BACKGROUND COLOR
        this.setBackground(Color.BLACK);

        // CREATES THE BACKGROUND IMAGE
        backgroundImage = new ImageIcon("background.jpg").getImage();

        // STARTS THE TIMER WHEN THE PANEL IS INSTANTIATED
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // PAINTS THE BACKGROUND
        super.paint(g);

        // WILL DRAW THE ENEMY IMAGE ON THE PANEL
        Graphics2D g2d = (Graphics2D) g;

        // CREATES THE BACKGROUND
        g2d.drawImage(backgroundImage, 0, 0, null);

        // DRAWS THE IMAGE FOR THE TWO OBJECTS
        g2d.drawImage(val1.enemyImage,val1.xPosition, val1.yPosition, null);
        g2d.drawImage(val2.enemyImage,val2.xPosition, val2.yPosition, null);
        g2d.drawImage(val3.enemyImage,val3.xPosition, val3.yPosition, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // AFTER EVERY SECOND (SET IN THE TIMER VARIABLE 10 MS) AN ACTION IS PERFORMED
        // EVERYTHING IN THIS METHOD WILL OCCUR

        // CHECKS IF THE ITEM REACHES THE PANEL WIDTH
        // INVERSES THE XVELOCITY IF IT DOES
        val1.widthCheck(PANEL_WIDTH-val1.enemyImage.getWidth(null));
        val2.widthCheck(PANEL_WIDTH-val2.enemyImage.getWidth(null));
        val3.widthCheck(PANEL_WIDTH-val3.enemyImage.getWidth(null));

        // CHECKS IF THE ITEM REACHES THE PANEL HEIGHT
        // INVERSES THE XVELOCITY IF IT DOES
        val1.heightCheck(PANEL_HEIGHT-val1.enemyImage.getWidth(null));
        val2.heightCheck(PANEL_HEIGHT-val2.enemyImage.getWidth(null));
        val3.heightCheck(PANEL_HEIGHT-val3.enemyImage.getWidth(null));

        // MOVE ENEMY ON X AXIS
        val1.moveXAxis();
        val2.moveXAxis();
        val3.moveXAxis();

        // MOVE ENEMY ON Y AXIS
        val1.moveYAxis();
        val2.moveYAxis();
        val3.moveYAxis();

        // CALLS THE PAINT METHOD TO REDRAW THE POSITION
        repaint();
    }
}
