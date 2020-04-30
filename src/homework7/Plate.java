package homework7;

public class Plate {
    private int food;

    public Plate() {
    }

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void incFood(int food) {
        if (food > 0) {
            this.food += food;
        }
    }

    public void decFood(int food) throws RuntimeException {
        if (this.food < food) {
            throw new RuntimeException("There is not enough food in plate");
        } else {
            this.food -= food;
        }
    }
}
