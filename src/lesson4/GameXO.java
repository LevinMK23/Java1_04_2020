package lesson4;

import java.util.Random;
import java.util.Scanner;

public class GameXO {

    enum Type {
        X, O, DEFAULT
    }

    private static final Random rnd = new Random();
    private final static Type empty = Type.DEFAULT;
    private static int steps = 0;

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
        map[x][y] = DOT_X;
        steps++;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dot) {
        int size = map.length;
        for (int i = 0; i < size; i++) {
            boolean xf = true, yf = true, d1 = true, d2 = true;
            for (int j = 0; j < size; j++) {
                xf &= (map[i][j] == dot);
                yf &= (map[j][i] == dot);
                d1 &= (map[j][j] == dot);
                d2 &= (map[j][size - j - 1] == dot);
            }
            if (xf || yf || d1 || d2) return true;
        }
        return false;
    }

    private static void robotTurn(char[][] map) {
        int size = map.length, tx = 0, ty = 0;
        do {
            System.out.print("*");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tx =  1 + rnd.nextInt(size); // [0; size-1]
            ty = 1 + rnd.nextInt(size);
        } while (!isCellValid(map, tx, ty));
        map[tx][ty] = DOT_O;
        System.out.println();
        steps++;
    }

    public static void main(String[] args) {
        char [][] map = getInitMap(3);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);

        while (true) { // *
            System.out.println("Ваш ход:");
            int x, y;
            try {
                x = in.nextInt(); // может быть ошибка
                System.out.println("1");
                y = in.nextInt(); // может быть ошибка
                System.out.println("2");
                x--;
                y--;
            } catch (Exception e) {
                System.err.println("Введены некорректные данные");
                in = new Scanner(System.in);
                continue;
            }

            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                // TODO: 14.04.2020 отследить ничью
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    return;
                }
                System.out.println("Ход компьютера:");
                // if exists step
                if (steps == 9) {
                    System.out.println("Ничья!");
                    return;
                }
                robotTurn(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    return;
                }
                printMap(map);
            } else {
                System.out.println("Введены некорректные данные! Введите еще раз");
                // TODO: 14.04.2020 user friendly help comments
            }
        }
    }

}
