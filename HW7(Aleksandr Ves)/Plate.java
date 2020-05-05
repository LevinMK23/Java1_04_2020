package geekbrains.lession0;

public class Plate {
    private int food;


    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else
            System.err.println("Не хватило еды");
        return false;
    }
    public void addFood (int x) {
        food+=x;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

