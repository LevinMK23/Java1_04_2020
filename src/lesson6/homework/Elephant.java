package lesson6.homework;

public class Elephant extends ChessFigure{

    public Elephant(boolean isWhite) { super(isWhite, "слон", 'C', 3); }

    @Override
    public void makeTurn() {  }

    @Override
    public boolean isKnight() {
        return false;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean can(int startX, int startY, int finishX, int finishY) {
        return Math.abs(finishY - startY) == Math.abs(finishX - startX);
    }
}
