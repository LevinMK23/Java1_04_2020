package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public final static char EMPTY = '_';
    public final static char DOT_X = 'X';
    public final static char DOT_O = 'O';
    public static Scanner in = new Scanner(System.in);
    public static Random rnd = new Random();
    public static int turns = 0;

    //Инициализация пустой доски
    public static char[][] getInitMap(int size) {
        char[][] map = new char[size][size];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                map[i][j] = EMPTY;
        return map;
    }

    //Перерисовка доски
    public static void printMap(char[][] map) {
        System.out.print(" ");
        for (int i = 0; i < map.length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < map.length; j++)
                System.out.print("|" + map[i][j]);
            System.out.println("|");
        }
    }

    //Проверяем можно ли вставку в выбранную ячейку сделать
    public static boolean isCellValid(char[][] map, int x, int y) {
        if ((x >= map.length) || (y >= map.length) || x < 0 || y < 0) return false;
        return map[x][y] == EMPTY;
    }

    //Ход человека
    public static boolean humanTurn(char[][] map) {
        int x, y;
        do {
            System.out.println("Ваш ход.");
            System.out.printf("Введите координаты x(1-%d), y(1-%d) или -1, чтобы завершить", map.length, map.length);
            System.out.println();
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
            if ((x == -2) || (y == -2)) return false;
        } while (!isCellValid(map, x, y));
        map[x][y] = DOT_X;
        turns++;
        return true;
    }

    //Ход компьютера
    public static void robotTurn(char[][] map) {
        int x, y;
        do {
            x = rnd.nextInt(map.length);
            y = rnd.nextInt(map.length);
        } while (!isCellValid(map, x, y));
        turns++;
        map[x][y] = DOT_O;
    }

    //Проверка на победу по символу
    public static boolean checkVictory(char[][] map, char sym) {
        int size = map.length;
        for (int i = 0; i < size; i++) {
            int xc, yc;
            int[] dc = new int[6];
            xc = yc = 0;
            for (int j = 0; j < size; j++) {
                xc = (map[i][j] == sym) ? ++xc : 0;
                yc = (map[j][i] == sym) ? ++yc : 0;
                dc[0] = (map[j][j] == sym) ? ++dc[0] : 0;
                dc[1] = (map[j][size - j - 1]) == sym ? ++dc[1] : 0;
                if (j > 0) {
                    dc[2] = (map[j][j - 1]) == sym ? ++dc[2] : 0;
                    dc[3] = (map[j][size - j]) == sym ? ++dc[3] : 0;
                }
                if (j < size - 1) {
                    dc[4] = (map[j][j + 1]) == sym ? ++dc[4] : 0;
                    dc[5] = (map[j][size - j - 2]) == sym ? ++dc[5] : 0;
                }
                if ((xc >= 4) || (yc >= 4) || (Arrays.binarySearch(dc, 4) >= 0)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 5;
        char[][] map = getInitMap(size);
        System.out.println("Start game!");
        //Ограничим число ходов размером карты
        while (true) {
            printMap(map);
            //Ход игрока
            if (!humanTurn(map)) return;
            if (checkVictory(map, DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }
            if (turns == size * size) {
                System.out.println("Ничья");
                break;
            }
            //Ход машины
            robotTurn(map);
            if (checkVictory(map, DOT_O)) {
                System.out.println("Победила машина!");
                break;
            }
            if (turns == size * size) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Game over");
    }
}
