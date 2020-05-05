package homework8;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    public JTextField textField;
    private ButtonAction buttonPressed;

    public MainPanel(int width, int height) {
        int w = width / 5, h = height / 8, sx = w / 7, sy = h / 4;

        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBounds(sx, sy, 2 * sx + 3 * w, h);
        textField.setEditable(false);
        add(textField);

        buttonPressed = new ButtonAction(textField);
        String[] buttonText = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "/",
                "0", ".", "=", "*"
        };
        for (int i = 0; i < buttonText.length; i++) {
            addButton(sx + (w + sx) * (i % 4), (2 * sy + h) + (sy + h) * (i / 4),
                    w, h, buttonText[i], buttonPressed);
        }

        JButton buttonClear = new JButton("C");
        buttonClear.setBounds(4 * sx + 3 * w, sy, w, h);
        buttonClear.addActionListener(buttonPressed);
        buttonClear.setFocusPainted(false);
        add(buttonClear);
    }

    void addButton(int i, int j, int w, int h, String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBounds(i, j, w, h);
        button.setFocusPainted(false);
        button.addActionListener(actionListener);
        add(button);
    }
}
