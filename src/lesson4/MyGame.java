package lesson4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MyGame {
    private static final char DOT_EMPTY = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static char[][] map;
    private static int tryCount;
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    public static void printMap() {
        System.out.print(0 + "  ");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print("|" + map[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static char[][] initMap(int size) {
        tryCount = size * size;
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        return map;
    }

    public static boolean isCellValid(int size,int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void userPlay(int size) {
        int x, y;
        try {
            do {
                System.out.println("Введите координаты в формате X Y, координаты вводятся в числовом формате, через пробел");
                x = in.nextInt() - 1;
                y = in.nextInt() - 1;
            } while (!isCellValid(size, x, y));
            map[y][x] = DOT_X;
            tryCount--;
        } catch (InputMismatchException t){
            System.out.println("Вы ввели некорректные данные");
            userPlay(size);
        }
    }

    public static void computerPlay(int size) {
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isCellValid(size, x, y));
        tryCount--;
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

    }

    private static boolean checkVictory(char[][] map, int size, char dot) {

        boolean diagonal1 = true, diagonal2 = true;

        for (int i = 0; i < size; i++) {
            boolean horVer1 = true, horVer2 = true;
            for (int j = 0; j < size; j++) {
                horVer1 &= (map[i][j] == dot);
                horVer2 &= (map[j][i] == dot);
            }
            if (horVer1 || horVer2) {
                return true;
            }

            diagonal1 &= (map[i][i] == dot);
            diagonal2 &= (map[size - 1 - i][i] == dot);
        }
        return diagonal1 || diagonal2;
    }
    public static boolean isMapFull(){
        if (tryCount == 0){
            return true;
        } else {
            return false;
        }
    }
    public static void tryAgain(){
        try {
            System.out.println("Хочешь сыграть еще раз? Введи \"1\", если хочешь сыграть еще раз, " +
                    "\nили \"2\", если ты оень занятой человек и у тебя по каким-то причинам нет возможности поиграть блин... ");
            byte x = in.nextByte();
            do {
                if (x == 1) {
                    System.out.println("Супер, погнали!");
                    System.out.println("Введите максимальное кол-во клеток в 1 строке: ");
                    byte userSize = in.nextByte();
                    if (userSize < 6){
                        gameXO(userSize);
                    } else if(userSize < 10) {
                        System.out.printf("Это будет довольно долгая игра... \nВедь будет целых %d полей...", (userSize * userSize));
                        gameXO(userSize);
                    } else {
                        System.out.println("Ты точно уверен, что хочешь сыграть с таким большим полем?");
                        for (int i = 0; i < 5; i++) {
                            System.out.println();
                        }
                        System.out.println("Надеюсь, что ты передумал, но смотри сам...");
                        System.out.println("На всякий случай, введи еще раз максимальное кол-во клеток в 1 строке: ");
                        userSize = in.nextByte();
                        gameXO(userSize);
                    }
                } else if (x == 2) {
                    System.out.println("Обидно, конечно, ну да ладно, счастливо, дружище!");
                    return;
                } else {
                    System.out.println("Введи 1 или 2, что сложного то???");
                    x = in.nextByte();
                }
            } while (x != 1 || x != 2);
        } catch (InputMismatchException t) {
            System.out.println("ЧЕЕЕЕЕЕЕРТ! Введи число!!!! 1 или 2!!!");
            tryAgain();
        }
    }


    public static void gameXO(int size){
        initMap(size);
        System.out.printf("\nВас приветствует игра \"Крестики- нолики\"" +
                "\n ниже представлено поле для игры рамером %d на %d \n", size, size);
        printMap();
        System.out.println("Попробуйте победить =)");
        do {
            userPlay(size);
            printMap();
            if (checkVictory(map,size, DOT_X)){
                System.out.println("Ты победил компьютер, молодец!");
                tryAgain();
                return;
            }
            computerPlay(size);
            printMap();
            if (checkVictory(map, size, DOT_O)){
                System.out.println("Ахахах, как ты мог проиграть компьтеру?");
                System.out.println("Ну ладно...");
                tryAgain();
                return;
            }
        } while (!isMapFull());
        System.out.println("Игра, к сожалению, закончилась ничьей.");
        tryAgain();
    }

    public static void main(String[] args) {
        gameXO(3);
    }
}