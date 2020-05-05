package lesson7.homework;

public class Plate {
    private int countOfFood;

    public int getCountOfFood() { return countOfFood; }

    public Plate(int countOfFood) {
        this.countOfFood = countOfFood;
    }

    public void decreaseFood(int decreaseCount) { countOfFood -= decreaseCount; }

    public void increaseFood() { countOfFood += 10; }

    @Override
    public String toString() {
        return "Еды в тарелке: " + countOfFood;
    }
}
