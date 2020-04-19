package lesson4.homework;

import java.util.Scanner;

public class XO {
    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    public static void getInitMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    public static void printMap(char[][] map) {
        int size = map.length;
        System.out.print(" ");
        for (int i = 0; i < size ; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < size; j++) {
                System.out.print("|" + map[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void humanTurn(char[][] map, int[] xy) {
        map[xy[0]][xy[1]] = DOT_X;
    }

    private static boolean isCellValid(char[][] map, int[] xy) {
        xy[0]--; xy[1]--;
        int size = map.length;
        if (xy[0] >= 0 && xy[0] < size && xy[1] >= 0 && xy[1] < size) {
            return map[xy[0]][xy[1]] == EMPTY;
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dot, int [] xy, int victorySize) {
        int lineLength = 0;
        int mapSize = map.length;
        //Проверка по горизонтали
        for (int i = 0; i < mapSize; i++) {
            if(map[xy[0]][i] == dot){
                lineLength++;
            }
            else{
                lineLength = 0;
            }
            if (lineLength == victorySize){
                return true;
            }
        }
        //Проверка по вертикали
        lineLength = 0;
        for (int i = 0; i < mapSize; i++) {
            if(map[i][xy[1]] == dot){lineLength++;}
            else{lineLength = 0;}
            if (lineLength == victorySize){return true;}
        }
        //Проверка по диагонали 1
        lineLength = 0;
        int step = 1;
        int row = xy[0];
        int column = xy[1];
        while (row >= 0 && column >= 0) {
            if(map[row][column] == dot){lineLength++;}
            else{lineLength = 0;}
            row+=step;
            column+=step;
            if(row == mapSize || column == mapSize){
                row = xy[0] - 1;
                column = xy[1] - 1;
                step = -1;
            }
            if(lineLength == victorySize){return true;}
        }
        //Проверка по диагонали 2
        lineLength = 0;
        step = 1;
        row = xy[0];
        column = xy[1];
        while (row >= 0 && column < mapSize) {
            if(map[row][column] == dot){lineLength++;}
            else{lineLength = 0;}
            row-=step;
            column+=step;
            if(row == mapSize || column < 0){
                row = xy[0] + 1;
                column = xy[1] - 1;
                step = -1;
            }
            if(lineLength == victorySize){return true;}
        }
        // TODO: 14.04.2020
        // dotX dotX dotX
        // dotX dotX
        // dotX     dotX

        return false;
    }

    private static void robotTurn(char[][] map, int[] xy) {
        // TODO: 14.04.2020 random
        int size = map.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = DOT_O;
                    xy[0] = i;
                    xy[1] = j;
                    return;
                }
            }
        }
    }

    private static boolean gameOver(Scanner in){
        System.out.println("Чтобы начать новую игру, введите 1");
        System.out.println("Чтобы выйти из игры, введите любое число");
        int answer = in.nextInt();
        if(answer == 1){return false;}
        return  true;
    }

    public static void main(String[] args) {
        int mapSize = 5;
        int victorySize = 4;
        char [][] map = new char[mapSize][mapSize];
        getInitMap(map);
        int[] xy = {0, 0};
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);
        while (true) {
            printMap(map);
            System.out.println("Ваш ход:");
            xy[0] = in.nextInt();
            xy[1] = in.nextInt();
            if (isCellValid(map, xy)) {
                humanTurn(map, xy);
                printMap(map);
                // TODO: 14.04.2020 отследить ничью
                if (checkVictory(map, DOT_X, xy, victorySize)) {
                    System.out.println("Вы победили");
                    if(gameOver(in)){break;}
                    getInitMap(map);
                    continue;
                }
                System.out.println("Ход компьютера:");
                robotTurn(map, xy);
                printMap(map);
                if (checkVictory(map, DOT_O, xy, victorySize)) {
                    System.out.println("Вы проиграли");
                    if(gameOver(in)){break;}
                    getInitMap(map);
                }
            } else {
                System.out.println("Введены некорректные данные! Введите еще раз");
                // TODO: 14.04.2020 user friendly help comments
            }
        }
    }
}
