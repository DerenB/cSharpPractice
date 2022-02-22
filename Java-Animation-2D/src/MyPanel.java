import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    // CREATES A SQUARE
    final int PANEL_WIDTH = 600;
    final int PANEL_HEIGHT = 1066;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 2; // Used to adjust image X-axis speed
    int yVelocity = 2; // Used to adjust image Y-axis speed
    int x = 0;
    int y = 0;

    MyPanel() {
        // SETS THE PANEL DIMENSION
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        // SETS THE BACKGROUND COLOR
        this.setBackground(Color.BLACK);

        enemy = new ImageIcon("Protoss.png").getImage();
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

        g2d.drawImage(backgroundImage, 0, 0, null);

        g2d.drawImage(enemy, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // AFTER EVERY SECOND (SET IN THE TIMER VARIABLE 10 MS) AN ACTION IS PERFORMED
        // EVERYTHING IN THIS METHOD WILL OCCUR

        if(x >= PANEL_WIDTH-enemy.getWidth(null) || x < 0) {
            // CHECKS IF THE ITEM REACHES THE PANEL WIDTH
            // INVERSES THE XVELOCITY IF IT DOES
            xVelocity = xVelocity * -1;
        }

        if(y >= PANEL_HEIGHT-enemy.getHeight(null) || y < 0) {
            // CHECKS IF THE ITEM REACHES THE PANEL WIDTH
            // INVERSES THE XVELOCITY IF IT DOES
            yVelocity = yVelocity * -1;
        }

        // MOVE ENEMY ON X AXIS
        x = x + xVelocity;

        // MOVE ENEMY ON Y AXIS
        y = y + yVelocity;

        // CALLS THE PAINT METHOD TO REDRAW THE POSITION
        repaint();
    }
}
