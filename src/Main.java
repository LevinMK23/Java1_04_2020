
public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Dod", "Dog1");
        Cat cat1 = new Cat("Cat", "Cat1");
        dog1.run(499);
        dog1.swim(9);
        cat1.run(201);
        cat1.swim(5);
        System.out.println("Кол-во кото-собачек: " + Animal.getCounter());
    }
}
