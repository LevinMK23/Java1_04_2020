import java.util.Random;

public class Robot extends Abstract {
    GameField gameField;

    private final static char DOT_O = 'O';
    private static final Random rnd = new Random();

    public Robot(String sign) {
        this.sign = sign;
    }

    boolean shot(int x, int y) {
        gameField = GameField.getInstance();
        x = -1;
        y = -1;

        do {
            x = rnd.nextInt(gameField.size);
            y = rnd.nextInt(gameField.size);
        }
        while (gameField.isCellValid(x, y));
        gameField.map[x][y] = sign;
        return true;
    }

    boolean win() {
        gameField = GameField.getInstance();
        return gameField.checkWin(DOT_O);
    }

}
