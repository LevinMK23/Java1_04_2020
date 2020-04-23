package homework6;

import java.util.ArrayList;
import java.util.Random;

public class HomeWork6 {
    private static final Random rnd = new Random();

    private static ArrayList<Cat> cats = new ArrayList<>();
    private static ArrayList<Dog> dogs = new ArrayList<>();


    public static void main(String[] args) {
        String[] catNames = {"Molly", "Felix", "Smudge", "Sooty", "Tigger", "Charlie", "Alfie", "Oscar"};
        String[] dogNames = {"Bailey", "Max", "Charlie", "Buddy", "Bella", "Lucy", "Molly", "Daisy"};

        // Spawn Cats
        for (int i = 0; i < rnd.nextInt(5) + 1; i++) {

            Cat cat = new Cat(catNames[rnd.nextInt(catNames.length)],
                    Color.values()[rnd.nextInt(Color.values().length)],
                    rnd.nextInt(16));

            cats.add(cat);
        }

        // Spawn Dogs
        for (int i = 0; i < rnd.nextInt(5) + 1; i++) {
            Dog dog = new Dog(dogNames[rnd.nextInt(dogNames.length)],
                    Color.values()[rnd.nextInt(Color.values().length)],
                    rnd.nextInt(20));

            dogs.add(dog);
        }

        // Random action for Cat
        System.out.println("Cats:");
        for (Cat cat : cats) {
            switch (rnd.nextInt(4)) {
                case 0:
                    cat.voice();
                    break;
                case 1:
                    cat.run(rnd.nextInt(300));
                    break;
                case 2:
                    cat.jump(rnd.nextInt(10));
                    break;
                case 3:
                    cat.swim(rnd.nextInt(200));
                    break;
            }
        }

        System.out.println();

        // Random action for Dog
        System.out.println("Dogs:");
        for (Dog dog : dogs) {
            switch (rnd.nextInt(4)) {
                case 0:
                    dog.voice();
                    break;
                case 1:
                    dog.run(rnd.nextInt(300));
                    break;
                case 2:
                    dog.jump(rnd.nextInt(10));
                    break;
                case 3:
                    dog.swim(rnd.nextInt(200));
                    break;
            }
        }

        // Print stats
        System.out.println();
        System.out.println("Cats population: " + Cat.getPopulation());
        System.out.println("Dogs population: " + Dog.getPopulation());
        System.out.println("Total population: " + (Cat.getPopulation() + Dog.getPopulation()));
    }
}