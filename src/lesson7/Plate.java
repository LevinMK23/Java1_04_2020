package lesson7;


import java.util.Random;

public class Plate {
    private int food;
    final Random rnd = new Random(50);
    private int limitFood;

    public Plate(int food) {
        this.food = food;
        this.limitFood = rnd.nextInt(500);
    }

    public void info() {
        System.out.println("plate: " + food + ", limit: " + limitFood);
    }

    public void decreaseFood(int n) {
        food = (food < n) ? Integer.parseInt("В тарелке не хватает еды") : (food - n);
    }

    public void increaseFood(int add) {
        int full = this.food + add;
        if (full <= this.limitFood) {
            this.food += add;
        }else {
            System.out.printf("Для тарелки превышен лимит вместимости: %d. Сейчас в тарелке: %d\n", + this.limitFood, this.food);
        }


    }
}
