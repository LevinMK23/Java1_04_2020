package lesson7.homework7;

import java.util.concurrent.Callable;

public class Test {


    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Myrzik", 20),
                new Cat("Bobik", 30),
                new Cat("Monya", 130)
        };
        Plate plate = new Plate(100);
        plate.info();

        for (Cat cat: cats) {
            cat.eat(plate,100);
        }
        plate.add(20);
        plate.info();

    }
}
