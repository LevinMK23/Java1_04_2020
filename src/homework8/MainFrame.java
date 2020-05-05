package homework8;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        int width = 270, height = 240;
        setTitle("Calculator");
        setBounds(100, 100, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainPanel panel = new MainPanel(width, height);
        add(panel);
        setResizable(false);
        setVisible(true);
    }
}
