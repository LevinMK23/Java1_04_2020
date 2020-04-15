package lesson4;

import java.util.Scanner;

public class GameXO {

    enum Type {
        X, O, DEFAULT
    }

    private final static Type empty = Type.DEFAULT;

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    public static char[][] getInitMap(int size) {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        return map;
    }

    public static void printMap(char [][] map) {
        int size = map.length;
        for (char[] chars : map) {
            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
        }
    }

    public static void humanTurn(char [][] map, int x, int y) {
        x--; y--;
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        x--; y--;
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dotX) {
        // TODO: 14.04.2020
        // dotX dotX dotX
        // dotX dotX
        // dotX     dotX
        return false;
    }

    private static void robotTurn(char[][] map, int x, int y) {
        // TODO: 14.04.2020 random
        int size = map.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = DOT_O;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        char [][] map = getInitMap(3);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                // TODO: 14.04.2020 отследить ничью
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    // TODO: 14.04.2020 что делать дальше???
                }
                System.out.println("Ход компьютера:");
                robotTurn(map, x, y);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    // TODO: 14.04.2020 что делать дальше???
                }
                printMap(map);
            } else {
                System.out.println("Введены некорректные данные! Введите еще раз");
                // TODO: 14.04.2020 user friendly help comments
            }
        }
    }

}
