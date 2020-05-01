package lesson6.homework;

public class Rook extends ChessFigure {

    @Override
    public boolean isKnight() {
        return false;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public void makeTurn() { }

    public Rook(boolean isWhite) {
        super(isWhite, "ладья", 'Л', 5);
    }

    @Override
    public boolean can(int startX, int startY, int finishX, int finishY) {
        int dx = finishX - startX;
        int dy = finishY - startY;
        return dy == 0 || dx == 0;
    }
}
