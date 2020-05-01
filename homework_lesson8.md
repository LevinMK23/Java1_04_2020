import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainGameField extends JFrame {
    private static MainGameField instance = null;
    protected JButton[][] map;
    private final ImageIcon DOT_X  = new ImageIcon("src\\geekbrains\\GameXO\\rsc\\DotX.jpg");
    private final ImageIcon DOT_O = new ImageIcon("src\\geekbrains\\GameXO\\rsc\\dotO.jpg");
    private final ImageIcon DOT_EMPTY = new ImageIcon("src\\geekbrains\\GameXO\\rsc\\empty.jpg");
    boolean gameOver = false;
    static int size = 3;
    String gameOverMessage = "";
    int x;
    int y;


    public static synchronized MainGameField getInstance() {
        if (instance == null)
            instance = new MainGameField();
        return instance;
    }

    private JPanel startNewGame() {
        gameOver = false;
        map = new JButton[size][size];
        JPanel panel = new JPanel(new GridLayout(3,3));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new JButton();
                map[i][j].setIcon(DOT_EMPTY);
                panel.add(map[i][j]);
            }
        }
        return panel;
    }

    public JButton printField(){
        JButton tmp =new JButton();
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                tmp = map[i][j];
            }
        }
        return tmp;
    }

    protected MainGameField() {
        setTitle("Крестики-нолики");
        JMenuBar bar = new JMenuBar();
        bar.add(createFileMenu());
        setJMenuBar(bar);
        setBounds(300, 300, 455, 525);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        add(startNewGame());
        add(modeAgainstAI());
        setVisible(true);
    }



    public JButton modeAgainstAI() {
        map = new JButton[size][size];
        HumanPlayer humanPlayer = new HumanPlayer(DOT_X);
        AI ai = new AI(DOT_O);
        while(true) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    x = e.getX();
                    y = e.getY();
                }
            });
            boolean clickOnCell = x <= map[x][y].getWidth() && y <= map[x][y].getHeight();
            if (clickOnCell) humanPlayer.gamerTurn(x, y);
            printField();
            if (humanPlayer.win()) {
                gameOverMessage = "Player WIN!";
                break;
            }
            if(isFieldFull()) {
                gameOverMessage = "DRAW!";
                break;
            }
            ai.gamerTurn(x, y);
            printField();
            if (ai.win()) {
                System.out.println("AI WIN!");
                gameOverMessage = "AI WIN!";
                break;
            }
            if(isFieldFull()) {
                gameOverMessage = "DRAW!";
                break;
            }
                }
        return map[x][y];
            }


    boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        if (!map[x][y].getIcon().equals(DOT_EMPTY)) return true;
        return false;
    }

    public boolean isFieldFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j].getIcon().equals(DOT_EMPTY))
                    return false;
            }
        }
        return true;
    }

    public boolean checkWin(ImageIcon icon){
        boolean diagonal1 =true;
        boolean diagonal2 = true;
        boolean horizontal;
        boolean vertical;
        for (int i = 0; i < size ; i++) {
           horizontal =true;
           vertical = true;
            for (int j = 0; j < size ; j++) {
                horizontal = horizontal&(map[i][j].getIcon().equals(icon));
                vertical = vertical&(map[j][i].getIcon().equals(icon));
                if(horizontal || vertical) return true;
            }
        }
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                diagonal1 = diagonal1&(map[i][i].getIcon().equals(icon));
                diagonal2 = diagonal2&(map[i][size - i - 1].getIcon().equals(icon));
                if(diagonal1 || diagonal2) return true;
            }
        }
        return false;
    }

    private JMenu createFileMenu(){ 
        JMenu file = new JMenu("Файл");
        JMenuItem newGame = new JMenuItem("Новая игра");
        newGame.addActionListener(e ->  {
            new MainGameField();
            this.dispose();
        });
        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(e ->  {
            dispose();
        });
        file.add(newGame);
        file.addSeparator();
        file.add(exit);
        return file;
    }


    public static void main(String[] args) {
        MainGameField gameField = new MainGameField();
    }
}


public abstract class Gamer {

    protected ImageIcon icon;

    public Gamer(ImageIcon icon) {
        this.icon = icon;
    }

    abstract void gamerTurn (int x, int y);
    abstract boolean win();
}


public class HumanPlayer extends Gamer {

    MainGameField gameField;

    public HumanPlayer(ImageIcon icon) {
        super(icon);
    }

    @Override
    void gamerTurn(int x, int y) {
        gameField = MainGameField.getInstance();
        if (!gameField.isCellBusy(x, y)) {
            gameField.map[x][y].setIcon(icon);
        }
    }

    boolean win() {
        gameField = MainGameField.getInstance();
        return gameField.checkWin(this.icon);
    }
}


public class AI extends Gamer {

    MainGameField gameField;

    public AI(ImageIcon icon) {
        super(icon);
    }

    @Override
    void gamerTurn(int x, int y) {
        gameField = MainGameField.getInstance();
        do {
            Random rnd = new Random();
            x = rnd.nextInt(3);
            y = rnd.nextInt(3);
        }
        while (gameField.isCellBusy(x, y));
        gameField.map[x][y].setIcon(icon);
    }

    boolean win() {
        gameField = MainGameField.getInstance();
        return gameField.checkWin(this.icon);
    }
}


