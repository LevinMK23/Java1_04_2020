package lesson8.gui.HOMEWORK_SeaBattle;

import javax.swing.*;

public class SeaBattleTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new SeaBattle();
                    }
                }
        );
    }
}

