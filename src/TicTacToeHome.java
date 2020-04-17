import java.util.Random;
import java.util.Scanner;

public class TicTacToeHome {
    private static final int SIZE = 3;      //Размер поля
    private static final boolean SILLY_MODE = false;
    private static final boolean SCORING = true;
    private static final char DOT_EMPTY = '•'; //Пустой символ(свободное поле)
    private static final char DOT_X = 'X'; //Крестик
    private static final char DOT_O = 'O'; //Нолик
    private static char[][] map;            //Поле игры
    private static Scanner scanner = new Scanner(System.in); //Считивание ходов
    private static Random random = new Random(); //Генерация случайных числе

    public static void main(String[] args) {

    }

    public static boolean checkWin() {
        boolean result = false;
        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }
        return result;
    }

    private static boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight, rightLeft, result;

        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < SIZE; i++) {
            leftRight &= (map[i][i] == playerSymbol);
            rightLeft &= (map[SIZE - i - 1][i] == playerSymbol);
        }
        if (leftRight || rightLeft) {
            result = true;
        }
        return result;
    }

    private static boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;
        for (int col = 0; col < SIZE; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < SIZE; row++) {
                cols &= (map[col][row] == playerSymbol);
                rows &= (map[row][col] == playerSymbol);
            }
            if (cols || rows) {
                result = true;
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    private static

    public static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    //пустая клетка найдена
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }
}
