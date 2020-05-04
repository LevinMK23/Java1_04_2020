package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PinkBall extends GameLogic {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("PinkBall");
        GameLogic gameLogic = new GameLogic();
        jFrame.setBounds(10, 10, 694, 600);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setBackground(Color.BLACK);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(gameLogic);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Close game?");
                if (res == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        jFrame.setVisible(true);
    }
}
