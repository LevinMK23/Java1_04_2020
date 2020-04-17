import java.util.Random;
import java.util.Scanner;

public class TicTacToeHome {
    private static final int SIZE = 3;                                      //Размер поля
    private static final boolean SILLY_MODE = false;
    private static final boolean SCORING_MODE = true;
    private static final char DOT_EMPTY = '_';                              //Пустой символ(свободное поле)
    private static final char DOT_X = 'X';                                  //Крестик
    private static final char DOT_O = 'O';                                  //Нолик
    private static final Scanner scanner = new Scanner(System.in);          //Считивание ходов
    private static final Random random = new Random();                      //Генерация случайных числе
    private static char[][] map;                                            //Поле игры

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn(); //ход человека
            if (isEndGame(DOT_X)) {
                break;
            }
            computerTurn(); //ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    //подготовка игрового поля
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //вывод игрового поля
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //проверка на валидность
    private static boolean isCellValid(int x, int y) {
        boolean result = true;
        //проверка координаты
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }
        //проверка заполненности ячейки
        if (map[y][x] != DOT_EMPTY) {
            result = false;
        }
        return result;
    }


    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static void computerTurn() {
        int x = -1, y = -1;
        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
            while (!isCellValid(x, y));
        } else {
            if (!SCORING_MODE) {
                boolean moveFound = false;
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (map[i][j] == DOT_EMPTY) {
                            //проверяем направления
                            //лево верх
                            if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("LU");
                            }
                            //верх
                            else if (i - 1 >= 0 && map[i - 1][j] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("U");
                            }
                            //право верх
                            else if (i - 1 >= 0 && j + 1 < SIZE && map[i - 1][j + 1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("RU");
                            }
                            //право
                            else if (j + 1 < SIZE && map[i][j + 1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("R");
                            }
                            //право низ
                            else if (i + 1 < SIZE && j + 1 < SIZE && map[i + 1][j + 1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("RD");
                            }
                            //низ
                            else if (i + 1 < SIZE && map[i + 1][j] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("D");
                            }
                            //лево низ
                            else if (i + 1 < SIZE && j - 1 >= 0 && map[i + 1][j - 1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("LD");
                            }
                            //лево
                            else if (j - 1 >= 0 && map[i][j - 1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("L");
                            }
                        }
                        //если ход найден, прерываем внутренний цикл
                        if (moveFound) {
                            break;
                        }
                    }
                    if (moveFound) {
                        break;
                    }
                }
            } else {
                int maxScoreFieldX = -1;
                int maxScoreFieldY = -1;
                int maxScore = 0;

                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        int fieldScore = 0;

                        if (map[i][j] == DOT_EMPTY) {
                            //проверяем направления
                            //лево верх
                            if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == DOT_O) {
                                fieldScore++;
                                System.out.println("LU");
                            }
                            //верх
                            if (i - 1 >= 0 && map[i - 1][j] == DOT_O) {
                                fieldScore++;
                            }
                            //право верх
                            if (i - 1 >= 0 && j + 1 < SIZE && map[i - 1][j + 1] == DOT_O) {
                                fieldScore++;
                            }
                            //право
                            if (j + 1 < SIZE && map[i][j + 1] == DOT_O) {
                                fieldScore++;
                            }
                            //право низ
                            if (i + 1 < SIZE && j + 1 < SIZE && map[i + 1][j + 1] == DOT_O) {
                                fieldScore++;
                            }
                            //низ
                            if (i + 1 < SIZE && map[i + 1][j] == DOT_O) {
                                fieldScore++;
                            }
                            //лево низ
                            if (i + 1 < SIZE && j - 1 >= 0 && map[i + 1][j - 1] == DOT_O) {
                                fieldScore++;
                            }
                            //лево
                            if (j - 1 >= 0 && map[i][j - 1] == DOT_O) {
                                fieldScore++;
                            }
                        }
                        if (fieldScore > maxScore) {
                            maxScore = fieldScore;
                            maxScoreFieldX = j;
                            maxScoreFieldY = i;
                        }
                    }
                }
                //если найдена наилучшая клетка
                if (maxScoreFieldX != -1) {
                    x = maxScoreFieldX;
                    y = maxScoreFieldY;
                }
            }
            //если ничего не нашли
            if (x == -1) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (!isCellValid(x, y));
                System.out.println("RANDOM");
            }
        }
        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }

    private static boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight, rightLeft, result;

        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < SIZE; i++) {
            leftRight &= (map[i][i] == playerSymbol);
            rightLeft &= (map[SIZE - i - 1][i] == playerSymbol);
        }
        if (leftRight || rightLeft) {
            result = true;
        }
        return result;
    }

    private static boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;
        for (int col = 0; col < SIZE; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < SIZE; row++) {
                cols &= (map[col][row] == playerSymbol);
                rows &= (map[row][col] == playerSymbol);
            }
            if (cols || rows) {
                result = true;
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public static boolean checkWin(char playerSymbol) {
        boolean result = false;
        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }
        return result;
    }

    public static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    //пустая клетка найдена
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;
        printMap();
        //проверяем необходимость селдующего хода
        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            result = true;
        }
        return result;
    }
}
