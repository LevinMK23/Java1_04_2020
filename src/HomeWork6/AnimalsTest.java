package HomeWork6;

public class AnimalsTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Котя 1");
        cat.running(200);
        Cat cat1 = new Cat();
        cat1.running(50);
        Cat cat2 = new Cat();
        cat2.setName("Котя 2");
        cat2.swimming(5);
        Cat cat3 = new Cat();
        cat3.setName("Garfield");
        Cat cat4 = new Cat();
        cat4.setName("Котя 3");
        Cat cat5 = new Cat();
        cat5.setName("Котя 4");
        Cat cat6 = new Cat();
        cat6.setName("Mr. Noize");
        System.out.println("Всего котиков: " + Cat.catCount);

        Dog dog = new Dog();
        dog.setName("Собачка 1");
        Dog dog1 = new Dog();
        dog.setName("Собачка 2");
        dog.running(100);
        Dog dog2 = new Dog();
        dog.setName("Жратико");
        dog2.swimming(7);
        Dog dog3 = new Dog();
        dog.setName("Собачка 3");
        dog3.running(70);
        dog3.swimming(3);
        Dog dog4 = new Dog();
        dog.setName("Собачка 4");
        Dog dog5 = new Dog();
        dog.setName("Барбос");
        System.out.println("Всего собачек: " + Dog.dogCount);
        System.out.println("Всего животных: " + Animal.animalCount);
    }
}
