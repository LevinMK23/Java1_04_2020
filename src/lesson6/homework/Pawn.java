package lesson6.homework;

public class Pawn extends ChessFigure {
    private boolean isFirstTurn;

    public Pawn(boolean isWhite) {
        super(isWhite, "пешка", 'П', 1);
        isFirstTurn = true;
    }

    @Override
    public void makeTurn() {
        isFirstTurn = false;
    }

    @Override
    public boolean isKnight() {
        return false;
    }

    @Override
    public boolean isPawn() {
        return true;
    }

    @Override
    public boolean can(int startX, int startY, int finishX, int finishY) {
        int dy = finishY - startY;
        if (dy != 0) { return false; }
        int dx = finishX - startX;
        int step = 1;
        if (this.isWhite()) { step*= -1; }
        return dx == step || isFirstTurn && dx == step * 2;
    }
}
