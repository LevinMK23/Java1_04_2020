package lesson4.homework;

import java.util.Scanner;

public class XO {
    //Символьные константы возможных состояний клеток игрового поля: свободна, занята крестиком, занята нулём.
    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    //Обнуление игрового поля
    public static void getInitMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    //Вывод на экран игрового поля
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

    //Ход игрока - занимаем поле крестиком
    public static void humanTurn(char[][] map, int[] xy) {
        map[xy[0]][xy[1]] = DOT_X;
    }

    //Проверка введённых пользователем координат клетки на корректность
    private static boolean isCellValid(char[][] map, int[] xy) {
        xy[0]--; xy[1]--;
        int size = map.length;
        if (xy[0] >= 0 && xy[0] < size && xy[1] >= 0 && xy[1] < size) {
            return map[xy[0]][xy[1]] == EMPTY;
        }
        return false;
    }

    /**
     * Проверка условия победы - требуемое количество одинаковых символов на игровом поле в линию
     * по горизонтали, вертикали или диагонали
     * @param map игровое поле
     * @param dot знак, по которому проверяем победу (крестик либо нолик)
     * @param xy массив из двух элементов - координаты последнего сделанного хода
     * @param victorySize сколько требуется знаков в линию для победы
     * @return true в случае, если условие победы обнаружено
     */
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
        int row = xy[0];
        int column = xy[1];
        while(row > 0 && column > 0){
            row--;
            column--;
        }
        while(row < mapSize && column < mapSize){
            if(map[row][column] == dot){
                lineLength++;
                if(lineLength == victorySize){return true;}
            }
            else {lineLength = 0;}
            row++;
            column++;
        }
        //Проверка по диагонали 2
        lineLength = 0;
        row = xy[0];
        column = xy[1];
        while(row > 0 && column < mapSize - 1){
            row--;
            column++;
        }
        while (row < mapSize && column >= 0) {
            if(map[row][column] == dot){
                lineLength++;
                if(lineLength == victorySize){return true;}
            }
            else{lineLength = 0;}
            row++;
            column--;
        }
        return false;
    }

    /**
     * Проверка поля на возникновение ничьей - в случае, если свободных клеток для следующего хода нет,
     * возникает ничья
     * @param map игровое поле
     * @return true в случае ничьей
     */
    private static boolean checkDraw(char[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(map[i][j] == EMPTY){return false;}
            }
        }
        return true;
    }

    /**
     * Ход компьютера. Компьютер старается заблокировать выигрышные ходы игрока.
     * Компьютер просматривает все оси (вертикаль, горизонталь, диагонали) относительно клетки,
     * куда был сделан последний ход игрока. В случае обнаружения не занятой клетки,
     * компьютер делает туда тестовый ход за игрока (помещает в клетку крестик) и подсчитывает,
     * какой длины при таком ходе получится непрерывная последовательность из крестиков по данной оси.
     * Проверив все оси, компьютер выбирает ход, сделав который, игрок получил бы самую длинную последовательность,
     * т.е. оказался бы ближе всего к победе, и помещает в эту клетку нолик, тем самым заблокировав игроку
     * самый выгодный ход.
     * @param map игровое поле
     * @param xy координаты последнего сделанного хода (в данном случае последний ход игрока)
     */
    private static void robotTurn(char[][] map, int[] xy) {
        int targetX = 0;
        int targetY = 0;
        int maxLine = 0;
        int row = xy[0];
        int column = xy[1];
        //Ищем наиболее ценный ход по горизонтали
        for (int i = 0; i < map.length; i++) {
            if(map[row][i] == EMPTY){
                column = i;
                map[row][column] = DOT_X;
                int line = 0;
                for (int j = 0; j <map.length ; j++) {
                    if(map[row][j] == DOT_X){line++;}
                    if(map[row][j] != DOT_X || j == map.length - 1){
                        if(line > maxLine){
                            maxLine = line;
                            targetX = row;
                            targetY = column;
                        }
                        line = 0;
                    }
                }
                map[row][column] = EMPTY;
            }
        }
        row = xy[0];
        column = xy[1];
        //Ищем наиболее ценный ход по вертикали
        for (int i = 0; i < map.length; i++) {
            if(map[i][column] == EMPTY){
                row = i;
                map[row][column] = DOT_X;
                int line = 0;
                for (int j = 0; j <map.length ; j++) {
                    if(map[j][column] == DOT_X){line++;}
                    if(map[j][column] != DOT_X || j == map.length - 1){
                        if(line > maxLine){
                            maxLine = line;
                            targetX = row;
                            targetY = column;
                        }
                        line = 0;
                    }
                }
                map[row][column] = EMPTY;
            }
        }
        row = xy[0];
        column = xy[1];
        while (row > 0 && column > 0){
            row--;
            column--;
        }
        int startRow = row;
        int startColumn = column;
        //Ищем наиболее ценный ход по первой диагонали
        while (row < map.length && column < map.length){
            if(map[row][column] == EMPTY){
                map[row][column] = DOT_X;
                int stepRow = startRow;
                int stepColumn = startColumn;
                int line = 0;
                while(stepRow < map.length && stepColumn < map.length){
                    if(map[stepRow][stepColumn] == DOT_X){line++;}
                    if(map[stepRow][stepColumn] != DOT_X || stepRow == map.length - 1 || stepColumn == map.length - 1){
                        if(line > maxLine) {
                            maxLine = line;
                            targetX = row;
                            targetY = column;
                        }
                        line = 0;
                    }
                    stepRow++;
                    stepColumn++;
                }
                map[row][column] = EMPTY;
            }
            row++;
            column++;
        }
        row = xy[0];
        column = xy[1];
        while (row > 0 && column < map.length - 1){
            row--;
            column++;
        }
        startRow = row;
        startColumn = column;
        //Ищем наиболее ценный ход по второй диагонали
        while (row < map.length && column >= 0){
            if(map[row][column] == EMPTY){
                map[row][column] = DOT_X;
                int stepRow = startRow;
                int stepColumn = startColumn;
                int line = 0;
                while(stepRow < map.length && stepColumn >= 0){
                    if(map[stepRow][stepColumn] == DOT_X){line++;}
                    if(map[stepRow][stepColumn] != DOT_X || stepRow == map.length - 1 || stepColumn == 0){
                        if(line > maxLine) {
                            maxLine = line;
                            targetX = row;
                            targetY = column;
                        }
                        line = 0;
                    }
                    stepRow++;
                    stepColumn--;
                }
                map[row][column] = EMPTY;
            }
            row++;
            column--;
        }

        map[targetX][targetY] = DOT_O;
        xy[0] = targetX;
        xy[1] = targetY;
    }

    /**
     * Обработка завершения игры: либо начало новой игры, либо завершение программы
     * в зависимости от того, что ввёл игрок
     * @param in сканер командной строки
     * @return true, если игрок пожелал выйти из программы
     */
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
                if (checkVictory(map, DOT_X, xy, victorySize)) {
                    System.out.println("Вы победили");
                    if(gameOver(in)){break;}
                    getInitMap(map);
                    continue;
                }
                if (checkDraw(map)) {
                    System.out.println("Игра завершилась вничью");
                    if(gameOver(in)){break;}
                    getInitMap(map);
                    continue;
                }
                System.out.println("Ход компьютера:");
                robotTurn(map, xy);
                if (checkVictory(map, DOT_O, xy, victorySize)) {
                    printMap(map);
                    System.out.println("Вы проиграли");
                    if(gameOver(in)){break;}
                    getInitMap(map);
                }
                if (checkDraw(map)) {
                    printMap(map);
                    System.out.println("Игра завершилась вничью");
                    if (gameOver(in)) {
                        break;
                    }
                    getInitMap(map);
                }
            } else { //Подсказки пользователю, если он ввёл некорректные координаты для следующего хода.
                if(xy[0] >= map.length || xy[1] >= map.length){
                    System.out.println("Координаты выходят за пределы поля. Введите значения от 1 до " + map.length);
                }else if(xy[0] < 0 || xy[1] < 0){
                    System.out.println("Координаты не могут быть отрицательными. Введите значения от 1 до " + map.length);
                }else if(map[xy[0]][xy[1]] != EMPTY){
                    System.out.println("Клетка с координатами " + (xy[0] + 1) + ", " + (xy[1] + 1) +
                            " уже занята. Введите другие координаты");
                }
            }
        }
    }
}