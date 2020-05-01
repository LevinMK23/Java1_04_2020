package lesson8hw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {
    public Window() {
        setTitle("Whois - приложение для проверки доменов");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(null);

        JTextArea textArea = new JTextArea(10, 1);
        textArea.setBounds(10, 170, 480, 180);
        add(textArea);

        JTextField textField = new JTextField();
        textField.setBounds(10, 10, 200, 30);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Whois domain = new Whois(textField.getText());
                try {
                    textArea.setText(domain.info());
                } catch (Exception exception) {
                    textArea.setText("Error: " + exception);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        add(textField);

        JLabel annotation = new JLabel("Укажите имя домена или IP-адрес, например geekbrains.ru");
        annotation.setBounds(10, 50, 500, 30);
        add(annotation);

        JLabel domainInfo = new JLabel("Информация об имени домена или IP-адреса");
        domainInfo.setBounds(10, 130, 500, 30);
        add(domainInfo);

        JButton button = new JButton("Find");
        button.setBounds(10, 90, 100, 30);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Whois domain = new Whois(textField.getText());
                try {
                    textArea.setText(domain.info());
                } catch (Exception exception) {
                    textArea.setText("Error: " + exception);
                }
            }
        });

        setVisible(true);
    }
}
