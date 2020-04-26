package lesson7.HW7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(Cat cat) {
        if (food < cat.getAppetite()) {
            System.out.printf("Для кота %s недостаточно еды \n", cat.getName());

            return;
        }
        food -= cat.getAppetite();
        cat.setFullness(true);
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int n) {
        this.food += n;
    }
}
