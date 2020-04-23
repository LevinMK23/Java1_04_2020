package lesson6.homework;

public class AnimalTest {

    public static void main(String[] args) {
        Dog dog1 = new Dog("DOG", "Sharik");
        Cat cat1 = new Cat("CAT", "Tom");
        dog1.run(10);
        dog1.swim(10);
        cat1.run(5);
        cat1.swim(5);
        System.out.println("The number of created animals is: " + Animal.animalCounter);
    }
}
