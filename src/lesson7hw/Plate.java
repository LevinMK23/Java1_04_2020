package lesson7hw;

import java.util.InputMismatchException;

public class Plate {
    private int food;

    public Plate(int food) {
        if (food > 0) this.food = food;
        else {
            System.out.println("Указано отрицательное количество еды!");
            throw new InputMismatchException();
        }
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
