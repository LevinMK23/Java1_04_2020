package lesson4;

import java.util.*;

public class TicTacToe {

    enum Type {
        X, O, DEFAULT
    }

    private static int cells = 3;
    private static char[][] map;
    private final static Type empty = Type.DEFAULT;
    private static Random random = new Random();
    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    public static char[][] getInitMap(int size) {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        return map;
    }

    public static void printMap(char [][] map) {
        int size = map.length;
        int row = 1;
        int col;
        for (int i = 0; i < size; i++) {
            col = i + 1;
            if (i == 0) {
                System.out.print("   " + col);
            } else {
                System.out.print(" " + col);
            }
        }
        System.out.println();
        for (char[] chars : map) {
            System.out.print(row + " ");
            row++;
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

    private static boolean isCellValid(int x, int y) {
        x--; y--;
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            if (map[x][y] == EMPTY) {
                return map[x][y] == EMPTY;
            }
        }
        return false;
    }

    private static boolean isRandomCellValid(int x, int y) {
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            if (map[x][y] == EMPTY) {
                return map[x][y] == EMPTY;
            }
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dot) {
        // 14.04.2020
        /*
        for (int i = 0; i < cells; i++) {
            boolean xf = true, yf = true, d1 = true, d2 = true;
            for (int j = 0; j < cells; j++) {
                xf &= (map[i][j] == dot);
                yf &= (map[j][i] == dot);
                d1 &= map[i][i] == dot;
                d2 &= map[i][cells - i - 1] == dot;
            }
            if (xf || yf || d1 || d2) return true;
        }
        */
        // dotX dotX dotX
        // dotX dotX
        // dotX     dotX
        return (checkRowsVictory() || checkColumnsVictory() || checkDiagonalsVictory());
    }

    private static boolean checkRowsVictory() {
        for (int i = 0; i < cells; i++) {
            if (checkRowCol(map[i][0], map[i][1], map[i][2])) return true;
        }
        return false;
    }

    private static boolean checkColumnsVictory() {
        for (int i = 0; i < cells; i++) {
            if (checkRowCol(map[0][i], map[1][i], map[2][i])) return true;
        }
        return false;
    }

    private static boolean checkDiagonalsVictory() {
        return checkRowCol(map[0][0], map[1][1], map[2][2]) || checkRowCol(map[0][2], map[1][1], map[2][0]);
    }

    private static boolean checkRowCol(char col1, char col2, char col3) {
        return ((col1 != EMPTY) && (col1 == col2) && (col2 == col3));
    }

    public static boolean isThereAnotherWay() {
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                if (map[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    private static void doRandom() {
        // 14.04.2020 random
        int size = map.length;
        int celX, celY;
        do {
            /*
            System.out.println("*");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            celX = random.nextInt(size);
            celY = random.nextInt(size);
        } while (!isRandomCellValid(celX, celY) && map[celX][celY] != EMPTY);
        map[celX][celY] = DOT_O;
        System.out.println("Computer turn (2): " + (++celX) + " " + (++celY));
    }

    private static void robotTurn() {
        // 14.04.2020 random
        // simple AI
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (isRandomCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkVictory(map, DOT_O) || checkVictory(map, DOT_X)) {
                        return;
                    }
                    map[i][j] = EMPTY;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (isRandomCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkVictory(map, DOT_O) || checkVictory(map, DOT_X)) {
                        map[i][j] = DOT_O;
                        System.out.println("Computer turn (1): " + ++i + " " + ++j);
                        return;
                    }
                    map[i][j] = EMPTY;
                }
            }
        }
        doRandom();
    }

    public static void main(String[] args) {
        map = getInitMap(cells);
        System.out.println("Welcome to the game Tic-Tac-Toe");
        System.out.println("Here is a board:");
        printMap(map);
        System.out.println("You play by Crosses!");
        System.out.println("To make a move, enter the row and column number:");
        Scanner in = new Scanner(System.in);

        while (true) {
            //int x = in.nextInt(), y = in.nextInt();//with this line we can get an error
            //changing line above
            System.out.println("Your turn:");
            int x, y;
            try {
                x = in.nextInt();
                //System.out.println("1");
                y = in.nextInt();
                //System.out.println("2");
            } catch (Exception e) {
                System.err.println("Incorrect details");
                in = new Scanner(System.in);
                continue;
            }

            if (isCellValid(x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_X)) {
                    System.out.println("You win");
                    // 14.04.2020 что делать дальше???
                    return;
                }
                // 14.04.2020 отследить ничью
                if(isThereAnotherWay()) {
                    printMap(map);
                    System.out.println("It's a draw!");
                    return;
                }
                robotTurn();
                printMap(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("GAME OVER\nComputer win");
                    // 14.04.2020 что делать дальше???
                    return;
                }
            } else {
                // 14.04.2020 user friendly help comments
                if (!(x > 0 && y > 0 && x <= map.length && y <= map.length)) {
                    System.out.println("Incorrect details. Please, re-enter slot number");
                } else if (x != EMPTY || y != EMPTY) {
                    System.out.println("This slot already taken. Please, re-enter slot number");
                }
            }
        }
    }

}
