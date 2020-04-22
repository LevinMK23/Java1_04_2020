package lesson6;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Semen");
        Cat cat2 = new Cat("Fedor");

        cat1.run(300);
        cat2.run(200);

        Dog dog1 = new Dog("Sharik");
        Dog dog2 = new Dog("Tuzik");

        dog1.swim(15);
        dog2.run(450);

        cat1.printCount();
        cat1.printCountCat();
        dog1.printCountDog();
    }
}
