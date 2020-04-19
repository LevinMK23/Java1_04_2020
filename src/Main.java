import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random rnd = new Random();
    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    public static char[][] getInitMap(int size) {
        char[][] map = new char[size + 1][size + 1];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if ((i == 0) | (j == 0)) {
                    //Используем коды символов, для вывода номеров колонок и строк
                    map[i][j] = (char) (i + j + 48);
                } else {
                    map[i][j] = EMPTY;
                }
            }
        }
        return map;
    }

    public static void printMap(char [][] map) {
        for (char[] chars : map) {
            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
        }
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        if (x >= 0 && x < map.length && y >= 0 && y < map.length) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    public static void humanTurn(char[][] map, int x, int y) {
        map[x][y] = DOT_X;
    }

    private static boolean checkVictory(char[][] map, char dotXY) {
        int size = map.length;
        for (int i = 1; i < size; i++) {
            boolean xf = true, yf = true, d1 = true, d2 = true;
            for (int j = 1; j < size; j++) {
                xf &= (map[i][j] == dotXY);
                yf &= (map[j][i] == dotXY);
                d1 &= (map[j][j] == dotXY);
                d2 &= (map[j][size - j - 1] == dotXY);
            }
            if (xf || yf || d1 || d2) return true;
        }
        return false;
    }

    private static void robotTurn(char[][] map) {
        int size = map.length, tx, ty;
        do {
            tx =  1 + rnd.nextInt(size); // [0; size-1]
            ty = 1 + rnd.nextInt(size);
        } while (!isCellValid(map, tx, ty));
        map[tx][ty] = DOT_O;
        System.out.println();
    }

    public static void main(String[] args) {
        int mapSize = 3;
        char[][] map = getInitMap(mapSize);
        System.out.println("Приветствую вас в игре Крестики Нолики!\nПеред вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!\nЧтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ваш ход:");
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                if (checkVictory(map, DOT_X)) {
                    System.out.println("Вы победили");
                    break;
                }
                System.out.println("Ход компьютера:");
                robotTurn(map);
                if (checkVictory(map, DOT_O)) {
                    System.out.println("Вы проиграли");
                }
            } else {
                System.out.println("Введены некорректные данные! Введите еще раз");
            }
            printMap(map);
        }
    }
}
