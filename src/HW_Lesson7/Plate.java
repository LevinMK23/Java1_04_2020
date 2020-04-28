package lesson7.HW;

import java.util.InputMismatchException;

public class Plate {
    private int amount;

    Plate(int amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.err.println("Не может быть отрицательное значение");
            throw new InputMismatchException();
        }
    }

    @Override
    public String toString() { return "В тарелке осталось: " + amount + "г."; }

    void removeFood(int food) {
        if (amount >= food) {
            amount -= food;
        }
    }

    int getFood() { return amount; }

    void addFood(int a) { amount += a; }
}