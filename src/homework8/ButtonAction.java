package homework8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonAction implements ActionListener {
    public JTextField textField;
    private boolean start;
    private boolean dot;
    private String operation;
    private double result;

    public ButtonAction(JTextField textField) {
        this.textField = textField;
        reset();
    }

    private void reset() {
        start = true;
        dot = true;
        operation = "C";
        result = 0;
        textField.setText("0.0");
    }

    private void calc() {
        double x = Double.parseDouble(textField.getText());

        if (operation.equals("*")) result *= x;
        else if (operation.equals("/")) result /= x;
        else if (operation.equals("+")) result += x;
        else if (operation.equals("-")) result -= x;
        else result = x;

        textField.setText(Double.toString(result));
    }

    public void actionPerformed(ActionEvent event) {
        String str = event.getActionCommand();

        if (str.equals("C")) {
            reset();
            return;
        }

        if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-") || str.equals("=")) {
            calc();
            operation = str;
            start = true;
            dot = true;
            return;
        }

        if (start) {
            if (str.equals(".")) {
                textField.setText("0.");
                dot = false;
                start = false;
                return;
            } else {
                textField.setText(str);
                start = false;
                return;
            }
        } else {
            textField.setText(textField.getText()+str);
        }
    }
}
