package lesson8.gui.homework;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * GUI игры
 */
public class GameXO extends JFrame {

    private JButton [][] map;
    private final GameBoard board; // Ссылка на игровую доску с логикой игры

    private JMenu createFileMenu() {
        JMenu file = new JMenu("Файл");
        JMenuItem newGame = new JMenuItem("Новая игра");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem open = new JMenuItem("Загрузить");
        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(actionEvent -> {
            dispose();
        });
        save.addActionListener(act -> {
            File fSave = new File("src\\lesson8\\gui\\homework\\res\\saved.txt");
            try (PrintWriter pr = new PrintWriter(fSave)) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        pr.print(board.getField(i, j));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        open.addActionListener(act -> {
            File fSave = new File("src\\lesson8\\gui\\homework\\res\\saved.txt");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fSave)));
                char dot;
                int halfTurns = 0;
                try {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            dot = (char) br.read();
                            board.setField(i, j, dot);
                            if (dot == Const.EMPTY) {
                                map[i][j].setEnabled(true);
                                map[i][j].setIcon(Const.ICON_EMPTY);
                                map[i][j].setDisabledIcon(null);
                            } else if (dot == Const.DOT_X) {
                                halfTurns++;
                                map[i][j].setEnabled(false);
                                map[i][j].setDisabledIcon(Const.ICON_X);
                            } else {
                                halfTurns++;
                                map[i][j].setEnabled(false);
                                map[i][j].setDisabledIcon(Const.ICON_O);
                            }
                        }
                        // При загрузке устанавливаем количество ходов
                        board.setHalfTurns(halfTurns);
                        // Если загружаемся без создания нового окна игры, то пункт меню "Файл -> Сохранить"
                        // остаётся неактивным после окончания игры. Нужно сделать его активным
                        this.getJMenuBar().getMenu(0).getItem(2).setEnabled(true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        newGame.addActionListener(actionEvent -> {
            new GameXO("Крестики-нолики");
            dispose();
        });
        file.add(newGame);
        file.addSeparator();
        file.add(save);
        file.add(open);
        file.addSeparator();
        file.add(exit);
        return file;
    }

    private JPanel getMap() {
        map = new JButton[5][5];
        JPanel panel = new JPanel(new GridLayout(5,5));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = new JButton();
                map[i][j].setIcon(Const.ICON_EMPTY);
                JButton tmp = map[i][j];
                int x = i;
                int y = j;
                tmp.addActionListener(actionEvent -> {
                    board.turn(x, y, this);
                    // tmp.isEnabled() == false - на кнопке тригерилось какое то событие
                });
                panel.add(map[i][j]);
            }
        }
        return panel;
    }

    /**
     * Управляет извне класса внешним видом кнопки. Нужна классу GameBoard для визуализации хода
     * @param i координата кнопки по вертикали
     * @param j координата кнопки по горизонтали
     * @param disabledIcon иконка, которая будет отображаться на неактивной кнопке
     */
    public void setMapDisabled(int i, int j, Icon disabledIcon) {
        map[i][j].setEnabled(false);
        map[i][j].setDisabledIcon(disabledIcon);
    }

    /**
     * Обработчик победы одного из игроков: деактивирует все оставшиеся свободные клетки,
     * запрещает сохранение текущего состояния игры, выдаёт в шапку окна сообщение о выигрыше или проигрыше
     * @param dot какой из игроков победил: крестики либо нолики
     */
    public void gameOver(char dot) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j].setEnabled(false);
            }
        }
        this.getJMenuBar().getMenu(0).getItem(2).setEnabled(false);
        if (dot == Const.DOT_X) { this.setTitle("Вы выиграли"); }
        else { this.setTitle("Вы проиграли"); }
    }

    public GameXO(String title) throws HeadlessException {
        super(title);
        board = new GameBoard();
        JMenuBar bar = new JMenuBar();
        bar.add(createFileMenu());
        setJMenuBar(bar);
        add(getMap());
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameXO("Крестики-нолики");
    }
}
