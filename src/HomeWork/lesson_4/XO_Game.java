package HomeWork.lesson_4;

import java.util.Arrays;
import java.util.Scanner;

public class XO_Game {

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
        int size = map.length;
        int[] columnNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            columnNumbers[i] = i + 1;
        }
        System.out.printf("%2c", ' ');
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d", columnNumbers[i]);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.print("|" + map[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void humanTurn(char[][] map, int x, int y) {
        x--;
        y--;
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        x--;
        y--;
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    private static boolean checkVictory(char[][] map, char dot) {
        int countHorisontal = 1;
        int countVertical = 1;
        int countDiagonal = 1;
        int winCount;
        boolean win = false;

        if (map.length < 5) {
            winCount = map.length;
        } else {
            winCount = 4;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                if (map[i][j] == dot && map[i][j] == map[i][j + 1]) {
                    countHorisontal++;
                    if (countHorisontal == winCount) {
                        win = true;
                        return win;
                    }
                } else {
                    countHorisontal = 1;
                }

                if (map[j][i] == dot && map[j][i] == map[j + 1][i]) {
                    countVertical++;
                    if (countVertical == winCount) {
                        win = true;
                        return win;
                    }
                } else {
                    countVertical = 1;
                }
            }
            countVertical = 1;
            countHorisontal = 1;


        }
        //check diagonal:
        //diff - количество диагоналей по x и по y, которые необходимо проверить, кроме основной диагонали
        //проверяем все низходящие диагонали слева направо:
        //по x
        int diff = map.length - winCount;
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i][i + j] == dot && map[i][i + j] == map[i + 1][i + 1 + j]) {
                    countDiagonal++;
                    if (countDiagonal == winCount) {
                        win = true;
                        return win;
                    }
                } else {
                    countDiagonal = 1;
                }

            }
            countDiagonal = 1;
        }
        //по y
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i + j][i] == dot && map[i + j][i] == map[i + 1 + j][i + 1]) {
                    countDiagonal++;
                    if (countDiagonal == winCount) {
                        win = true;
                        return win;
                    }
                } else {
                    countDiagonal = 1;
                }

            }
            countDiagonal = 1;
        }
        //Проверяем все восходящие диагонали слева направо:
        //по y
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i + j][map.length - i - 1] == dot && map[i + j][map.length - i - 1] == map[i + 1 + j][map.length - i - 2]) {
                    countDiagonal++;
                    if (countDiagonal == winCount) {
                        win = true;
                        return win;
                    }
                } else {
                    countDiagonal = 1;
                }
            }
            countDiagonal = 1;
        }
        //по x
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i][map.length - i - 1 - j] == dot && map[i][map.length - i - 1 - j] == map[i + 1][map.length - i - 2 - j]) {
                    countDiagonal++;
                    if (countDiagonal == winCount) {
                        win = true;
                        return win;
                    }
                } else {
                    countDiagonal = 1;
                }
            }
            countDiagonal = 1;
        }
        return win;
    }

    private static boolean checkNotEmpty(char[][] map) {
        int countEmpty = 0;
        boolean notEmpty = false;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == EMPTY) countEmpty++;
            }
        }
        if (countEmpty == 0) {
            notEmpty = true;
            return notEmpty;
        }
        return notEmpty;
    }

    private static void robotTurn(char[][] map, int x, int y) {
        //random:
       /* int size = map.length;
        while (true) {
            int i = ((int) (Math.random() * size));
            int j = ((int) (Math.random() * size));
            if (map[i][j] == EMPTY) {
                map[i][j] = DOT_O;
                return;
            }
        }*/

        int countHorisontal = 1;
        int countVertical = 1;
        int countDiagonal = 1;
        int winCount;
        if (map.length < 5) winCount = map.length;
        else winCount = 4;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                if (map[i][j] == DOT_X && map[i][j] == map[i][j + 1]) {
                    countHorisontal++;
                    if (countHorisontal >= 2) {
                        if ((j + 2) <= map.length - 1 && map[i][j + 2] == EMPTY) {
                            map[i][j + 2] = DOT_O;
                            return;
                        } else if ((j - 1) >= 0 && map[i][j - 1] == EMPTY) {
                            map[i][j - 1] = DOT_O;
                            return;
                        }
                    }
                } else {
                    countHorisontal = 1;
                }

                if (map[j][i] == DOT_X && map[j][i] == map[j + 1][i]) {
                    countVertical++;
                    if (countVertical >= 2) {
                        if ((j + 2) <= map.length - 1 && map[j + 2][i] == EMPTY) {
                            map[j + 2][i] = DOT_O;
                            return;
                        } else if ((j - 1) >= 0 && map[j - 1][i] == EMPTY) {
                            map[j - 1][i] = DOT_O;
                            return;
                        }
                    }
                } else {
                    countVertical = 1;
                }
            }
            countVertical = 1;
            countHorisontal = 1;
        }
        //check diagonal:
        //проверяем все низходящие диагонали слева направо:
        int diff = map.length - winCount;
        //по x
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i][i + j] == DOT_X && map[i][i + j] == map[i + 1][i + 1 + j]) {
                    countDiagonal++;
                    if (countDiagonal >= 2) {
                        if ((i + 2 + j) <= map.length - 1 && map[i+2][i+2+j] == EMPTY){
                            map[i+2][i+2+j]= DOT_O;
                            return;
                        } else if ((i-1)>=0 && map[i-1][i-1+j] == EMPTY){
                            map[i-1][i-1+j]= DOT_O;
                            return;
                        }
                    }
                } else {
                    countDiagonal = 1;
                }

            }
            countDiagonal = 1;
        }
        //по y
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i + j][i] == DOT_X && map[i + j][i] == map[i + 1 + j][i + 1]) {
                    countDiagonal++;
                    if (countDiagonal >= 2) {
                        if((i+j+2)<=map.length-1 && map[i+2+j][i+2] == EMPTY){
                            map[i+2+j][i+2] = DOT_O;
                            return;
                        } else if ((i-1)>=0 && map[i+j-1][i-1] == EMPTY){
                            map[i+j-1][i-1] = DOT_O;
                            return;
                        }
                    }
                } else {
                    countDiagonal = 1;
                }

            }
            countDiagonal = 1;
        }
        //Проверяем все восходящие диагонали слева направо:
        //по y
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i + j][map.length - i - 1] == DOT_X && map[i + j][map.length - i - 1] == map[i + 1 + j][map.length - i - 2]) {
                    countDiagonal++;
                    if (countDiagonal >= 2) {
                        if((i+2+j)<= map.length-1 && map[i+2+j][map.length-i-3] == EMPTY){
                            map[i+2+j][map.length-i-3] = DOT_O;
                            return;
                        } else if ((map.length-i)<=(map.length-1) && map[i+j-1][map.length-i] == EMPTY){
                            map[i+j-1][map.length-i] = DOT_O;
                            return;
                        }
                    }
                } else {
                    countDiagonal = 1;
                }
            }
            countDiagonal = 1;
        }
        //по x
        for (int j = 0; j <= diff; j++) {
            for (int i = 0; i < map.length - 1 - j; i++) {
                if (map[i][map.length - i - 1 - j] == DOT_X && map[i][map.length - i - 1 - j] == map[i + 1][map.length - i - 2 - j]) {
                    countDiagonal++;
                    if (countDiagonal >= 2) {
                        if((map.length-i-j-3)>=0 && map[i+2][map.length-i-j-3] == EMPTY){
                            map[i+3][map.length-i-j-3] = DOT_O;
                            return;
                        } else if((i-1)>=0 && map[i-1][map.length-i-j] == EMPTY){
                            map[i-1][map.length-i-j] = DOT_O;
                            return;
                        }
                    }
                } else {
                    countDiagonal = 1;
                }
            }
            countDiagonal = 1;
        }

        //если линий пока нет, то ставим 0 рандомно:
        if (countDiagonal == 1 && countHorisontal == 1 && countVertical == 1) {
            int size = map.length;
            while (true) {
                int i = ((int) (Math.random() * size));
                int j = ((int) (Math.random() * size));
                if (map[i][j] == EMPTY) {
                    map[i][j] = DOT_O;
                    return;
                }
            }
        }
    }

    private static void ifSmbWin() {
        Scanner in = new Scanner(System.in);
        System.out.println("Чтобы сыграть еще раз, нажмите 1, для выхода 0.");
        int end = in.nextInt();
        switch (end) {
            case 0:
                return;
            case 1:
                gameBody();
        }
    }

    private static void gameBody() {

        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Напишите желаемую длину стороны поля. \nВнимание! Для полей от 5 клеток в длину, достаточно 4 фишек в линию для победы.");
        Scanner scan = new Scanner(System.in);
        int sizeField = scan.nextInt();
        char[][] map = getInitMap(sizeField);
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);
        boolean humanWin = false;
        boolean robotWin = false;

        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_X)) {
                    humanWin = true;
                }
                if (checkNotEmpty(map)){
                    if(checkVictory(map,DOT_X)){
                        System.out.println("Вы победили");
                        ifSmbWin();
                    } else {
                        System.out.println("Конец игры. Никто не выиграл.");
                        ifSmbWin();
                    }
                }
                System.out.println("Ход компьютера:");
                robotTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_O)) {
                    robotWin = true;
                    //ничья:
                    if (humanWin == true) {
                        printMap(map);
                        System.out.println("Ничья!");
                        ifSmbWin();
                    } else {
                        printMap(map);
                        System.out.println("Вы проиграли");
                        ifSmbWin();
                    }
                }
                if (humanWin == true) {
                    printMap(map);
                    System.out.println("Вы победили");
                    ifSmbWin();
                }
                if (checkNotEmpty(map)){
                    printMap(map);
                    System.out.println("Конец игры. Никто не выиграл.");
                    ifSmbWin();
                }
            } else {
                System.out.println("Введены некорректные данные! Введите еще раз.");
                if (x >= 0 && x < map.length && y >= 0 && y < map.length) {
                    System.out.println("Кажется, это поле уже занято.");
                } else {
                    System.out.println("Кажется, таких координат не существует.");
                }
            }
        }
    }

    public static void main(String[] args) {
        gameBody();
    }
}

