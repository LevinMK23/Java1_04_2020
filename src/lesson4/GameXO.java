package lesson4;

import java.util.Scanner;

public class GameXO {

    enum Type {
        X, O, DEFAULT
    }

    private final static Type empty = Type.DEFAULT;

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    public static char[][] getInitMap(int size) {
        char[][] map = new char[size + 1][size + 1];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if ((i == 0) | (j == 0) && (i != j)) { //Добавляю обозначения номеров ячеек игрового поля
                    map[i][j] = (char) (i + j + 48); /*Таким образом можно вывести поле размером до 9х9 (дальше ':')
                                                        Думаю, для крестиков-ноликов достаточно*/
                } else if (i != 0) {
                    map[i][j] = EMPTY;
                }
            }
        }
        return map;
    }

    public static void printMap(char[][] map) {
        int size = map.length;
        for (int i = 0; i < size; i++) { /* Переделываю печать поля, пришлось отказаться от форича и
                                                немного помудрить, чтобы не было лишних скобочек*/
            for (int j = 0; j < size; j++) {
                if ((i == 0) | (j == 0)) {
                    System.out.print(" " + map[i][j]);
                } else {
                    System.out.print("|" + map[i][j]);
                }
            }
            if (i != 0) {
                System.out.println("|");
            } else {
                System.out.println("");
            }
        }
    }

    public static void humanTurn(char[][] map, int x, int y) {//Убираю декременты введенных значений, теперь не нужны
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {//Убираю декременты введенных значений, теперь не нужны
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dot) { //Оределяю условия победы
        for (int i = 1; i < map.length; i++) {    // Проверка победы при совпадении по горизонтали
            for (int j = 1; j < map.length - 1; j++) {
                if ((map[i][j] != dot) || (map[i][j + 1] != map[i][j])) {
                    break;
                } else if (j == map.length - 2) {
                    return true;
                }
            }
        }
        for (int i = 1; i < map.length; i++) {   // Проверка победы при совпадении по вертикали
            for (int j = 1; j < map.length - 1; j++) {
                if ((map[j][i] != dot) || (map[j + 1][i] != map[j][i])) {
                    break;
                } else if (j == map.length - 2) {
                    return true;
                }
            }
        }
        for (int i = 1; i < map.length - 1; i++) {   // Проверка победы при совпадении по главной диагонали
            if ((map[i][i] != dot) || (map[i + 1][i + 1] != map[i][i])) {
                break;
            } else if (i == map.length - 2) {
                return true;
            }
        }
        for (int i = 1, j = map.length - 1; j > 1; i++, j--) {   // Проверка победы при совпадении по побочной диагонали
            if ((map[i][j] != dot) || (map[i + 1][j - 1] != map[i][j])) {
                break;
            } else if (i == map.length - 2) {
                return true;
            }
        }
        return false;
    }

    private static void robotTurn(char[][] map) { // Ход робота -> случайная ячейка
        while (true) {
            int i = (int) (Math.random() * (map.length));
            int j = (int) (Math.random() * (map.length));
            if (i > 0 && j > 0 && map[i][j] == EMPTY) {
                map[i][j] = DOT_O;
                break;
            }
        }
    }


    public static boolean fullMap(char[][] map) {  // Отслеживаю ничью
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if (map[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void reStart(char[][] map) { //очистка поля для повтора игры
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    public static void main(String[] args) {
        char[][] map = getInitMap(8);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите через пробел номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    System.out.println("Играть заново - любая цифра. \nЗавершить игру - 0");
                    if (in.nextInt() == 0) {
                        System.out.println("Конец игры");
                        break;
                    }
                    System.out.println("Новая игра.");
                    reStart(map);
                    printMap(map);
                    continue;
                }
                if (fullMap(map)) {
                    System.out.println("Ничья");
                    System.out.println("Играть заново - любая цифра. \nЗавершить игру - 0");
                    if (in.nextInt() == 0) {
                        System.out.println("Конец игры");
                        break;
                    }
                    reStart(map);
                    printMap(map);
                    continue;
                }
                System.out.println("Ход компьютера:");
                robotTurn(map);
                printMap(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                    System.out.println("Играть заново - любая цифра. \nЗавершить игру - 0");
                    if (in.nextInt() == 0) {
                        System.out.println("Конец игры");
                        break;
                    }
                    reStart(map);
                    printMap(map);
                }
            } else {
                System.out.println("Введены некорректные данные.");
                if (x > map.length - 1 || y > map.length - 1 || x < 1 || y < 1) { //user friendly help comments
                    System.out.println("Введеный столбец или строчка находятся за пределами игрового поля, введите числа в пределах от 1 до " + (map.length - 1));
                } else if (map[x][y] != EMPTY) {
                    System.out.println("Введенная ячейка уже занята");
                }
            }
        }
    }

}
