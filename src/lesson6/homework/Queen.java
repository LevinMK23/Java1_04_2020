package lesson6.homework;

public class Queen extends ChessFigure {

    public Queen(boolean isWhite) { super(isWhite, "ферзь", 'Ф', 9); }

    @Override
    public boolean isKnight() {
        return false;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public void makeTurn() {}

    @Override
    public boolean can(int startX, int startY, int finishX, int finishY) {
        int dx = finishX - startX;
        int dy = finishY - startY;
        return dx == 0 || dy == 0 || Math.abs(dx) == Math.abs(dy);
    }
}
