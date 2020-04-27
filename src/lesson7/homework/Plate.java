package lesson7.homework;

import java.util.InputMismatchException;

public class Plate {
    private int amount;

    Plate(int amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.err.println("Incorrect details given. You can't use negative numbers.");
            throw new InputMismatchException();
        }
    }

    @Override
    public String toString() { return "Plate: " + amount; }

    void removeFood(int satisfaction) {
        if (amount >= satisfaction) {
            amount -= satisfaction;
        }
    }

    int getFood() { return amount; }

    void addMoreFood(int a) { amount += a; }
}
