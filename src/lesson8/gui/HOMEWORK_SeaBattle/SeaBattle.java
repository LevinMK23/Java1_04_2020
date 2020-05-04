package lesson8.gui.HOMEWORK_SeaBattle;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeaBattle extends JFrame {

    private JLabel headLabel;
    private JButton[][] buttonMap;
    private JLabel[][] labelMap;
    private JButton startButton, closeButton;
    private ImageIcon ship = new ImageIcon("src/lesson8/gui/HOMEWORK_SeaBattle/res/military-ship-57027.jpg");
    private ImageIcon userShip = new ImageIcon("src/lesson8/gui/HOMEWORK_SeaBattle/res/userShip.jpg");
    private ImageIcon hideComputerShip = new ImageIcon("src/lesson8/gui/HOMEWORK_SeaBattle/res/empty.jpg");
    private ImageIcon empty = new ImageIcon("src/lesson8/gui/HOMEWORK_SeaBattle/res/empty.jpg");
    private ImageIcon wreckedShip = new ImageIcon("src/lesson8/gui/HOMEWORK_SeaBattle/res/wreckedShip.jpg");
    private ImageIcon separator = new ImageIcon("src/lesson8/gui/HOMEWORK_SeaBattle/res/separator.jpg");
    private JLabel score, horizontalSeparator;
    private static final Random rnd = new Random();

    public SeaBattle() {
        super("SeaBattle");
        setSize(616, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        headLabel = new JLabel();
        headLabel.setIcon(ship);
        startButton = new JButton("Start");
        closeButton = new JButton("Close");
        startButton.setPreferredSize(new Dimension(300, 75));
        closeButton.setPreferredSize(new Dimension(300, 75));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createGameField();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        add(headLabel);
        add(startButton);
        add(closeButton);
        setVisible(true);
    }

    private void createGameField() {
        remove(startButton);
        remove(closeButton);
        remove(headLabel);
        setSize(266, 600);
        setLocationRelativeTo(null);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        score = new JLabel("Счет: ");
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(new Font(score.getFont().getName(), score.getFont().getStyle(), 20));
        score.setBorder(new LineBorder(Color.BLACK));
        score.setPreferredSize(new Dimension(500, 30));
        add(score);
        getComputerMap();
        getUserMap();
        setComputerShips();
    }


    private JMenu createFileMenu() {

        JMenu file = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Главное меню");
        JMenuItem exit = new JMenuItem("Выход");
        open.addActionListener(actionEvent -> {
            dispose();
            new SeaBattle();
        });
        exit.addActionListener(actionEvent -> {
            dispose();
        });
        file.add(open);
        file.addSeparator();
        file.add(exit);
        return file;
    }

    private void getComputerMap() {
        buttonMap = new JButton[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttonMap[i][j] = new JButton();
                buttonMap[i][j].setPreferredSize(new Dimension(25, 25));
                buttonMap[i][j].setIcon(empty);
                add(buttonMap[i][j]);
            }
        }
    }

    private void getUserMap() {
        horizontalSeparator = new JLabel();
        horizontalSeparator.setIcon(separator);
        add(horizontalSeparator);
        labelMap = new JLabel[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                labelMap[i][j] = new JLabel();
                labelMap[i][j].setPreferredSize(new Dimension(25, 25));
                labelMap[i][j].setIcon(empty);
                add(labelMap[i][j]);
            }
        }
    }

    private boolean isFreeCell(int x, int y, JLabel map[][]) {
        int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int dx, dy;
        if (map[x][y].equals(empty) && x >= 0 && x < 10 && y >= 0 && y < 10) {
            for (int i = 0; i < 8; i++) {
                dx = x + d[i][1];
                dy = y + d[i][2];
                if (map[dx][dy].equals(empty) && dx >= 0 && dx < 10 && dy >= 0 && dy < 10) {
                    continue;
                } else return false;
            }
            return true;
        }
        return false;
    }

    private void setComputerShips() {
        int x, y, kx, ky;

        boolean flag;
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j == 3 - i; j++) {
                do {
                    x = rnd.nextInt(10);
                    y = rnd.nextInt(10);
                    kx = rnd.nextInt(2);
                    if (kx == 0) {
                        ky = 1;
                    } else ky = 0;

                    flag = true;
                    for (int k = 0; k < i; k++) {
                        if (!isFreeCell(x + kx * k, y + ky * k, labelMap)) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        for (int k = 0; k < i; k++) {
                            labelMap[x + kx * k][y + ky * k].setIcon(wreckedShip);
                        }
                    }
                } while (flag);
            }
        }
    }
}


