import javax.swing.*;

public class LineFrame extends JFrame {

    LinePanel panel;

    LineFrame() {
        panel = new LinePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null); // MAKES THE PANEL APPEAR IN THE MIDDLE OF THE SCREEN
        this.setVisible(true);
    }
}
