package lesson7.homeWork;

import java.util.Arrays;
import java.util.Random;

public class Test implements Eating{
    public static void main(String[] args) {
        Random random = new Random();
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            String name = "Котик" + (i + 1);
            int weight = random.nextInt(10);
            cats[i] = new Cat(name, weight);
        }
        Plate plate = new Plate(1000);
        for (Cat c: cats
             ) {
            c.eat(plate);
            System.out.printf("\nВ тарелке осталось %d гр. еды.", plate.getFood());
        }
        System.out.println();

        for (Cat c:
             cats) {
            System.out.println(c);
        }

    }
}
