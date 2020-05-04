package HomeWork.lesson_7;

import java.awt.*;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public int getFood(){return food;}
    public void addFood(int food){this.food = this.food + food;}

    public void decreaseFood(int n) {
        food -=n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
