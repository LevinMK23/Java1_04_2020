package lesson4;

import java.util.Scanner;

public class HomeWorkLesson4 {
    static int tryCount;
    static int size;

    enum Type {
        X, O, DEFAULT
    }

    private final static Type empty = Type.DEFAULT;

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    public static char[][] getInitMap(int size) {
        char[][] map = new char[size][size];
        tryCount = size * size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        return map;
    }

    public static void printMap(char[][] map) {

        for (int i = 0; i < size; i++) {
            System.out.print((i == 0 ? "   " : " ") + (i + 1));
        }

        System.out.println();
        int count = 0;
        for (char[] chars : map) {
            System.out.print(++count + " ");
            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
        }
    }

    public static void humanTurn(char[][] map, int x, int y) {
        x--;
        y--;
        map[x][y] = DOT_X;
        tryCount--;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        x--;
        y--;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dot) {

        boolean d1 = true, d2 = true;

        for (int i = 0; i < size; i++) {
            //вертикаль, горизонталь
            boolean n1 = true, n2 = true;
            for (int j = 0; j < size; j++) {
                n1 &= (map[i][j] == dot);
                n2 &= (map[j][i] == dot);
            }
            if (n1 || n2) return true;

            //диагонали
            d1 &= (map[i][i] == dot);
            d2 &= (map[size - 1 - i][i] == dot);
        }
        return d1 || d2;
    }

    private static void robotTurn(char[][] map) {
        // TODO: 14.04.2020 random
        while (true) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            if (isCellValid(map, x + 1, y + 1)) {
                map[x][y] = DOT_O;
                tryCount--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Введите размер поля!");
        size = in.nextInt();
        char[][] map = getInitMap(size);
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");

        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            if (isCellValid(map, x, y)) {
                if (tryCount == 0) {
                    System.out.println("Ничья");
                    break;
                }
                humanTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    printMap(map);
                    break;
                }
                if (tryCount == 0) {
                    System.out.println("Ничья");
                    break;
                }
                System.out.println("Ход компьютера:");
                robotTurn(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    printMap(map);
                    break;
                }
                printMap(map);
            } else {
                printMap(map);
                System.out.println("Введены некорректные данные! Введите еще раз");
            }
        }
        System.out.println("Еще одна игра? 1 - да");
        String s[] = new String[0];
        try {
            if (in.nextInt() == 1) {
                main(s);
            }
        } catch (Exception e) {
        }
    }
}
