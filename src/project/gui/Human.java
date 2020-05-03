public class Human extends Abstract {
    GameField gameField;

private final static char DOT_X = 'X';

    public Human(String sign) {
        this.sign = sign;
    }

    boolean shot(int x, int y) {
        gameField = GameField.getInstance();
        if (!gameField.isCellValid(x, y)) {
            gameField.map[x][y] = sign;
            return true;
        }
        return false;
    }

    boolean win() {
        gameField = GameField.getInstance();
        return gameField.checkWin(DOT_X);
    }

}
