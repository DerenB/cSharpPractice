/*
 * DEREN BOZER
 * COSC-525 MW 1:00PM
 * WINTER 2022
 * PROGRAMMING ASSIGNMENT: PRODUCTION LINE
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends JPanel implements ActionListener {

    // CREATES A SQUARE
    final int PANEL_WIDTH = 1600;
    final int PANEL_HEIGHT = 1000;
    Image backgroundImage;
    Timer timer;
    Image[] itemsArray = new Image[26];
    //public static AnimationCube[] cubeArray = new AnimationCube[26];

    // CREATES TWO INSTANCES OF ENEMY OBJECT
    public static AnimationCube cube0 = new AnimationCube(new ImageIcon("WidgetImages/item0.png").getImage(),-200,"Cube0");
    public static AnimationCube cube1 = new AnimationCube(new ImageIcon("WidgetImages/item1.png").getImage(),-200,"Cube1");
    public static AnimationCube cube2 = new AnimationCube(new ImageIcon("WidgetImages/item2.png").getImage(),-200,"Cube2");
    public static AnimationCube cube3 = new AnimationCube(new ImageIcon("WidgetImages/item3.png").getImage(),-200,"Cube3");
    public static AnimationCube cube4 = new AnimationCube(new ImageIcon("WidgetImages/item4.png").getImage(),-200,"Cube4");
    public static AnimationCube cube5 = new AnimationCube(new ImageIcon("WidgetImages/item5.png").getImage(),-200,"Cube5");
    public static AnimationCube cube6 = new AnimationCube(new ImageIcon("WidgetImages/item6.png").getImage(),-200,"Cube6");
    public static AnimationCube cube7 = new AnimationCube(new ImageIcon("WidgetImages/item7.png").getImage(),-200,"Cube7");
    public static AnimationCube cube8 = new AnimationCube(new ImageIcon("WidgetImages/item8.png").getImage(),-200,"Cube8");
    public static AnimationCube cube9 = new AnimationCube(new ImageIcon("WidgetImages/item9.png").getImage(),-200,"Cube9");
    public static AnimationCube cube10 = new AnimationCube(new ImageIcon("WidgetImages/item10.png").getImage(),-200,"Cube10");
    public static AnimationCube cube11 = new AnimationCube(new ImageIcon("WidgetImages/item11.png").getImage(),-200,"Cube11");
    public static AnimationCube cube12 = new AnimationCube(new ImageIcon("WidgetImages/item12.png").getImage(),-200,"Cube12");
    public static AnimationCube cube13 = new AnimationCube(new ImageIcon("WidgetImages/item13.png").getImage(),-200,"Cube13");
    public static AnimationCube cube14 = new AnimationCube(new ImageIcon("WidgetImages/item14.png").getImage(),-200,"Cube14");
    public static AnimationCube cube15 = new AnimationCube(new ImageIcon("WidgetImages/item15.png").getImage(),-200,"Cube15");
    public static AnimationCube cube16 = new AnimationCube(new ImageIcon("WidgetImages/item16.png").getImage(),-200,"Cube16");
    public static AnimationCube cube17 = new AnimationCube(new ImageIcon("WidgetImages/item17.png").getImage(),-200,"Cube17");
    public static AnimationCube cube18 = new AnimationCube(new ImageIcon("WidgetImages/item18.png").getImage(),-200,"Cube18");
    public static AnimationCube cube19 = new AnimationCube(new ImageIcon("WidgetImages/item19.png").getImage(),-200,"Cube19");
    public static AnimationCube cube20 = new AnimationCube(new ImageIcon("WidgetImages/item20.png").getImage(),-200,"Cube20");
    public static AnimationCube cube21 = new AnimationCube(new ImageIcon("WidgetImages/item21.png").getImage(),-200,"Cube21");
    public static AnimationCube cube22 = new AnimationCube(new ImageIcon("WidgetImages/item22.png").getImage(),-200,"Cube22");
    public static AnimationCube cube23 = new AnimationCube(new ImageIcon("WidgetImages/item23.png").getImage(),-200,"Cube23");
    public static AnimationCube cube24 = new AnimationCube(new ImageIcon("WidgetImages/item24.png").getImage(),-200,"Cube24");
    public static AnimationCube cube25 = new AnimationCube(new ImageIcon("WidgetImages/item25.png").getImage(),-200,"Cube25");

    AnimationPanel() {
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

        // ADDS THE CUBE OBJECTS TO THE CUBE ARRAY
        Factory.cubeArray[0] = cube0;
        Factory.cubeArray[0] = cube0;
        Factory.cubeArray[1] = cube1;
        Factory.cubeArray[2] = cube2;
        Factory.cubeArray[3] = cube3;
        Factory.cubeArray[4] = cube4;
        Factory.cubeArray[5] = cube5;
        Factory.cubeArray[6] = cube6;
        Factory.cubeArray[7] = cube7;
        Factory.cubeArray[8] = cube8;
        Factory.cubeArray[9] = cube9;
        Factory.cubeArray[10] = cube10;
        Factory.cubeArray[11] = cube11;
        Factory.cubeArray[12] = cube12;
        Factory.cubeArray[13] = cube13;
        Factory.cubeArray[14] = cube14;
        Factory.cubeArray[15] = cube15;
        Factory.cubeArray[16] = cube16;
        Factory.cubeArray[17] = cube17;
        Factory.cubeArray[18] = cube18;
        Factory.cubeArray[19] = cube19;
        Factory.cubeArray[20] = cube20;
        Factory.cubeArray[21] = cube21;
        Factory.cubeArray[22] = cube22;
        Factory.cubeArray[23] = cube23;
        Factory.cubeArray[24] = cube24;
        Factory.cubeArray[25] = cube25;

        // SETS THE PANEL DIMENSION
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        // SETS THE BACKGROUND COLOR
        this.setBackground(Color.WHITE);

        // CREATES THE BACKGROUND IMAGE
        backgroundImage = new ImageIcon("background.png").getImage();

        // STARTS THE TIMER WHEN THE PANEL IS INSTANTIATED
        timer = new Timer(100, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // PAINTS THE BACKGROUND
        super.paint(g);

        // CREATES THE GRAPHICS INTERFACE
        Graphics2D g2 = (Graphics2D) g;

        //CREATES THE BACKGROUND
        g2.drawImage(backgroundImage, 0, 0, null);

        // DRAWS THE IMAGE FOR THE TWO OBJECTS
        g2.drawImage(cube0.cubeImage,cube0.xPosition,695,null);
        g2.drawImage(cube1.cubeImage,cube1.xPosition,695,null);
        g2.drawImage(cube2.cubeImage,cube2.xPosition,695,null);
        g2.drawImage(cube3.cubeImage,cube3.xPosition,695,null);
        g2.drawImage(cube4.cubeImage,cube4.xPosition,695,null);
        g2.drawImage(cube5.cubeImage,cube5.xPosition,695,null);
        g2.drawImage(cube6.cubeImage,cube6.xPosition,695,null);
        g2.drawImage(cube7.cubeImage,cube7.xPosition,695,null);
        g2.drawImage(cube8.cubeImage,cube8.xPosition,695,null);
        g2.drawImage(cube9.cubeImage,cube9.xPosition,695,null);
        g2.drawImage(cube10.cubeImage,cube10.xPosition,695,null);
        g2.drawImage(cube11.cubeImage,cube11.xPosition,695,null);
        g2.drawImage(cube12.cubeImage,cube12.xPosition,695,null);
        g2.drawImage(cube13.cubeImage,cube13.xPosition,695,null);
        g2.drawImage(cube14.cubeImage,cube14.xPosition,695,null);
        g2.drawImage(cube15.cubeImage,cube15.xPosition,695,null);
        g2.drawImage(cube16.cubeImage,cube16.xPosition,695,null);
        g2.drawImage(cube17.cubeImage,cube17.xPosition,695,null);
        g2.drawImage(cube18.cubeImage,cube18.xPosition,695,null);
        g2.drawImage(cube19.cubeImage,cube19.xPosition,695,null);
        g2.drawImage(cube20.cubeImage,cube20.xPosition,695,null);
        g2.drawImage(cube21.cubeImage,cube21.xPosition,695,null);
        g2.drawImage(cube22.cubeImage,cube22.xPosition,695,null);
        g2.drawImage(cube23.cubeImage,cube23.xPosition,695,null);
        g2.drawImage(cube24.cubeImage,cube24.xPosition,695,null);
        g2.drawImage(cube25.cubeImage,cube25.xPosition,695,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // AFTER EVERY SECOND (SET IN THE TIMER VARIABLE 10 MS) AN ACTION IS PERFORMED
        // EVERYTHING IN THIS METHOD WILL OCCUR


        // CALLS THE PAINT METHOD TO REDRAW THE POSITION
        repaint();
    }
}
