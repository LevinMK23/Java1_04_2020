package lesson7.HW7;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Кот1", 20));
        cats.add(new Cat("Кот2", 20));
        cats.add(new Cat("Кот3", 20));
        cats.add(new Cat("Кот4", 20));
        cats.add(new Cat("Кот5", 20));
        cats.add(new Cat("Кот6", 10));

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.isFullness());
        }
        plate.addFood(10);
        cats.get(5).eat(plate);
        System.out.println(cats.get(5).isFullness());
    }
}
