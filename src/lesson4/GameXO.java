package Lesson4_HW4;

import java.util.Random;
import java.util.Scanner;

public class GameTicTacToeHW4 {
    // настройки игры
    private static char[][] map; // поле игры
    private static final int SIZE = 3;

    private final static char EMPTY = '_';      // пустое поле
    private final static char DOT_X = 'X';      // кретики
    private static char DOT_O = 'O';            // нолики

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        intMap();
        printMap();

        while (true) {
            humanTurn();     // ход игрока
            if (isEndGame(DOT_X)) {
                break;
            }

            computerTurn();
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра окончена!");
    }

    // логика игры
    private static void intMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    // игровая логика
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {       // наш ход
        int x, y;
        do {
            System.out.println("Введите данные для хода - горизонталь - вертикаль через пробел.");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X; // y- вертикаль. x-горизонталь
    }

    private static void computerTurn() {        // ход компьютера
        int x = -1;
        int y = -1;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while(!isCellValid(x, y));
        System.out.println("Компьютер сделал ход в " + (y + 1) + " " + ( + 1));
        map[y][x] = DOT_O;

    }

    private static boolean isCellValid(int x, int y) {
        boolean result = true;


        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {      // проверка корректности координат
            result = false;
        }
        if (map[y][x] != EMPTY) {        // проверка заполнения данных (X/O)
            result = false;
        }
        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;
        printMap();

        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol + "-ики!");
            result = true;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {        // проверка заполняемости масива(полей игры)
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY) {
                    result = false;
                    break;
                }
            }

            if (!result) { // для поиска первой пустой клетки
                break;
            }
        }
        return result;
    }


    private static boolean checkWin(char playerSymbol) {
        boolean result = false;
        if (
        (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)){
            result = true;
        }
        return result;
    }
}
