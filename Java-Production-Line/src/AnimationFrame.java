import javax.swing.*;

public class AnimationFrame extends JFrame {

    AnimationPanel panel;

    AnimationFrame() {
        panel = new AnimationPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null); // MAKES THE PANEL APPEAR IN THE MIDDLE OF THE SCREEN
        this.setVisible(true);
    }
}
