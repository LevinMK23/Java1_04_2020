package lesson4hw;

import java.util.Random;
import java.util.Scanner;

public class GameXO {

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    static int size, moves;

    // Инициализация игрового поля
    public static char[][] getInitMap(int size) {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        return map;
    }

    // Вывод игрового поля
    public static void printMap(char[][] map) {
        int size = map.length;
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }
    }

    // Ход пользователя
    public static void humanTurn(char[][] map, int x, int y) {
        x--;
        y--;
        map[x][y] = DOT_X;
        moves--;
    }

    // Проверка валидности ячейки
    private static boolean isCellValid(char[][] map, int x, int y) {
        x--;
        y--;
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    // Проверка на победу
    private static boolean checkVictory(char[][] map, char dot) {
        boolean rigtDiagonal = true, leftDiagonal = true;
        int size = map.length;
        for (int i = 0; i < size; i++) {
            //Проверка вертикалей и горизонталей
            boolean vertical = true, gorizontal = true;
            for (int j = 0; j < size; j++) {
                vertical &= (map[i][j] == dot);
                gorizontal &= (map[j][i] == dot);
            }
            if (vertical || gorizontal) return true;
            //Проверка диагоналей
            rigtDiagonal &= (map[i][i] == dot);
            leftDiagonal &= (map[size - 1 - i][i] == dot);
        }
        return rigtDiagonal || leftDiagonal;
    }

    public static Random rand = new Random();
    // Ход компьютера
    private static void robotTurn(char[][] map) {
        int x, y;
        do {
            x = rand.nextInt(map.length);
            y = rand.nextInt(map.length);
        } while (!isCellValid(map, x+1, y+1));
        map[x][y] = DOT_O;
        System.out.println("Компьютер сделал свой ход в поле: " + (x + 1) + ":" + (y + 1));
        moves--;
    }
    
    // Игровой процесс
    public static void game() {
        size = 3; //Размер игрового поля
        moves = size * size; //Общее количество ходов
        char[][] map = getInitMap(size);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами игровое поле:");
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
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    break;
                }
                if (moves == 0) {
                    System.out.println("Ничья!");
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
                if (moves == 0) {
                    System.out.println("Ничья!");
                    break;
                }
            } else {
                System.out.println("Введены некорректные данные! Номер строки и столбца должны быть в диапозоне: от 1 до " + map.length);
            }
        }
        System.out.println("Повторить игру еще раз? [1 – да / 0 – нет]");
        if (in.nextInt() == 1) game();
    }

    public static void main(String[] args) {
        game();
    }
}
