package lesson6.homework;

/**
 * Шахматная доска
 */
public class ChessBoard {

    private ChessFigure[][] board; // Игровое поле - массив ссылок на фигуры и пустых клеток
    private char[] abscissLetter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'}; // Буквенные обозначения координат по горизонтали
    private int countOfWhite;   // Количество белых фигур на доске
    private int countOfBlack;   // Количество чёрных фигур на доске
    private int pointsOfWhite;  // Сумма очков оставшихся белых фигур в пешках
    private int pointsOfBlack;  // Сумма очков оставшихся чёрных фигур в пешках

    public int getPointsOfWhite() { return pointsOfWhite; }

    public int getPointsOfBlack() { return pointsOfBlack; }

    /**
     * Перевод привычной человеку координаты поля по вертикали в индекс массива, используемый программой
     * @param y координата клетки доски по вертикали
     * @return индекс массива board, соответствующий введённой пользователем координате
     */
    private int ordinate(int y) {
        if(y < 1 || y > 8) { throw new RuntimeException("Ordinate out of board"); }
        return 8 - y;
    }

    /**
     * Перевод привычной человеку координаты поля по горизонтали в индекс массива, используемый программой
     * @param letter буквенная координата клетки доски по горизонтали
     * @return индекс массива board, соответствующий введённой пользователем кооридинате
     */
    private int absciss(char letter) {
        letter = Character.toLowerCase(letter);
        for (int i = 0; i < 8; i++) {
            if(abscissLetter[i] == letter) { return i; }
        }
        throw new RuntimeException("Absciss out of board");
    }

