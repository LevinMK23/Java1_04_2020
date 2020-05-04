package lesson8.gui.homework;

import java.util.Random;

/**
 * Игровое поле, обработка совершения хода, отслеживание победы, логика компьютерного игрока
 */
public class GameBoard {

    private final char[][] board; // Игровое поле. На нём производятся все расчёты и логика
    private int countOfHalfTurns; // Показывает, сколько уже сделано полуходов. Если 25, то дальнейшие ходы блокируются

    public char getField(int i, int j) { return board[i][j]; }
    public void setField(int i, int j, char dot) { board[i][j] = dot; }
    public void setHalfTurns(int halfTurns) { countOfHalfTurns = halfTurns; }

    /**
     * Полуход игрока либо компьютера
     * Выполняет ход на доске, распоряжается изменениями в интерфейсе
     * @param xy - массив из двух координат игрового поля, в которое нужно сделать ход
     * @param dot - крестик либо нолик в зависимости от того, чей ход
     * @param game - GUI игры
     */
    private void halfTurn(int[] xy, char dot, GameXO game) {
        countOfHalfTurns++;
        board[xy[0]][xy[1]] = dot;
        switch (dot) {
            case Const.DOT_X: game.setMapDisabled(xy[0], xy[1], Const.ICON_X); break;
            case Const.DOT_O: game.setMapDisabled(xy[0], xy[1], Const.ICON_O); break;
        }
    }

    /**
     * Полный ход. Состоит из полуходов игрока и компьютера
     * @param x координата хода по вертикали
     * @param y координата хода по горизонтали
     * @param game GUI игры
     */
    public void turn(int x, int y, GameXO game) {
        int[] xy = {x, y};
        halfTurn(xy,Const.DOT_X,game);
        if(checkVictory(Const.DOT_X, x, y)) {
            game.gameOver(Const.DOT_X);
            return;
        }
        if(countOfHalfTurns < 25) {
            halfTurn(robotTurn(xy[0], xy[1]), Const.DOT_O, game);
            if(checkVictory(Const.DOT_O, x, y)) {
                game.gameOver(Const.DOT_O);
            }
        }
    }

