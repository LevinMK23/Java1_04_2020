package lesson6.homework;

/**
 * Абстрактный класс родитель всех шахматных фигур
 */
public abstract class ChessFigure {

    private final int points;       // Стоимость фигуры в пешках. Требуется для расчёта условия победы
    private final boolean isWhite;  // Фигура может быть белой или чёрной
    private final String name;      // Наименование фигуры. Используется в пользовательском интерфейсе
    private final char symbol;      // Символ, который будет отображаться в поле на доске

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if(!isWhite) { s.append("\u001B[31m"); } else { s.append("\u001B[32m"); }
        s.append(symbol);
        s.append("\u001B[0m");
        return s.toString();
    }

    public abstract boolean isKnight(); // Конь требует отдельных условий проверки хода
    public abstract boolean isPawn();   // Пешка требует отдельных условий проверки хода
    public abstract void makeTurn();    // Отмечает фигуру, которой уже ходили. Требуется для пешки

    public String getName() { return name; }

    public boolean isWhite() { return isWhite; }

    public int getPoints() { return points; }

    public ChessFigure(boolean isWhite, String name, char symbol, int points) {
        this.isWhite = isWhite;
        this.name = name;
        this.symbol = symbol;
        this.points = points;
    }

    /**
     * Функция проверки возможности сделать данной фигурой указанный ход
     * @param startX координата начального поля хода по вертикали
     * @param startY коортината начального поля хода по горизонтали
     * @param finishX координата конечного поля хода по вертикали
     * @param finishY координата конечного поля хода по горизонтали
     * @return true - если фигура может сделать такой ход, false - если не может
     */
    public abstract boolean can(int startX, int startY, int finishX, int finishY);

}
