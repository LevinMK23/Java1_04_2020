package geekbrains.lession0;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class GameXO extends JFrame {
    char[][] mapChar = new char[3][3];
    private final static char EMPTY2d = '_';
    private final static char DOT_X2d = 'X';
    private final static char DOT_O2d = 'O';
    private final ImageIcon DOT_X = new ImageIcon("src\\res\\Dot_X.jpg");
    private final ImageIcon DOT_O = new ImageIcon("src\\res\\Dot_O.jpg");
    private final ImageIcon EMPTY = new ImageIcon("src\\res\\Null.jpg");
    private int tryCount = 9;


    private JButton[][] map;
    char[][] map2d = getInitMap(3);

    public static char[][] getInitMap(int size) {
        char[][] map2d = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map2d[i][j] = EMPTY2d;
            }
        }
        return map2d;
    }


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
                JButton tmp = map[i][j];
                mapChar[i][j] = EMPTY2d;
                map[i][j].setText((i + " " + j));
                tmp.addActionListener(actionEvent -> {
                    tmp.setIcon(DOT_X);
                    tmp.setEnabled(false);
                    tmp.setDisabledIcon(DOT_X);
                    // TODO: 28.04.2020 PC logic integration and check victory
                    // tmp.isEnabled() == false - на кнопке тригерилось какое то событие
                    int x = Integer.parseInt(tmp.getText().split(" ")[0]);
                    int y = Integer.parseInt(tmp.getText().split(" ")[1]);
                    mapChar[x][y] = DOT_X2d;
                    tryCount--;
                    if (CheckVIctory(mapChar, DOT_X2d)) {
                        clear(map);

                        JOptionPane.showMessageDialog(this, "Вы победили!!!",
                                "ПОБЕДА!", JOptionPane.DEFAULT_OPTION);
                        JOptionPane.showMessageDialog(this,"Что бы сыграть еще раз, выберите файл-новая игра","Сыграть еще раз?",JOptionPane.DEFAULT_OPTION);
                    } else {
                        if (tryCount == 0) {
                            JOptionPane.showMessageDialog(this, "Ничья", "Ничья", JOptionPane.DEFAULT_OPTION);
                            JOptionPane.showMessageDialog(this,"Что бы сыграть еще раз, выберите файл-новая игра","Сыграть еще раз?",JOptionPane.DEFAULT_OPTION);
                        } else {
                            try {
                                Thread.sleep(300);
                            } catch(Exception e){
                            }
                            PcHod(mapChar, map);
                            if (CheckVIctory(mapChar, DOT_O2d)) {
                                clear(map);
                                JOptionPane.showMessageDialog(this, "Вы проиграли...",
                                        "Поражение...", JOptionPane.DEFAULT_OPTION);
                                JOptionPane.showMessageDialog(this,"Что бы сыграть еще раз, выберите файл-новая игра","Сыграть еще раз?",JOptionPane.DEFAULT_OPTION);
                            }
                        }
                    }
                });
                panel.add(map[i][j]);
            }
        }
        return panel;
    }

    private void clear(JButton[][] map) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j].setEnabled(false);
            }
        }
    }

    private boolean CheckVIctory(char[][] map, char dot) {
        boolean df1 = true, df2 = true;

        for (int i = 0; i < 3; i++) {
            boolean xf = true, yf = true;
            for (int j = 0; j < 3; j++) {
                xf &= (map[i][j] == dot);
                yf &= (map[j][i] == dot);
                if (i == j) {
                    df1 &= (map[i][j] == dot);
                }
                if ((i + j) == 2) {
                    df2 &= (map[i][j] == dot);
                }
            }
            if (xf || yf) return true;
        }
        return df1 || df2;
    }

    private void PcHod(char[][] mapChar, JButton[][] mapButton) {
        while (true) {
            char[][] mapCharCopy = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l <3 ; l++) {
                            mapCharCopy[k][l]=mapChar[k][l];
                        }
                    }
                    if (isCellValid(mapCharCopy, i, j)) {
                        mapCharCopy[i][j] = DOT_O2d;

                        if (CheckVIctory(mapCharCopy, mapCharCopy[i][j])) {
                            mapChar[i][j] = DOT_O2d;
                            mapButton[i][j].setIcon(DOT_O);
                            mapButton[i][j].setEnabled(false);
                            mapButton[i][j].setDisabledIcon(DOT_O);
                            tryCount--;
                            return;
                        }
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l <3 ; l++) {
                            mapCharCopy[k][l]=mapChar[k][l];
                        }
                    }
                    if (isCellValid(mapCharCopy, i, j)) {
                        mapCharCopy[i][j] = DOT_X2d;

                        if (CheckVIctory(mapCharCopy, mapCharCopy[i][j])) {
                            mapChar[i][j] = DOT_O2d;
                            mapButton[i][j].setIcon(DOT_O);
                            mapButton[i][j].setEnabled(false);
                            mapButton[i][j].setDisabledIcon(DOT_O);
                            tryCount--;
                            return;
                        }
                    }
                }
            }
            if (isCellValid(mapChar, 1, 1)) {
                mapChar[1][1] = DOT_O2d;
                mapButton[1][1].setIcon(DOT_O);
                mapButton[1][1].setEnabled(false);
                mapButton[1][1].setDisabledIcon(DOT_O);
                tryCount--;
                return;
            }

            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (isCellValid(mapChar, x, y)) {
                mapChar[x][y] = DOT_O2d;
                mapButton[x][y].setIcon(DOT_O);
                mapButton[x][y].setEnabled(false);
                mapButton[x][y].setDisabledIcon(DOT_O);
                tryCount--;
                return;
            }
        }
    }


    private boolean isCellValid(char[][] map, int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return map[x][y] == EMPTY2d;
        }
        return false;
    }


    public GameXO(String title) throws HeadlessException {
        super(title);
        JMenuBar bar = new JMenuBar();
        bar.add(createFileMenu());
        setJMenuBar(bar);
        add(getMap());
        setSize(540, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameXO("Крестики нолики");
    }
}
/* Я не смог сам додуматься до такого решения ( map[i][j].setText((i + " " + j)); int x = Integer.parseInt(tmp.getText().split(" ")[0]); 
можно ли было там сделать как-то по-другому? Так же я украл "JOptionPane.showMessageDialog".
Зато я добавил очень умного бота, который во-первых может сделать выигрышных для себя ход, если он есть, во-вторых может отследить выигрышный ход врага
и присечь его, а в-третьих ставит кружок в центральную кленту, если она свободна.
Я хотел сделать еще, что бы игра начиналась по очереди, а не всегда игрок первых ходил, ну у меня и так ушло очень много времени на эту работу.

А еще на строках 157-159 у меня очень много рабочего времени занимает цикл, копирующий массив, я пробовал через Object.clone (), ну у меня не получилось, как там можно было сделать проще? */

