package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameXO {


    enum Type {
        X, O, DEFAULT
    }

    private final static Type empty = Type.DEFAULT;

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private final static Scanner in = new Scanner(System.in);


    public static char[][] getInitMap(int size) {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        return map;
    }

    public static void printMap(char[][] map) {
        int size = map.length;
        for (char[] chars : map) {
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
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        x--;
        y--;
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
        int size = map.length;
        for (int i = 0; i < size; i++) {
            if ((map[i][0] == dotX && map[i][1] == dotX && map[i][2] == dotX) ||
                    (map[0][i] == dotX && map[1][i] == dotX && map[2][i] == dotX))
                return true;
            if ((map[0][0] == dotX && map[1][1] == dotX && map[2][2] == dotX) ||
                    (map[2][0] == dotX && map[1][1] == dotX && map[0][2] == dotX))
                return true;

        }
        return false;
    }

    private static void robotTurn(char[][] map, int x, int y) {
        // TODO: 14.04.2020 random
        Random random = new Random();
        while (true) {
            x = random.nextInt(3);
            y = random.nextInt(3);
            if (map[x][y] == EMPTY) {
                map[x][y] = DOT_O;
                break;
            }
        }


//        int size = map.length;
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (map[i][j] == EMPTY) {
//                    map[i][j] = DOT_O;
//                    return;
//                }
//            }
//        }
    }

    private static boolean isMapFull(char[][] map) {
        int size = map.length;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j] == EMPTY)
                    return false;
        return true;
    }

    public static void choice(char[][] map) {
        System.out.println("Новая игра: 1");
        System.out.println("Выход: 2");
        String command = in.next();
        switch (command) {
            case "1":
                System.out.println("Новая игра");
                map = getInitMap(3);
                game(map);
            case "2":
                System.exit(2); /// Как сделать что-бы завеершал цикл while в game?
        }

    }

    public static void game(char[][] map) {
        int p = 0;
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
//        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                // TODO: 14.04.2020 отследить ничью
                if (isMapFull(map)) {
                    System.out.println("Ничья");
                    choice(map);
//                    System.out.println("Новая игра: 1");
//                    System.out.println("Выход: 2");
//                    String command = in.next();
//                    switch (command) {
//                        case "1":
//                            System.out.println("Новая игра");
//                            map = getInitMap(3);
//                            game(map);
//                        case "2":
//                            return;
//                    }
                }
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    choice(map);
//                    System.out.println("Новая игра: 1");
//                    System.out.println("Выход: 2");
//                    String command = in.next();
//                    switch (command) {
//                        case "1":
//                            System.out.println("Новая игра");
//                            map = getInitMap(3);
//                            game(map);
//                        case "2":
//                            return;
//                    }
                    // TODO: 14.04.2020 что делать дальше???
                }
                System.out.println("Ход компьютера:");
                robotTurn(map, x, y);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    // TODO: 14.04.2020 что делать дальше???
                    choice(map);
                    printMap(map);
                }
                printMap(map);
            } else {
                System.out.println("Вы вели не коректные данные столбца и строки! Введите еще раз");
                System.out.println("Либо я чека занята");
                // TODO: 14.04.2020 user friendly help comments
                int size = map.length;
                p++;
                if (p == 5) {
                    System.out.println("Кол-во столбцов " + size);
                    System.out.println("Кол-во строк " + size);
                    p = 0;
                }

            }
        }

    }


    public static void main(String[] args) {
        char[][] map = getInitMap(3);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        game(map);
//        System.out.println("Перед вами поле:");
//        printMap(map);
//        System.out.println("Вы играете Крестиками!");
//        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            System.out.println("Ваш ход:");
//            int x = in.nextInt(), y = in.nextInt();
//            if (isCellValid(map, x, y)) {
//                humanTurn(map, x, y);
//                printMap(map);
//                // TODO: 14.04.2020 отследить ничью
//                if (isMapFull(map)){
//                    System.out.println("Ничья");
//                };
//                if (checkVictory(map, DOT_X)) {
//                    System.out.println("Вы победили");
//                    System.out.println("Новая игра: 1");
//                    System.out.println("Выход: 2");
//                   String command = in.next();
//                   switch (command) {
//                       case "1":
//                           System.out.println("Новая игра");
////                           Arrays.fill(map,'_');
//
//                           continue;
//                       case "2":
//                           return;
//                   }
//                    // TODO: 14.04.2020 что делать дальше???
//                }
//                System.out.println("Ход компьютера:");
//                robotTurn(map, x, y);
//                if (checkVictory(map, DOT_O)) {
//                    System.out.println("Вы проиграли");
//                    // TODO: 14.04.2020 что делать дальше???
//                }
//                printMap(map);
//            } else {
//                System.out.println("Введены некорректные данные! Введите еще раз");
//                // TODO: 14.04.2020 user friendly help comments
//            }
//        }
    }

}
