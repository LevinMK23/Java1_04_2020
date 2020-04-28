package HomeWork7;

import java.util.InputMismatchException;

public class Plate {
    private int food = 100;
    private int foodQuality = 100;

    public Plate(int food, int foodQuality) {
        if (food > 0 && foodQuality > 0) {
            this.food = food;
            this.foodQuality = foodQuality;
        } else {
            throw new InputMismatchException("Cats bite you. You are dead.");
        }
    }

    public void addFoodToThePlate(int food) {
        if (food > 0) {
            this.food += food;
        } else {
            System.out.println("Ops! Cat can bite you!");
        }
    }

    public int getFood() {
        return food;
    }

    public int getFoodQuality() {
        return foodQuality;
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        } else {
            System.out.println("Can't do it: \"Not enough food in the plate\"");
        }
    }

    public void info() {
        System.out.println("The amount of food in plate: " + food);
    }


}
