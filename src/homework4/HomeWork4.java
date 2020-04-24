package homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    private static final Random rnd = new Random();
    private static Scanner scn = new Scanner(System.in);

    private static int turn = 0;
    private static char[][] map;

    private static final char CROSS = 'X';
    private static final char ZERO = '0';
    private static final char EMPTY = '_';

    private static final int matchCount = 4;

    public static void initMap(int n) {
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.print("|");

            for (int j = 0; j < map[1].length; j++) {
                System.out.printf("%c|", map[i][j]);
            }

            System.out.println();
        }
    }

    public static boolean isEmpty(int x, int y) {
        return map[y - 1][x - 1] == EMPTY;
    }

    public static void fillCell(int x, int y, char c) {
        map[y - 1][x - 1] = c;
    }

    public static void humanTurn() {
        int x, y;

        while (true) {
            while (true){
                System.out.println("Enter x coordinate");
                x = scn.nextInt();

                if (x < 1 || x > map.length) {
                    System.out.println("Invalid coordinate. It should be in range 1.." + map.length);
                    continue;
                } else {
                    break;
                }
            }

            while (true) {
                System.out.println("Enter y coordinate");
                y = scn.nextInt();

                if (y < 1 || y > map.length) {
                    System.out.println("Invalid coordinate. It should be in range 1.." + map.length);
                    continue;
                } else {
                    break;
                }
            }

            if (isEmpty(x, y)) {
                fillCell(x, y, CROSS);
                turn++;
                break;
            } else {
                System.out.println("The cell is already filled. Please re-enter coordinates");
                continue;
            }
        }
    }

    public static void pcTurn() {
        int x, y;

        while (true) {

            while (true){
                x = rnd.nextInt(map.length);

                if (x < 1 || x > map.length) {
                    continue;
                } else {
                    break;
                }
            }

            while (true) {
                y = rnd.nextInt(map[1].length);

                if (y < 1 || y > map[1].length) {
                    continue;
                } else {
                    break;
                }
            }

            if (isEmpty(x, y)) {
                fillCell(x, y, ZERO);
                turn++;
                break;
            } else {
                continue;
            }
        }
    }

    public static boolean isVictory(char symbol){
        for (int i = 0; i <= map.length - matchCount; i++) {
            for (int j = 0; j <= map.length - matchCount; j++) {
                for (int k = 0; k < matchCount; k++) {
                    boolean horizontalLine = true;
                    boolean verticalLine = true;
                    boolean diagonal1 = true;
                    boolean diagonal2 = true;
                    for (int l = 0; l < matchCount; l++) {
                        verticalLine &= (map[i + k][j + l] == symbol);
                        horizontalLine &= (map[i + l][j + k] == symbol);
                        diagonal1 &= (map[i + l][j + l] == symbol);
                        diagonal2 &= (map[i + l][j + matchCount - l - 1] == symbol);
                    }
                    if (horizontalLine || verticalLine || diagonal1 || diagonal2) {
                        System.out.println(symbol + " won the game");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isDraw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                if (map[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("Welcome to the game X-O");
            System.out.println("Your symbol is " + CROSS);

            initMap(5);
            printMap();

            while (true) {
                humanTurn();
                printMap();
                if (isVictory(CROSS) || isVictory(ZERO) || isDraw()) {
                    System.out.println("Restart?");
                    int answer = scn.nextInt();

                    if (answer == 1) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }

                System.out.println("PC Turn:");
                pcTurn();
                printMap();
                if (isVictory(CROSS) || isVictory(ZERO) || isDraw()) {
                    System.out.println("Restart?");
                    int answer = scn.nextInt();

                    if (answer == 1) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }

        }
    }
}
