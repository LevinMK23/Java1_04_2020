package lesson8.gui;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Actions extends JFrame {
    public Actions() throws HeadlessException {
        JMenuBar bar = new JMenuBar();
        setSize(300,300);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(3,3));
        JRadioButton rb = new JRadioButton("Radio button");
        rb.addActionListener(a->{
            if (rb.isSelected()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        });
        JCheckBoxMenuItem cb = new JCheckBoxMenuItem("Check box");
        JTextField txt = new JTextField();
        JButton btn = new JButton("Button");
        JLabel lbl = new JLabel("Label");
        btn.addActionListener(a->{
            txt.setText(txt.getText() + "1");
        });
        lbl.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + "; " + e.getY());
            }
        });
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if (e.getKeyCode() == 10) {
                    txt.setText("");
                }
            }
        });
        panel.add(rb);
        panel.add(cb);
        panel.add(txt);
        panel.add(btn);
        panel.add(lbl);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Actions();
    }
}
