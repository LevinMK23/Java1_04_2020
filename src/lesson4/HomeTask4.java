package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HomeTask4 {

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private final static int TO_WIN = 4;
    private final static int SIZE_Y = 5;
    private final static int SIZE_X = 5;


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
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1));
            for (int j = 0; j < size; j++) {
                System.out.print("|" + map[i][j]);
            }
            System.out.println("|");
        }
        System.out.println();
    }

    public static void humanTurn(char[][] map, int x, int y) {
        x--;
        y--;
        map[x][y] = DOT_X;

    }

    public static boolean isCellValid(char[][] map, int x, int y) {
        x--;
        y--;
        int size = map.length;
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (map[y][x] == EMPTY) return true;
        if (map[y][x] == DOT_X) return false;
        if (map[y][x] == DOT_O) return false;
        return false;
    }

    public static boolean isMapFull(char[][] map) {
        for (char[] chars : map)
            for (int j = 0; j < map.length; j++)
                if (chars[j] == EMPTY)
                    return false;
        return true;
    }

    private static boolean checkVictory(char[][] map, char dot) {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length - 1; j++) {
                if ((map[j][i] != dot) || (map[j + 1][i] != map[j][i])) {
                    break;
                } else if (j == map.length - 2) return true;
            }
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length - 1; j++) {
                if ((map[i][j] != dot) || (map[i][j + 1] != map[i][j])) {
                    break;
                } else if (j == map.length - 2) return true;
            }
        }

        for (int i = 1; i < map.length - 1; i++) {
            if ((map[i][i] != dot) || (map[i + 1][i + 1] != map[i][i])) {
                break;
            } else if (i == map.length - 2) return true;
        }
        for (int i = 1, j = map.length - 1; j > 1; i++, j--) {
            if ((map[i][j] != dot) || (map[i + 1][j - 1] != map[i][j])) {
                break;
            } else if (i == map.length - 2) return true;

        }
        return false;
    }

    private static void robotTurn(char[][] map, int x, int y) {
        Random random = new Random();
        int size = map.length;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isCellValid(map, x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void main(String[] args) throws IOException {
        char[][] map = getInitMap(5);
        System.out.println("Приветствую вас в игре Крестики-Нолики!");
        System.out.println("Перед вами поле");
        printMap(map);
        System.out.println("Вы играете Крестиками");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Ваш ход:");
            int x = Integer.parseInt(reader.readLine()), y = Integer.parseInt(reader.readLine());
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили!!!");
                    break;
                }
                System.out.println("Ход компьютера:");
                if (isCellValid(map, x, y)) {
                    robotTurn(map, x, y);
                    printMap(map);
                    if (checkVictory(map, DOT_O)) {
                        System.out.println("Победил компьютер!!!");
                        break;
                    }
                    if (isMapFull(map)) System.out.println("Ничья!!!");

                } else {
                    System.out.println("По данным координатам нет свободной ячейки.\n" +
                            "Введите координаты: Y (от 1 до " + SIZE_Y + ")   X  (от 1 до " + SIZE_X + ")");
                }
            }
        } while (true);
    }
}



        





