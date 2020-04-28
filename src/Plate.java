public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food - n < 0) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

