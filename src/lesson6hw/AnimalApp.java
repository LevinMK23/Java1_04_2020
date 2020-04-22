package lesson6hw;

public class AnimalApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Snow");
        Cat cat3 = new Cat("Murzik");
        cat1.run(100);
        cat1.swim(200);
        cat3.run(50);
        cat2.swim(20);
        Dog dog2 = new Dog("Lord");
        Dog dog3 = new Dog("Muhtar");
        dog2.swim(10);
        dog3.swim(18);
        cat1.count();
        dog2.count();
        Animal animal1 = new Animal();
        animal1.count();
    }
}
