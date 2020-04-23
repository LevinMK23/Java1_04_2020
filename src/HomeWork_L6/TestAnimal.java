package HomeWork_L6;

public class TestAnimal {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        System.out.println(cat.getTypeAnimal());
        cat.say();
        cat.swim();
        cat.jump(1.5);
        cat.run(150);

        System.out.println(dog.getTypeAnimal());
        dog.say();
        dog.swim(6);
        dog.jump(0.5);
        dog.run(400);


    }
}
