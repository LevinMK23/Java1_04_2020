package lesson6.homework;

public class Knight extends ChessFigure {

    @Override
    public boolean isKnight() {
        return true;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public void makeTurn() { }

    public Knight(boolean isWhite) {
        super(isWhite, "конь", 'К', 3);
    }

    @Override
    public boolean can(int startX, int startY, int finishX, int finishY) {
        int dx = finishX - startX;
        int dy = finishY - startY;
        return dx * dx + dy * dy == 5;
    }
}