    /**
     * Создаёт доску с набором фигур на начальных позициях, задаёт начальные очки
     */
    public ChessBoard() {
        board = new ChessFigure[8][8];
        board[0][0] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Elephant(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false);
        board[0][5] = new Elephant(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rook(false);

        board[7][0] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Elephant(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
        board[7][5] = new Elephant(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rook(true);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false);
            board[6][i] = new Pawn(true);
        }
        countOfWhite = 16;
        countOfBlack = 16;
        pointsOfWhite = 39;
        pointsOfBlack = 39;
        // Вес короля принят, как 40 пешек, и не учитывается в начальной диспозиции
        // Таким образом, при потере короля очки игрока гарантированно уходят в минус, и партия завершается

    }

    /**
     * Проверка возможности осуществить указанный игроком ход
     * @param row1 координата стартовой клетки по вертикали
     * @param column1 координата стартовой клетки по горизонтали
     * @param row2 координата конечной клетки по вертикали
     * @param column2 координата конечной клетки по горизонтали
     * @param isWhite белыми или чёрными фигурами играет игрок
     * @return true, если указанный ход возможен, false, если невозможен
     */
    private boolean checkTurn(int row1, int column1, int row2, int column2, boolean isWhite) {
        // Для упрощения кода создаём ссылки на стартовое и финишное поле проверяемого хода
        ChessFigure startField = board[row1][column1];
        ChessFigure finishField = board[row2][column2];

        // Направления движения фигуры по клеткам. Потребуются для дальнейших расчётов
        int deltaX = row2 - row1;
        int dX = 0;
        int dY = 0;
        if (deltaX > 0) { dX = 1; }
        if (deltaX < 0) { dX = -1; }
        int deltaY = column2 - column1;
        if (deltaY > 0) { dY = 1; }
        if (deltaY < 0) { dY = -1;}

            // Есть ли фигура на поле, с которого хочет сходить игрок
        if (startField == null){
            System.err.println("На указанном поле нет фигуры. Сделайте ход с другого поля");
            return false;

            // Своей ли фигурой хочет сходить игрок
        } if (startField.isWhite() != isWhite) {
            System.err.println("Указанная фигура принадлежит другому игроку. Выберите фигуру вашего цвета");
            return false;

            // Не собирается ли игрок поставить фигуру на то же поле, с которого её взял
        } if (dX == 0 && dY == 0) {
            System.err.println("Вы пытаетесь поставить фигуру на то же поле, где она уже находится. Введите другое поле назначения");
            return false;

            // Ходит ли выбранная игроком фигура так, как ей указал сходить игрок. Не выполняется для пешки
        } if(!startField.isPawn() && !startField.can(row1, column1, row2, column2)) {
            System.err.println("Фигура " + startField.getName() + " не ходит таким образом");
            return false;

            // Если игрок указал сходить пешкой: ходит ли пешка таким образом
            // Учтена особенность пешки рубить наискосок
        } if (startField.isPawn()) {
            if (startField.can(row1, column1, row2, column2)) {
                if (finishField != null && finishField.isWhite() != isWhite) {
                    System.err.println("Пешка может рубить только наискосок");
                    return false;
                }
            } else {
                boolean pawnIsCan = false;
                if ((startField.isWhite() && deltaX == -1 || !startField.isWhite() && deltaX == 1)  && (deltaY == 1 || deltaY == -1)) {
                    pawnIsCan = finishField != null;
                }
                if (!pawnIsCan) {
                    System.err.println("Фигура пешка не ходит таким образом");
                    return false;
                }
            }

            // Не занято ли поле, куда хочет сходить игрок, фигурой своего цвета
        } if (finishField != null && finishField.isWhite() == isWhite) {
            System.err.println("Поле, на которое вы пытаетесь сходить, занято другой вашей фигурой. Введите другое поле назначения");
            return false;

            // Нет ли на линии хода других фигур. Не выполняется для фигуры типа конь.
        } if (!startField.isKnight()) {
            int x = row1 + dX;
            int y = column1 + dY;
            while (x != row2 || y != column2){
                if (board[x][y] != null) {
                    System.err.println("Фигура " + startField.getName() + " не может перепрыгивать через другие фигуры. Это может делать только конь");
                    return false;
                }
                x+=dX;
                y+=dY;
            }
        }
            // Если выполнены все предыдущие условия, ход возможен
        return true;
    }

    public boolean move(char x1, int y1, char x2, int y2, boolean isWhite) {
        // Перевод введённых игроком координат во внутрипрограммный формат и проверка их валидности
        int row1, column1, row2, column2;
        try {
            row1 = ordinate(y1);
            column1 = absciss(x1);
        }
        catch (Exception e) {
            System.err.println("На доске нет поля " + x1 + y1);
            return false;
        }
        try {
            row2 = ordinate(y2);
            column2 = absciss(x2);
        }
        catch (Exception e) {
            System.err.println("На доске нет поля " + x2 + y2);
            return false;
        }
        if(checkTurn(row1, column1, row2, column2, isWhite)){
            // Если ходим пешкой, лишаем её девственности,
            // т.к. после первого хода пешка ходит только на одну клетку вперёд
            if (board[row1][column1].isPawn()) { board[row1][column1].makeTurn(); }

            // Обработка события, когда при совершении хода была срублена фигура
            if (board[row2][column2] != null && board[row2][column2].isWhite() != isWhite) {
                if (isWhite) {
                    countOfBlack--;
                    pointsOfBlack-= board[row2][column2].getPoints();
                }
                else {
                    countOfWhite--;
                    pointsOfWhite-= board[row2][column2].getPoints();
                }
            }
            ChessFigure figure = board[row1][column1];
            board[row2][column2] = figure;
//            figure.setXY(row2,column2);
            board[row1][column1] = null;
            return true;
        } else return false;
    }

    @Override
    /**
     * Отрисовка игрового поля и информации о партии
     */
    public String toString() {
        StringBuilder s =new StringBuilder();
        s.append(' ');
        for (int i = 0; i < 8; i++) {
            s.append(" " + abscissLetter[i]);
        }
        s.append("\n");
        for (int i = 0; i < 8; i++) {
            s.append(8 - i);
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    s.append("|_");
                } else {
                    s.append("|").append(board[i][j]);
                }
            }
            s.append("|" + (8 - i));
            if (i == 0) { s.append("  Белые: количество фигур: " + countOfWhite); }
            if (i == 1) { s.append("  Белые: количество очков: " + pointsOfWhite); }
            if (i == 4) { s.append("  Чёрные: количество фигур: " + countOfBlack); }
            if (i == 5) { s.append("  Чёрные: количество очков: " + pointsOfBlack); }
            s.append("\n");
        }
        s.append(' ');
        for (int i = 0; i < 8; i++) {
            s.append(" " + abscissLetter[i]);
        }
        return s.toString();
    }
}
