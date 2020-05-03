import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {
    private static GameField instance = null;
    public static final int SIZE = 450;
    public final String EMPTY = "_";
    boolean gameOver = false;
    String gameOverMessage = "Игра окончена!";
    static int size = 3;
    int mapSize;
    int x;
    int y;
    public String[][] map;



    public static synchronized GameField getInstance() {
        if (instance == null)
            instance = new GameField();
        return instance;
    }

    void startNewGame() {
        gameOver = false;
        gameOverMessage = "Игра окончена!";
        mapSize = SIZE / size;
        map = new String[size][size];
        repaint();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        setVisible(true);
    }

    private GameField() {
        setVisible(false);
        Human human = new Human("X");
        Robot robot = new Robot("O");


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX() / mapSize;
                y = e.getY() / mapSize;
                System.out.println("Mouse clicked on " + e.getX() + " " + e.getY());


                if (!gameOver) {
                    if (human.shot(x, y)) {
                        if (human.win()) {
                            System.out.println("Игрок выиграл");
                            gameOver = true;
                            gameOverMessage = "Игрок выиграл";
                        }
                        if (getInitMap()) {
                            gameOver = true;
                            gameOverMessage = "Ничья";
                        }
                        repaint();
                        if (!gameOver) {
                            robot.shot(x, y);
                        }
                        if (robot.win()) {
                            System.out.println("Компьютер выиграл");
                            gameOver = true;
                            gameOverMessage = "Компьютер выиграл";
                        }
                        repaint();
                        if (getInitMap()) {
                            gameOver = true;
                            gameOverMessage = "Ничья";
                        }
                    }
                }
            }
        });
    }


    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > size - 1 || y > size - 1) {
            return false;
        }
        return map[x][y] != EMPTY;
    }

    public boolean getInitMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY)
                    return false;
            }
        }
        return true;
    }


    public static boolean checkWin(char dot) {
        char[][] map = new char[3][3];

        if (
                (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) ||
                        (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) ||
                        (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) ||
                        (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) ||
                        (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) ||
                        (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) ||
                        (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) ||
                        (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot))
        {
            return true;
        }

        return false;
    }


                @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i <= this.size; i++) {
                    g.drawLine(0, i * this.mapSize, SIZE, i * this.mapSize);
                    g.drawLine(i * this.mapSize, 0, i * this.mapSize, SIZE);
                }
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (map[i][j] != EMPTY) {
                            if (map[i][j] == "X") {
                                g.setColor(Color.BLUE);
                                g.drawLine((i * mapSize), (j * mapSize), (i +1) * mapSize, (j + 1) * mapSize);
                                g.drawLine((i + 1) * mapSize, (j * mapSize), (i * mapSize), (j + 1) * mapSize);
                            }
                            if (map[i][j] == "O" || map[i][j] == "O") {
                                g.setColor(Color.GREEN);
                                g.drawOval((i * mapSize), (j * mapSize), mapSize, mapSize);
                            }
                        }
                    }
                }

                if (gameOver) {
                    g.setColor(Color.BLUE);
                    g.setFont(new Font("Inna", 50,50));
                    g.drawString(gameOverMessage, 150, 25 * SIZE / 50);
                }
            }

}
