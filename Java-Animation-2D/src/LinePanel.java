import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LinePanel extends JPanel implements ActionListener {
    // CREATES A SQUARE
    final int PANEL_WIDTH = 1600;
    final int PANEL_HEIGHT = 1000;
    Image backgroundImage;
    Timer timer;
    Image[] itemsArray = new Image[26];

    // CREATES THE CUBE OBJECTS
    public static LineCube cube0 = new LineCube(new ImageIcon("WidgetImages/item0.png").getImage(),0);
    public static LineCube cube1 = new LineCube(new ImageIcon("WidgetImages/item1.png").getImage(),-200);
    public static LineCube cube2 = new LineCube(new ImageIcon("WidgetImages/item2.png").getImage(),-200);
    public static LineCube cube3 = new LineCube(new ImageIcon("WidgetImages/item3.png").getImage(),-200);
    public static LineCube cube4 = new LineCube(new ImageIcon("WidgetImages/item4.png").getImage(),-200);
    public static LineCube cube5 = new LineCube(new ImageIcon("WidgetImages/item5.png").getImage(),-200);
    public static LineCube cube6 = new LineCube(new ImageIcon("WidgetImages/item6.png").getImage(),-200);
    public static LineCube cube7 = new LineCube(new ImageIcon("WidgetImages/item7.png").getImage(),-200);
    public static LineCube cube8 = new LineCube(new ImageIcon("WidgetImages/item8.png").getImage(),-200);
    public static LineCube cube9 = new LineCube(new ImageIcon("WidgetImages/item9.png").getImage(),-200);
    public static LineCube cube10 = new LineCube(new ImageIcon("WidgetImages/item10.png").getImage(),-200);
    public static LineCube cube11 = new LineCube(new ImageIcon("WidgetImages/item11.png").getImage(),-200);
    public static LineCube cube12 = new LineCube(new ImageIcon("WidgetImages/item12.png").getImage(),-200);
    public static LineCube cube13 = new LineCube(new ImageIcon("WidgetImages/item13.png").getImage(),-200);
    public static LineCube cube14 = new LineCube(new ImageIcon("WidgetImages/item14.png").getImage(),-200);
    public static LineCube cube15 = new LineCube(new ImageIcon("WidgetImages/item15.png").getImage(),-200);
    public static LineCube cube16 = new LineCube(new ImageIcon("WidgetImages/item16.png").getImage(),-200);
    public static LineCube cube17 = new LineCube(new ImageIcon("WidgetImages/item17.png").getImage(),-200);
    public static LineCube cube18 = new LineCube(new ImageIcon("WidgetImages/item18.png").getImage(),-200);
    public static LineCube cube19 = new LineCube(new ImageIcon("WidgetImages/item19.png").getImage(),-200);
    public static LineCube cube20 = new LineCube(new ImageIcon("WidgetImages/item20.png").getImage(),-200);
    public static LineCube cube21 = new LineCube(new ImageIcon("WidgetImages/item21.png").getImage(),-200);
    public static LineCube cube22 = new LineCube(new ImageIcon("WidgetImages/item22.png").getImage(),-200);
    public static LineCube cube23 = new LineCube(new ImageIcon("WidgetImages/item23.png").getImage(),-200);
    public static LineCube cube24 = new LineCube(new ImageIcon("WidgetImages/item24.png").getImage(),-200);
    public static LineCube cube25 = new LineCube(new ImageIcon("WidgetImages/item25.png").getImage(),-200);

    LinePanel() {
        // ADDS IMAGES TO THE ARRAY
        itemsArray[0] = new ImageIcon("WidgetImages/item0.png").getImage();
        itemsArray[1] = new ImageIcon("WidgetImages/item1.png").getImage();
        itemsArray[2] = new ImageIcon("WidgetImages/item2.png").getImage();
        itemsArray[3] = new ImageIcon("WidgetImages/item3.png").getImage();
        itemsArray[4] = new ImageIcon("WidgetImages/item4.png").getImage();
        itemsArray[5] = new ImageIcon("WidgetImages/item5.png").getImage();
        itemsArray[6] = new ImageIcon("WidgetImages/item6.png").getImage();
        itemsArray[7] = new ImageIcon("WidgetImages/item7.png").getImage();
        itemsArray[8] = new ImageIcon("WidgetImages/item8.png").getImage();
        itemsArray[9] = new ImageIcon("WidgetImages/item9.png").getImage();
        itemsArray[10] = new ImageIcon("WidgetImages/item10.png").getImage();
        itemsArray[11] = new ImageIcon("WidgetImages/item11.png").getImage();
        itemsArray[12] = new ImageIcon("WidgetImages/item12.png").getImage();
        itemsArray[13] = new ImageIcon("WidgetImages/item13.png").getImage();
        itemsArray[14] = new ImageIcon("WidgetImages/item14.png").getImage();
        itemsArray[15] = new ImageIcon("WidgetImages/item15.png").getImage();
        itemsArray[16] = new ImageIcon("WidgetImages/item16.png").getImage();
        itemsArray[17] = new ImageIcon("WidgetImages/item17.png").getImage();
        itemsArray[18] = new ImageIcon("WidgetImages/item18.png").getImage();
        itemsArray[19] = new ImageIcon("WidgetImages/item19.png").getImage();
        itemsArray[20] = new ImageIcon("WidgetImages/item20.png").getImage();
        itemsArray[21] = new ImageIcon("WidgetImages/item21.png").getImage();
        itemsArray[22] = new ImageIcon("WidgetImages/item22.png").getImage();
        itemsArray[23] = new ImageIcon("WidgetImages/item23.png").getImage();
        itemsArray[24] = new ImageIcon("WidgetImages/item24.png").getImage();
        itemsArray[25] = new ImageIcon("WidgetImages/item25.png").getImage();

        // SETS THE PANEL DIMENSION
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        // SETS THE BACKGROUND COLOR
        this.setBackground(Color.BLACK);

        // CREATES THE BACKGROUND IMAGE
        backgroundImage = new ImageIcon("background.png").getImage();

        // STARTS THE TIMER WHEN THE PANEL IS INSTANTIATED
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        // CREATES THE BACKGROUND
        g2.drawImage(backgroundImage, 0, 0, null);

        // DRAWS THE IMAGE FOR THE TWO OBJECTS
        g2.drawImage(cube1.cubeImage,cube1.xPosition,695,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //cube1.nextSpot();

        repaint();
    }
}
