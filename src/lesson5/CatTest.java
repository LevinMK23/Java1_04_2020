package lesson5;

import lesson5.Cat;

import java.util.Random;

public class CatTest {

    // IpLookUp -> ip ->
    // Переводчик
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Boris");
        Cat cat3 = new Cat("Murzik");
        cat1.live();
        cat3.live();
        cat1.say();
        cat1.run(new Random().nextInt(1000));
        cat1.jump(1);
        System.out.println(cat2.getAge());
        cat1.setAge(17);
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
    }
}
