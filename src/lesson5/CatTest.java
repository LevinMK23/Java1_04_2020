package Lesson5;

import java.util.Random;

public class CatTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Aricha");
        Cat cat2 = new Cat("Laska");
        Cat cat3 = new Cat("Duchka");
        Cat cat4 = new Cat("Murzic");
        cat1.live();
        cat1.say();
        cat1.jump(new Random().nextInt(5));
        cat1.run(new Random().nextInt(1000));
        cat1.food(new Random().nextInt(200));
        cat1.nascalVtapki(new Random().nextInt(5));
        System.out.println(cat1.getAge());
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
    }
}
