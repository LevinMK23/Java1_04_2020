package lesson7.homework;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public boolean getSatiety() { return satiety; }

    public Cat(String name) {
        Random random = new Random();
        this.name = name;
        this.appetite = 10 + random.nextInt(31);
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (plate.getCountOfFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }

    @Override
    public String toString() {
        String isSatiety = "голоден";
        if (satiety) { isSatiety = "сыт"; }
        return name + " " + isSatiety + ". Аппетит = " + appetite;
    }
}
