package HomeWork7;

import java.util.Random;

public class Cat {
    Random random = new Random();
    private String name;
    private int foodQuality;
    private int satiety = random.nextInt(50) + 10;
    public Cat (String name, int foodQuality) {
        this.foodQuality = foodQuality;
        this.name = name;
    }

    public void getSatiety () {
        System.out.println(name + " want to eat! Satiety: " + satiety);
    }

    public void eat (Plate p) {
        if (p.getFoodQuality() >= foodQuality && p.getFood() >= satiety) {
            p.decreaseFood(satiety);
        } else if (p.getFood() < satiety) {
            System.out.println("The plate is almost empty! Hurry up!");
        }  else {
            System.out.println(name + " is don't want to eat it. He's an offense at you.");
        }
    }
}
