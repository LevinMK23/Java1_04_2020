package lesson8.gui;
import javax.swing.*;

public class Win1 {

    public static void main(String[] args) {
        JFrame win = new JFrame("Title");
        win.setSize(640, 480);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setLocationRelativeTo(null);
        win.setResizable(false);
        win.setVisible(true);
    }
}
