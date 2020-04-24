package ru.geekbrains.catch_the_drop;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.setName("lalka - kusalka");
        cat1.run(50);
        Cat cat2 = new Cat();
        cat2.setName("murzik");
        cat2.swim(5);
        Cat cat3 = new Cat();
        cat3.setName("Garfield");
        Cat cat4 = new Cat();
        cat4.setName("vkusnoed");
        Cat cat5 = new Cat();
        cat5.setName("mped");
        Cat cat6 = new Cat();
        cat6.setName("лалка-палка");
        System.out.println("Всего котов: " + Cat.cats);

        Dog dog1 = new Dog();
        dog1.setName("песалалка");
        dog1.run(100);
        Dog dog2 = new Dog();
        dog2.setName("мр морган");
        dog2.swim(7);
        Dog dog3 = new Dog();
        dog3.setName("жрун");
        dog3.run(70);
        dog3.swim(3);
        Dog dog4 = new Dog();
        dog4.setName("морган");
        Dog dog5 = new Dog();
        dog5.setName("пес");
        System.out.println("Всего собак: " + Dog.dogs);
        System.out.println("Всего животных: " + Animal.animals);
    }
}
