package Snake;

import javax.swing.*;

public class Form extends JFrame {
    public Form() {
        setTitle("Snake");
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
