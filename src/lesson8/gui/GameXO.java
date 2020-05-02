package lesson8.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GameXO extends JFrame {

    private JButton[][] map;
    private final ImageIcon DOT_X = new ImageIcon("src\\lesson8\\gui\\res\\x.jpg");
    private final ImageIcon DOT_O = new ImageIcon("src\\lesson8\\gui\\res\\o.jpg");
    private final ImageIcon EMPTY = new ImageIcon("src\\lesson8\\gui\\res\\empty.jpg");
    char[][] mapChar = new char[3][3];
    private final char X_CHAR = 'X';
    private final char O_CHAR = 'O';
    private final char EMPTY_CHAR = '_';
    private int tryCount = 9;


    private JMenu createFileMenu() {
        JMenu file = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Новая игра");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(actionEvent -> {
            dispose();
        });
        save.addActionListener(act -> {
            File fSave = new File("src\\lesson8\\gui\\res\\saved.txt");
            try (PrintWriter pr = new PrintWriter(fSave)) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (map[i][j].getIcon().equals(DOT_X)) {
                            pr.print("x");
                        } else if (map[i][j].getIcon().equals(DOT_O)) {
                            pr.print("o");
                        } else {
                            pr.print("_");
                        }
                    }
                    pr.println();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        open.addActionListener(actionEvent -> {
            new GameXO("Крестики нолики");
            dispose();
        });
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(exit);
        return file;
    }

    private JPanel getMap() {
        map = new JButton[3][3];


        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = new JButton();
                map[i][j].setIcon(EMPTY);
                map[i][j].setText(i + "_" + j);
                JButton tmp = map[i][j];
                mapChar[i][j] = EMPTY_CHAR;
                tmp.addActionListener(actionEvent -> {
                    tmp.setIcon(DOT_X);
                    tmp.setEnabled(false);
                    tmp.setDisabledIcon(DOT_X);
                    int x = Integer.parseInt(tmp.getText().split("_")[0]);
                    int y = Integer.parseInt(tmp.getText().split("_")[1]);
                    mapChar[x][y] = X_CHAR;
                    tryCount--;
                    if (checkVictory(mapChar, X_CHAR)) {
                        fillMap(map);
                        JOptionPane.showMessageDialog(this, "Вы победили", "Победа", JOptionPane.DEFAULT_OPTION);
                    } else if (tryCount != 0) {
                        robotTurn(mapChar, map);
                        if (checkVictory(mapChar, O_CHAR)) {
                            fillMap(map);
                            JOptionPane.showMessageDialog(this, "Вы проиграли", "Поражение", JOptionPane.DEFAULT_OPTION);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Ничья", "Ничья", JOptionPane.DEFAULT_OPTION);
                    }
                });
                panel.add(map[i][j]);
            }
        }
        return panel;
    }

    public GameXO(String title) throws HeadlessException {
        super(title);
        JMenuBar bar = new JMenuBar();
        bar.add(createFileMenu());
        setJMenuBar(bar);
        add(getMap());
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private boolean isCellValid(char[][] map, int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return map[x][y] == EMPTY_CHAR;
        }
        return false;
    }

    private boolean checkVictory(char[][] map, char dot) {

        boolean d1 = true, d2 = true;

        for (int i = 0; i < 3; i++) {
            //вертикаль, горизонталь
            boolean n1 = true, n2 = true;
            for (int j = 0; j < 3; j++) {
                n1 &= (map[i][j] == dot);
                n2 &= (map[j][i] == dot);
            }
            if (n1 || n2) return true;

            //диагонали
            d1 &= (map[i][i] == dot);
            d2 &= (map[3 - 1 - i][i] == dot);
        }
        return d1 || d2;
    }

    private void robotTurn(char[][] mapChar, JButton[][] mapButton) {

        while (true) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (isCellValid(mapChar, x, y)) {
                mapChar[x][y] = O_CHAR;
                mapButton[x][y].setIcon(DOT_O);
                mapButton[x][y].setEnabled(false);
                mapButton[x][y].setDisabledIcon(DOT_O);
                tryCount--;
                break;
            }
        }
    }

    private void fillMap(JButton[][] map) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j].setEnabled(false);
            }
        }

    }

    public static void main(String[] args) {
        new GameXO("Крестики нолики");
    }
}