    /**
     * Проверка условия победы - четыре одинаковых символа на игровом поле в линию
     * по горизонтали, вертикали или диагонали
     * Из проверки исключены диагонали, состоящие менее, чем из четырёх полей
     * @param dot знак, по которому проверяем победу (крестик либо нолик)
     * @param x координата последнего сделанного хода по вертикали
     * @param y координата последнего сделанного хода по горизонтали
     * @return true в случае, если условие победы обнаружено, false, если не обнаружено
     */
    private boolean checkVictory(char dot, int x, int y) {
        int sumXY = x + y;
        int difXY = x - y;
        int lineLength = 0;
        //Проверка по горизонтали
        for (int i = 0; i < 5; i++) {
            if(board[x][i] == dot){ lineLength++; }
            else{ lineLength = 0; }
            if (lineLength == 4){ return true; }
        }
        //Проверка по вертикали
        lineLength = 0;
        for (int i = 0; i < 5; i++) {
            if(board[i][y] == dot){ lineLength++; }
            else{ lineLength = 0; }
            if (lineLength == 4){ return true; }
        }
        // Проверка по диагонали 1
        // В проверке нуждаются только три диагонали поля: остальные не вместят выигрышную комбинацию
        if (difXY == 1 || difXY == 0 || difXY == -1) {
            lineLength = 0;
            int row = 0;
            int column = 0;
            switch (difXY) {
                case -1: row = 0; column = 1; break;
                case 1: row = 1; column = 0; break;
            }
            while (row < 5 && column < 5) {
                if (board[row][column] == dot) {
                    lineLength++;
                    if (lineLength == 4) {
                        return true;
                    }
                } else {
                    lineLength = 0;
                }
                row++;
                column++;
            }
        }
        //Проверка по диагонали 2
        // В проверке нуждаются только три диагонали поля: остальные не вместят выигрышную комбинацию
        if (sumXY == 3 || sumXY == 4 || sumXY == 5) {
            lineLength = 0;
            int row = 4;
            int column = 0;
            switch (sumXY) {
                case 3: row = 3; column = 0; break;
                case 5: row = 4; column = 1; break;
            }
            while (row < 5 && column >= 0) {
                if (board[row][column] == dot) {
                    lineLength++;
                    if (lineLength == 4) {
                        return true;
                    }
                } else {
                    lineLength = 0;
                }
                row++;
                column--;
            }
        }
        return false;
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
     * Если в линии нет места для выигрышной последовательности крестиков, то такая линия не рассматривается
     * Если не найдено ни одной подходящей линии, делается случайный ход
     * @param x координата последнего хода игрока по вертикали
     * @param y координата последнего хода игрока по горизонтали
     */
    private int[] robotTurn(int x, int y) {
        int targetX;
        int targetY;
        // Сначала выбирается случайное свободное поле для хода
        // Если не будет найден более удачный вариант, то будет выполнен этот случайный ход
        Random random = new Random();
        while (true) {
            targetX = random.nextInt(5);
            targetY = random.nextInt(5);
            if (board[targetX][targetY] == Const.EMPTY) { break; }
        }
        // Максимальная длина последовательности крестиков после возможного хода игрока
        // По ней выбирается, куда сделать ход
        int maxLine = 0;
        // Показывает, сколько крестиков в одну линию может вместить рассматриваемая вертикаль, горизонталь
        // или диагональ с учётом клеток, уже занятых ноликами. Если меньше четырёх, то делать ход в эту линию
        // не имеет смысла
        int freeLine = 0;
        int row = x;
        int column = y;
        // Ищем наиболее ценный ход по горизонтали
        // Проверяем, возможно ли вписать в эту горизонталь подряд четыре крестика
        // Если нет, то проверку данной горизонтали пропускаем
        for (int i = 0; i < 5; i++) {
            if (board[row][i] != Const.DOT_O) {
                freeLine++;
                if (freeLine == 4) { break; }
            }
            else { freeLine = 0; }
        }
        if(freeLine == 4) {
            for (int i = 0; i < 5; i++) {
                if (board[row][i] == Const.EMPTY) {
                    column = i;
                    board[row][column] = Const.DOT_X;
                    int line = 0;
                    for (int j = 0; j < 5; j++) {
                        if (board[row][j] == Const.DOT_X) {
                            line++;
                        }
                        if (board[row][j] != Const.DOT_X || j == 4) {
                            if (line > maxLine) {
                                maxLine = line;
                                targetX = row;
                                targetY = column;
                            }
                            line = 0;
                        }
                    }
                    board[row][column] = Const.EMPTY;
                }
            }
        }
        row = x;
        column = y;
        freeLine = 0;
        //Ищем наиболее ценный ход по вертикали
        // Проверяем, возможно ли вписать в эту вертикаль подряд четыре крестика
        // Если нет, то проверку данной вертикали пропускаем
        for (int i = 0; i < 5; i++) {
            if (board[i][column] != Const.DOT_O) {
                freeLine++;
                if (freeLine == 4) { break; }
            }
            else { freeLine = 0; }
        }
        if(freeLine == 4) {
            for (int i = 0; i < 5; i++) {
                if (board[i][column] == Const.EMPTY) {
                    row = i;
                    board[row][column] = Const.DOT_X;
                    int line = 0;
                    for (int j = 0; j < 5; j++) {
                        if (board[j][column] == Const.DOT_X) {
                            line++;
                        }
                        if (board[j][column] != Const.DOT_X || j == 4) {
                            if (line > maxLine) {
                                maxLine = line;
                                targetX = row;
                                targetY = column;
                            }
                            line = 0;
                        }
                    }
                    board[row][column] = Const.EMPTY;
                }
            }
        }
        row = x;
        column = y;
        freeLine = 0;
        while (row > 0 && column > 0){
            row--;
            column--;
        }
        int startRow = row;
        int startColumn = column;
        //Ищем наиболее ценный ход по первой диагонали
        // Проверяем, возможно ли вписать в эту дигональ подряд четыре крестика
        // Если нет, то проверку данной диагонали пропускаем
        while (row < 5 && column < 5) {
            if (board[row][column] != Const.DOT_O) {
                freeLine++;
                if (freeLine == 4) { break; }
            }
            else { freeLine = 0; }
            row++;
            column++;
        }
        if (freeLine == 4) {
            row = startRow;
            column = startColumn;
            while (row < 5 && column < 5) {
                if (board[row][column] == Const.EMPTY) {
                    board[row][column] = Const.DOT_X;
                    int stepRow = startRow;
                    int stepColumn = startColumn;
                    int line = 0;
                    while (stepRow < 5 && stepColumn < 5) {
                        if (board[stepRow][stepColumn] == Const.DOT_X) {
                            line++;
                        }
                        if (board[stepRow][stepColumn] != Const.DOT_X || stepRow == 4 || stepColumn == 4) {
                            if (line > maxLine) {
                                maxLine = line;
                                targetX = row;
                                targetY = column;
                            }
                            line = 0;
                        }
                        stepRow++;
                        stepColumn++;
                    }
                    board[row][column] = Const.EMPTY;
                }
                row++;
                column++;
            }
        }
        row = x;
        column = y;
        freeLine = 0;
        while (row > 0 && column < 4){
            row--;
            column++;
        }
        startRow = row;
        startColumn = column;
        //Ищем наиболее ценный ход по второй диагонали
        // Проверяем, возможно ли вписать в эту диагональ подряд четыре крестика
        // Если нет, то проверку данной диагонали пропускаем
        while (row < 5 && column >= 0) {
            if (board[row][column] != Const.DOT_O) {
                freeLine++;
                if (freeLine == 4) { break; }
            }
            else { freeLine = 0; }
            row++;
            column--;
        }
        if (freeLine == 4) {
            row = startRow;
            column = startColumn;
            while (row < 5 && column >= 0) {
                if (board[row][column] == Const.EMPTY) {
                    board[row][column] = Const.DOT_X;
                    int stepRow = startRow;
                    int stepColumn = startColumn;
                    int line = 0;
                    while (stepRow < 5 && stepColumn >= 0) {
                        if (board[stepRow][stepColumn] == Const.DOT_X) {
                            line++;
                        }
                        if (board[stepRow][stepColumn] != Const.DOT_X || stepRow == 4 || stepColumn == 0) {
                            if (line > maxLine) {
                                maxLine = line;
                                targetX = row;
                                targetY = column;
                            }
                            line = 0;
                        }
                        stepRow++;
                        stepColumn--;
                    }
                    board[row][column] = Const.EMPTY;
                }
                row++;
                column--;
            }
        }
        int[] xy = {targetX, targetY};
        return xy;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s.append("|").append(board[i][j]);
            }
            s.append("|\n");
        }
        return String.valueOf(s);
    }

    public GameBoard() {
        this.board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.board[i][j] = Const.EMPTY;
            }
        }
        countOfHalfTurns = 0;
    }
}
