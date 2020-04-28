package lesson4;

import java.util.Random;
import java.util.Scanner;

public class GameXO {

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private final static int size = 5; // Указываем рамер поля здесь

    public static void main(String[] args) {
        Scanner check = new Scanner(System.in);
        do {
            Game();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            System.out.println("Ваш выбор: ");
        } while (check.nextInt() == 1);
    }

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

        //Добавлена печать координат
        int i = 1;
        System.out.print("*");
        for (int j = 1; j <= size; j++) {
            System.out.print(" " + j);
        }
        System.out.println();

        for (char[] chars : map) {
            System.out.print(i);

            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
            i++;
        }
    }


    public static void humanTurn(char[][] map, int x, int y) {
        x--;
        y--;
        map[x][y] = DOT_X;
        steps++;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {

        x--;
        y--;

        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }


    private static boolean checkVictory(char[][] map, char DOT_X) {
        // TODO: 14.04.2020 - Только для поля 3х3 - Сделано
        // dotX dotX dotX
        // dotX dotX
        // dotX     dotX
        // Пока что только для поля 3х3
        if (map[0][0] == DOT_X && map[0][1] == DOT_X && map[0][2] == DOT_X) return true;
        if (map[1][0] == DOT_X && map[1][1] == DOT_X && map[1][2] == DOT_X) return true;
        if (map[2][0] == DOT_X && map[2][1] == DOT_X && map[2][2] == DOT_X) return true;
        if (map[0][0] == DOT_X && map[1][0] == DOT_X && map[2][0] == DOT_X) return true;
        if (map[0][1] == DOT_X && map[1][1] == DOT_X && map[2][1] == DOT_X) return true;
        if (map[0][2] == DOT_X && map[1][2] == DOT_X && map[2][2] == DOT_X) return true;
        if (map[0][0] == DOT_X && map[1][1] == DOT_X && map[2][2] == DOT_X) return true;
        if (map[2][0] == DOT_X && map[1][1] == DOT_X && map[0][2] == DOT_X) return true;
        return false;
    }

    private static void robotTurnRandom(char[][] map, int x, int y) {
        Random rnd = new Random();
        int rndX = rnd.nextInt(size);
        int rndY = rnd.nextInt(size);

        while (map[rndX][rndY] == DOT_X | map[rndX][rndY] == DOT_O) {
            rndX = rnd.nextInt(size);
            rndY = rnd.nextInt(size);
        }
        map[rndX][rndY] = DOT_O;

    }

    public static boolean drawCheck(char[][] map) {

        for (int i = 0; i < size; i++) {
            boolean xf = true, yf = true, d1 = true, d2 = true;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY) return false;
            }
            if (xf || yf || d1 || d2) return true;
        }
        return true;
    }

    public static void Game() {
        // обернул тело игры в отдельный метод

        char[][] map = getInitMap(size); // ввели глобальную перемменую size для размеров игровог поля

        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");

        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ваш ход");
            System.out.print("Введите коорадинату X: ");
            int x = in.nextInt();
            System.out.print("Введите коорадинату Y: ");
            int y = in.nextInt();

            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                // TODO: 14.04.2020 отследить ничью и Дать выбор на начало новой игры - Сделано
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    System.out.println("Игра закончена");
                    // TODO: 14.04.2020 что делать дальше??? - Дать выбор на начало новой игры - Сделано
                    break;
                }
                if (drawCheck(map)) {
                    System.out.println("Поля закончились, Ничья"); // Проверка на ничью после хода человека
                    break;
                }

                System.out.println("Ход компьютера:");

                robotTurnRandom(map, x, y); // Робот ходит непредсказуемо (рандом)
                printMap(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    System.out.println("Игра закончена");
                    // TODO: 14.04.2020 что делать дальше??? - Дать выбор на начало новой игры - Сделано
                    break;
                }
                if (drawCheck(map)) {
                    System.out.println("Поля закончились, Ничья"); // Проверка на ничью после хода робота
                    break;
                }
            } else if (isCellValid(map, x, y) == false) {
                System.out.println("Поле с этими координатами уже занято, Выберете другое!");
            } else if (x > size | x < 1 | y > size | y < 1) {
                System.out.println("Введены некорректные данные! Введите еще раз");
                System.out.println("Вводите только числа!");
                System.out.println("Координаты не могут превышать размеры игрового поля. *Сейчас оно равно: " + size + "x" + size);
                System.out.println("После введения координаты - нажмите Enter");

                // TODO: 14.04.2020 user friendly help comments - Сделано

            }
        }
    }

}
