package lesson6.homework;

public class King extends ChessFigure {

    public King(boolean isWhite) { super(isWhite, "король", 'Х', 40); }

    @Override
    public boolean isKnight() { return false; }

    @Override
    public boolean isPawn() { return false; }

    @Override
    public void makeTurn() { }

    @Override
    public boolean can(int startX, int startY, int finishX, int finishY) {
        return Math.abs(finishX - startX) <= 1 && Math.abs(finishY - startY) <= 1;
    }
}
