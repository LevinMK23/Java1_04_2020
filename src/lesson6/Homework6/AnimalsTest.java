package lesson6.Homework6;


public class AnimalsTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Barsik");
        cat.running(200);
        Cat cat1 = new Cat();
        cat1.running(50);
        Cat cat2 = new Cat();
        cat2.setName("Pepega");
        cat2.swimming(5);
        Cat cat3 = new Cat();
        cat3.setName("Garfield");
        Cat cat4 = new Cat();
        cat4.setName("Babuleh");
        Cat cat5 = new Cat();
        cat5.setName("Chomusuke");
        Cat cat6 = new Cat();
        cat6.setName("Mrs. Norris");
        System.out.println("Всего котиков: " + Cat.catCount);

        Dog dog = new Dog();
        dog.setName("Brian Griffin");
        Dog dog1 = new Dog();
        dog.setName("Oswald");
        dog.running(100);
        Dog dog2 = new Dog();
        dog.setName("Жратико");
        dog2.swimming(7);
        Dog dog3 = new Dog();
        dog.setName("Всёпокусатико");
        dog3.running(70);
        dog3.swimming(3);
        Dog dog4 = new Dog();
        dog.setName("Sadaharu");
        Dog dog5 = new Dog();
        dog.setName("Cake");
        System.out.println("Всего собачек: " + Dog.dogCount);
        System.out.println("Всего животных: " + Animal.animalCount);
    }
}
