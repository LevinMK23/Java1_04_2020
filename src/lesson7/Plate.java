package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if ((getFood() - n) < 0 || n < 0) return false;
        addFood(-n);
        return true;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }
}
