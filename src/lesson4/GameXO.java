package lesson4;

import java.util.Scanner;

public class GameXO {

//    enum Type {
//        X, O, DEFAULT
//    }
//
//    private final static Type empty = Type.DEFAULT;

   static class Struct{
        int number;
        char type;
    }

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

    public static void printMap(char [][] map) {
        int size = map.length;
        int rowIndex = 1;
        int colIndex;

        for (int i = 0; i < size; i++) {
            colIndex = i + 1;
            if (i == 0) { System.out.print("   " + colIndex ); }
            else { System.out.print(" "+ colIndex ); }
        }
        System.out.println();
        for (char[] chars : map) {
            System.out.print(rowIndex+" ");
            rowIndex++;
            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
        }
    }

    public static void humanTurn(char [][] map, int x, int y) {
        x--; y--;
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(char[][] map, int x, int y) {
        x--; y--;
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }

    private static boolean checkDraw(char[][] map) {

        int size = map.length;

        boolean flagX;
        boolean flagO;
        boolean flagE;


        //Строки
        for (int i = 0; i < size; i++) {
            flagX = false;
            flagO = false;
            flagE = false;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY) { flagE  = true;}
                else if (map[i][j] == DOT_X) { flagX  = true;}
                else if (map[i][j] == DOT_O) { flagO  = true;}
            }
        if (flagE && ((!flagX && !flagO) || (flagX^flagO))) { return false;}
        }

        //Колонки
        for (int i = 0; i < size; i++) {
            flagX = false;
            flagO = false;
            flagE = false;
            for (int j = 0; j < size; j++) {
                if (map[j][i] == EMPTY) { flagE  = true;}
                else if (map[j][i] == DOT_X) { flagX  = true;}
                else if (map[j][i] == DOT_O) { flagO  = true;}
            }
            if ( flagE && ((!flagX && !flagO) || (flagX^flagO)) ) { return false;}
        }


        //Диагонали
        flagX = false;
        flagO = false;
        flagE = false;
        for (int i = 0; i < size; i++) {
            if (map[i][i] == EMPTY) {
                flagE = true;
            } else if (map[i][i] == DOT_X) {
                flagX = true;
            } else if (map[i][i] == DOT_O) {
                flagO = true;
            }
        }
        if (flagE && ((!flagX && !flagO) || (flagX^flagO))) { return false; }

        flagX = false;
        flagO = false;
        flagE = false;
        for (int j = 0; j < size; j++) {
            if (map[size - 1 - j][j] == EMPTY) {
                flagE = true;
            } else if (map[size - 1 - j][j] == DOT_X) {
                flagX = true;
            } else if (map[size - 1 - j][j] == DOT_O) {
                flagO = true;
            }
        }
        if (flagE && ((!flagX && !flagO) || (flagX^flagO))) { return false; }

        return true;
    }

    private static Struct checkVictory(char[][] map, char dotX, int numberWin) {

        Struct winStruct = new Struct();

        int size = map.length;
        int number;
        boolean block;//строка/колонка может быть уже заблокирована, поэтому нужна доп. проверка

        //Строки
        for (int i = 0; i < size ; i++) {
            number = 0;
            block = false;
            for (int j = 0; j < size ; j++) {
                if(map[i][j] == dotX) {number++;}
                if(map[i][j] != dotX && map[i][j] != EMPTY) {block = true;}
            }
            if (number == numberWin && !block) {
                winStruct.type   = 'r';
                winStruct.number = i;
                return winStruct;}
        }

        //Колонки
        for (int i = 0; i < size ; i++) {
            number = 0;
            block = false;
            for (int j = 0; j < size ; j++) {
                if(map[j][i] == dotX) {number++;}
                if(map[j][i] != dotX && map[j][i] != EMPTY) {block = true;}
            }
            if (number == numberWin && !block) {
                winStruct.type   = 'c';
                winStruct.number = i;
                return winStruct;}
        }

        //Диагонали
        number = 0;
        block = false;
        for (int j = 0; j < size ; j++) {
            if (map[j][j] == dotX) {number++;}
            if(map[j][j]!= dotX && map[j][j] != EMPTY) {block = true;}
        }
        if (number == numberWin && !block) {
            winStruct.type   = 'd';
            winStruct.number = 1;
            return winStruct;}

        number = 0;
        block = false;
        for (int j = 0; j < size ; j++) {
            if(map[size - 1 - j][j] == dotX) {number++;}
            if(map[size - 1 - j][j] != dotX && map[size - 1 - j][j]!= EMPTY) {block = true;}
        }

        if (number == numberWin && !block) {
            winStruct.type   = 'd';
            winStruct.number = 2;
            return winStruct;}
        
            winStruct.type   = 'n';
            return winStruct;

    }

    //private static void robotTurn(char[][] map, int x, int y) {
    private static void robotTurn(char[][] map, Struct struct) {
        int size = map.length;
       
        if (struct.type == 'n'){
            while(true){
                int i = (int)(Math.random()*size);
                int j = (int)(Math.random()*size);
                if (map[i][j] == EMPTY) {
                    map[i][j] = DOT_O;
                    return;
                }
            }
        }
        else if(struct.type == 'r'){
            for (int i = 0; i < size; i++) {
                if(map[struct.number][i] == EMPTY){
                    map[struct.number][i] = DOT_O;
                    return; 
                }
            }
        }
        else if (struct.type == 'c'){
            for (int i = 0; i < size; i++) {
                if(map[i][struct.number] == EMPTY){
                    map[i][struct.number] = DOT_O;
                    return;
                }
            }

        }
        else if (struct.type == 'd'){
            if (struct.number == 1){
                for (int i = 0; i < size ; i++) {
                    if(map[i][i] == EMPTY){
                        map[i][i] = DOT_O;
                        return;
                    }
                }
            }
            else{
                for (int i = 0; i <size ; i++) {
                    if(map[size - 1 - i][i] == EMPTY){
                        map[size - 1 - i][i] = DOT_O;
                        return;
                    }
                }
            }

        }

    }

    public static void main(String[] args) {

        int go = 1;
        Scanner in = new Scanner(System.in);

        while (go != 0){
        char[][] map = getInitMap(4);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы иг1раете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);

                if (checkVictory(map, DOT_X, map.length).type != 'n') {
                    System.out.println("Вы победили!!!");
                    System.out.println("Хотите сыграть еще. 1/Да, 0/Нет");
                    go = in.nextInt();
                    break;
                }

                if (checkDraw(map)){
                    System.out.println("Ничья!!");
                    System.out.println("Хотите сыграть еще. 1/Да, 0/Нет");
                    go = in.nextInt();
                    break;
                }

                System.out.println("Ход компьютера:");
                //Проверяем map, но условие победы на 1 меньше, так находим строку/колонку, которую надо блокировать
                robotTurn(map, checkVictory(map, DOT_X, map.length-1));
                printMap(map);
                if (checkVictory(map, DOT_O, map.length).type != 'n') {
                    System.out.println("Вы проиграли!!!");
                    System.out.println("Хотите сыграть еще. 1/Да, 0/Нет");
                    go = in.nextInt();
                    break;
                }

                if (checkDraw(map)){
                    System.out.println("Ничья!!");
                    System.out.println("Хотите сыграть еще. 1/Да, 0/Нет");
                    go = in.nextInt();
                    break;
                }

            } else {
                System.out.println("Введены некорректные данные! Введите еще раз");
                continue;
            }
        }
    }
    }

}
