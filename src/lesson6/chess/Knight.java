package lesson6.chess;

public class Knight extends ChessFigure{

    @Override
    public boolean isKnight() {
        return true;
    }

    public Knight(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean can(int x, int y) {
        if (isInBoard()) {
            int dx = x - getX();
            int dy = y - getY();
            return dx * dx + dy * dy == 5;
        }
        return false;
    }
}
