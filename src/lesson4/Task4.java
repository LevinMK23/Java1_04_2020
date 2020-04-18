package lesson4;


import java.util.Random;
import java.util.Scanner;

public class Task4 {
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static int SIZE = 3;
    private static int DOTS_TO_WIN = 3;
    private static char[][] map;


    public static void main(String[] args) {
        gameInit();
    }

    private static void setGameParam() {
        System.out.println("Игра крестики - нолики");
        int size = 3, dots_to_win = 3;
        System.out.printf("Текущий размер поля %d на %d. Количество точек для победы: %d. Задайте свои значения (не меньше чем 3). ", SIZE, SIZE, DOTS_TO_WIN);
        System.out.println("Введите размер поля(не меньше 3): ");
        size = sc.nextInt();
        if (size < 3) {
            System.out.println("Неверный размер поля!");
            setGameParam();
        }
        System.out.println("Введите количество точек для победы(не меньше 3, не больше размера поля): ");
        dots_to_win = sc.nextInt();
        if (dots_to_win < 3 && dots_to_win >= size) {
            System.out.println("Неверно заданно количество точек для победы!");
            setGameParam();
        }
        SIZE = size;
        DOTS_TO_WIN = dots_to_win;
    }


    private static void initializationGameMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (char[] chars : map) {
            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
        }
    }

    public static Scanner sc = new Scanner(System.in);

    private static void playerTurn() {
        int x = 0, y = 0, attemptingToEnterCorrectValue = 0;
        do {
            attemptingToEnterCorrectValue++;
            if (attemptingToEnterCorrectValue >= 5 && attemptingToEnterCorrectValue < 7)
                System.out.print("У Вас получится, пример ввода: 2 2. ");
            if (attemptingToEnterCorrectValue >= 7 && attemptingToEnterCorrectValue < 9)
                System.out.print("У Вас наблюдаются явные проблемы с вводом значений. Значения должны быть от 0 до " + SIZE + ". ");
            if (attemptingToEnterCorrectValue == 9) {
                System.out.println("Ну это не смешно, мне придется сделать ход за Вас.");
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
                System.out.println("Пожалуй схожу в x = " + (x + 1) + " y = " + (y + 1));
            } else {
                System.out.println("Введите координаты в формате X(столбец) Y(строка): ");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            }
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    private static Random rand = new Random();

    private static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.printf("Компьютер сделал свой ход в точку %d %d\n", x + 1, y + 1);
        map[y][x] = DOT_O;
    }

    private static boolean checkWin(char symb) {
        return checkWinHorizontal(symb) || checkWinVertical(symb) || checkWinDiagonal(symb) || checkWinDiagonalReverse(symb);
    }

    private static boolean checkWinHorizontal(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[i][j] == symb && map[i][j + 1] == symb) {
                    count++;
                    if (count == DOTS_TO_WIN - 1) return true;
                } else count = 0;
            }
        }
        return false;
    }

    private static boolean checkWinVertical(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[j][i] == symb && map[j + 1][i] == symb) {
                    count++;
                    if (count == DOTS_TO_WIN - 1) return true;
                } else count = 0;
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal(char symb) {
        for (int i = 0; i < SIZE - (DOTS_TO_WIN - 1); i++) {
            for (int j = 0; j < SIZE - (DOTS_TO_WIN - 1); j++) {
                int count = 0;
                for (int k = 0; k < DOTS_TO_WIN - 1; k++) {
                    if (map[i + k][j + k] == symb && map[i + k + 1][j + k + 1] == symb) {
                        count++;
                        if (count == DOTS_TO_WIN - 1) return true;
                    } else count = 0;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonalReverse(char symb) {
        for (int i = SIZE - 1; i >= SIZE - (DOTS_TO_WIN + 1); i--) {
            int count = 0;
            for (int j = 0; j < SIZE - (DOTS_TO_WIN - 1); j++) {
                for (int k = 0; k < DOTS_TO_WIN - 1; k++) {
                    if (map[i - k][j + k] == symb && map[i - 1 - k][j + (k + 1)] == symb) {
                        count++;
                        if (count == DOTS_TO_WIN - 1) return true;
                    } else count = 0;
                }
            }
        }

        return false;
    }


    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void gameInit() {
        setGameParam();
        initializationGameMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искусственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
}
