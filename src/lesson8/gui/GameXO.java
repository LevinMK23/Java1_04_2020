package lesson8.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GameXO extends JFrame {

    private JButton [][] map;
    private final ImageIcon DOT_X = new ImageIcon("src\\lesson8\\gui\\res\\x.jpg");
    private final ImageIcon DOT_O = new ImageIcon("src\\lesson8\\gui\\res\\o.jpg");
    private final ImageIcon EMPTY = new ImageIcon("src\\lesson8\\gui\\res\\empty.jpg");

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
                        } else if (map[i][j].getIcon().equals(DOT_O)){
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
        JPanel panel = new JPanel(new GridLayout(3,3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = new JButton();
                map[i][j].setIcon(EMPTY);
                JButton tmp = map[i][j];
                tmp.addActionListener(actionEvent -> {
                    tmp.setIcon(DOT_X);
                    tmp.setEnabled(false);
                    tmp.setDisabledIcon(DOT_X);
                    // TODO: 28.04.2020 PC logic integration and check victory
                    // tmp.isEnabled() == false - на кнопке тригерилось какое то событие
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
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameXO("Крестики нолики");
    }
}
