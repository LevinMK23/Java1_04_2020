package lesson4;

import java.util.Random;
import java.util.Scanner;

public class GameXO_Home_work {


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

    public static void printMap(char[][] map) {
        int a = 0;
        int size = map.length;
        System.out.print("    1   2   3   4 ");
        System.out.println();
        for (char[] chars : map) {
            a++;
            System.out.print(a);
            for (char sym : chars) {
                System.out.print(" | " + sym);
            }
            System.out.println(" |");
        }
    }

    public static void humanTurn(char[][] map, int x, int y) {
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            if (map[x][y] == EMPTY) {
                return true;
            }
            else {
                System.out.println("Эта клетка поля занята, переходите");
            }
        }
        else {
            System.out.println("Вы вышли за пределы поля, переходите");
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char DOT) {
        int size = map.length;
        int counter = 0;

        for (int i = 0; i < size; i++) { // Блок для условия победы по диагонали слева напаво.
            if (map[i][i] == DOT) {
                counter++;
            }
        }
        if (counter == 4) {
            return true;
        }


        counter = 0;
        for (int i = 0; i < size; i++) { // Блок для условия победы по диагонали справа налево.
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT && i + j == (size - 1)) {
                    counter++;
                }
            }
        }
        if (counter == 4) {
            return true;
        }


        for (int j = 0; j < size; j++) { // Блок для условия победы по вертикали.
            counter = 0;
            for (int i = 0; i < size; i++) {
                if (map[i][j] == DOT) {
                    counter++;
                }
            }
            if (counter == 4) {
                return true;
            }
        }


        for (int i = 0; i < size; i++) { // Блок для условия победы по горизонтали.
            counter = 0;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT) {
                    counter++;
                }
            }
            if (counter == 4) {
                return true;
            }
        }


        return false;
    }


    private static void robotTurn(char[][] map) {
        int size = map.length;
        int x = 0;
        int y = 0;
        int counter_X = 0;
        int counterEmpty = 0;


        for (int i = 0; i < size; i++) { //Цикл для блокировки выиграшной комбинации игрока в 4 символа
            if (map[i][i] == DOT_X) {    //по диагонали слева направо.
                counter_X++;
            }
            if (map[i][i] == EMPTY) {
                counterEmpty++;
            }
        }
        if (counter_X == 3 && counterEmpty == 1) {
            for (int i = 0; i < size; i++) {
                if (map[i][i] == EMPTY) {
                    map[i][i] = DOT_O;
                    return;
                }
            }
        }


        counter_X = 0;
        counterEmpty = 0;
        for (int i = 0; i < size; i++) { //Цикл для блокировки выиграшной комбинации игрока в 4 символа
            for (int j = 0; j < size; j++) { //по диагонали спарва налево.
                if (map[i][j] == DOT_X && i + j == (size - 1)) {
                    counter_X++;
                }
                if (map[i][j] == EMPTY && i + j == (size - 1)) {
                    counterEmpty++;
                }
            }
        }
        if (counter_X == 3 && counterEmpty == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] == EMPTY && i + j == (size - 1)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                }
            }
        }


        for (int j = 0; j < size; j++) { //Цикл для блокировки выиграшной комбинации игрока в 4 символа
            counter_X = 0;               //по столбцам.
            counterEmpty = 0;
            for (int i = 0; i < size; i++) {
                if (map[i][j] == DOT_X) {
                    counter_X++;
                }
                if (map[i][j] == EMPTY) {
                    counterEmpty++;
                }
            }
            if (counter_X == 3 && counterEmpty == 1) {
                for (int i = 0; i < size; i++) {
                    if (map[i][j] == EMPTY) {
                        map[i][j] = DOT_O;
                        return;
                    }
                }
            }
        }


        for (int i = 0; i < size; i++) { //Цикл для блокировки выиграшной комбинации игрока в 4 символа
            counter_X = 0;               //по строкам.
            counterEmpty = 0;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_X) {
                    counter_X++;
                }
                if (map[i][j] == EMPTY) {
                    counterEmpty++;
                }
            }
            if (counter_X == 3 && counterEmpty == 1) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] == EMPTY) {
                        map[i][j] = DOT_O;
                        return;
                    }
                }
            }
        }

        Random random = new Random(); // Блок выбора компьютером клетки поля для следующего хода.
        while (true) {

            x = random.nextInt(size);
            y = random.nextInt(size);
            if (map[x][y] == EMPTY) {
                map[x][y] = DOT_O;
                return;
            }
        }
    }

    public static void main(String[] args) {
        char[][] map = getInitMap(4);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле через пробел (первая цифра" +
                " - номер строки, вторая - номер столбца):");
        Scanner in = new Scanner(System.in);
        int counterPlay = 0;
        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            x--;
            y--;
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                counterPlay++;
                printMap(map);
                if (counterPlay == 8) {
                    System.out.println("Ничья");
                    return;
                }
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    return;
                }
                System.out.println("Ход компьютера:");
                robotTurn(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    return;
                }
                printMap(map);
            }
        }
    }

}
