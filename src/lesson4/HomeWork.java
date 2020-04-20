package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private static int winLength; // Quantity of chars in lane to win

    private static Scanner scanner;
    private static Random random;
    private static int mapSize;
    private static char[][] map;

    public static void main(String[] args) {
        game();
    }

    private static void game() {

        scanner = new Scanner(System.in);
        random = new Random();

        System.out.println("Приветствую вас в игре Крестики Нолики!");
        setMapSize();
        setWinLength();
        initMap();

        System.out.println("Перед вами поле:");
        printMap();

        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");

        while (true) {
            if (!nextRound()) break;
        }

        System.out.println("Новая игра - game, Выход - exit");
        switch (scanner.next()) {
            case "game":
                game();
            case "exit":
                return;
            default:
        }
    }

    private static boolean nextRound() {

        humanTurn();
        printMap();
        if (checkVictory(DOT_X)) {
            System.out.println("Вы победили");
            return false;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            return false;
        }

        robotTurn();
        printMap();
        if (checkVictory(DOT_O)) {
            System.out.println("Вы проиграли");
            return false;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            return false;
        }

        return true;
    }

    private static void setWinLength() {
        do {
            System.out.println("Введите желаемое количество символов до победы");
            System.out.println("Значение не может быть больше размера поля и меньше 2");
            winLength = scanner.nextInt();
        } while (winLength < 2 || winLength > mapSize);
    }

    private static void setMapSize() {
        do {
            System.out.println("Выберите размер поля от 3 до 10 (X:X):");
            mapSize = scanner.nextInt();
        } while (mapSize < 3 || mapSize > 10);
    }

    public static void initMap() {
        map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    public static void printMap() {
        for (char[] chars : map) {
            for (char symbol : chars) {
                System.out.print("|" + symbol);
            }
            System.out.println("|");
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellNotValid(x, y));

        map[y][x] = DOT_X;
    }

    private static void robotTurn() {
        int x, y;
        System.out.println("Ход компьютера:");
        do {
            x = random.nextInt(mapSize);
            y = random.nextInt(mapSize);
        } while (isCellNotValid(x, y));

        map[y][x] = DOT_O;
    }

    private static boolean isCellNotValid(int x, int y) {
        if (x < 0 || x >= mapSize || y < 0 || y >= mapSize) return true;
        return map[y][x] != EMPTY;
    }

    static boolean isMapFull() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkVictory(char symbol) {
        for (int col = 0; col <= mapSize - winLength; col++) {
            for (int row = 0; row < mapSize - winLength; row++) {
                if (checkDiagonal(symbol, col, row) || checkLanes(symbol, col, row)) return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal(char symbol, int offsetX, int offsetY) {
        boolean toRight, toLeft;
        toRight = true;
        toLeft = true;

        for (int i = 0; i < winLength; i++) {
            toRight &= (map[i + offsetX][i + offsetY] == symbol);
            toLeft &= (map[winLength - i - 1 + offsetX][i + offsetY] == symbol);
        }

        return toRight || toLeft;
    }

    private static boolean checkLanes(char symbol, int offsetX, int offsetY) {

        boolean cols, rows;
        for (int col = offsetX; col < winLength + offsetX; col++) {
            cols = true;
            rows = true;
            for (int row = offsetY; row < winLength + offsetY; row++) {
                cols &= (map[col][row] == symbol);
                rows &= (map[row][col] == symbol);
            }

            if (cols || rows) return true;
        }

        return false;
    }
}
