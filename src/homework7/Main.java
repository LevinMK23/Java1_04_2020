package homework7;

import java.util.Random;

public class Main {

    private static final Random rnd = new Random();

    public static void main(String[] args) {
        String[] catNames = {"Molly", "Felix", "Smudge", "Sooty", "Tiger", "Charlie", "Alfie", "Oscar"};
        Cat[] cats = new Cat[5];

        Plate plate = new Plate(rnd.nextInt(100));
        System.out.println("Plate: " + plate.getFood());
        System.out.println();

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(catNames[rnd.nextInt(catNames.length)], rnd.nextInt(25));
        }

        System.out.println("Feeding cats:");
        for (Cat cat: cats) {
            cat.eatFrom(plate);
        }

        System.out.println();
        System.out.println("Cats info:");
        for (Cat cat: cats) {
            System.out.println(cat);
        }
    }
}