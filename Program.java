package Snake;

import javax.swing.*;
import java.awt.*;

public class Program {
//    class MyPanel extends JPanel {
//        private static final long serialVersionUID = -5120203616437379506L;
//        MyPanel() { setPreferredSize(new Dimension(400, 400)); }
//        @Override
//        public void paint(Graphics g)
//        {
//            super.paint(g);
//            g.drawLine(0, 0, 100, 100);
//        }

    public static void main (String [] args) {
//        JFrame frame = new JFrame();
//        frame.setTitle("Snake");
//        frame.setSize(600,400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        MyPanel grapPanel = new MyPanel();
//
//        frame.add(grapPanel);
//        frame.setVisible(true);
//        Graphics g = grapPanel.getGraphics();
//        grapPanel.paint(g);
        GameModel game = new GameModel(10,10);
        game.Course = GameModel.eCourse.UP;
        for (int i = 0; i< 5 ; i++){
            game.RefreshField();
            game.Print();
            System.out.println();
        }

    }
}
