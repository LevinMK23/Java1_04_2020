package lesson7;

import java.util.ArrayList;

class CatTest {

    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();

        cats.add(new Cat(6, "Foo"));
        cats.add(new Cat(10, "Bar"));
        cats.add(new Cat(12, "Zzz"));
        Plate p = new Plate(16);
        for (Cat c : cats
        ) {
            c.eat(p);
        }
        System.out.println(cats);
    }

}