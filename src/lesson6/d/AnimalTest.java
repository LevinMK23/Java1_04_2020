package lesson6.d;

import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;
import lesson6.animals.Jumpable;
import lesson6.animals.Runnable;

public class AnimalTest {

    public static void sayAndGetType(Animal animal) {
        animal.say();
        System.out.println(animal.getType());
    }

    public static void swim(Animal animal) {
        animal.swim();
    }

    public static void jump(Jumpable jumpable) {
        jumpable.jump();
    }

    public static void run(Runnable runnable) {
        runnable.run();
    }

    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        sayAndGetType(cat);
        sayAndGetType(dog);
        swim(dog);
        //swim(cat);
        Jumpable cat1 = new Cat();
        Jumpable dog1 = new Dog();
        jump(cat1);
        jump(dog1);
        run((Runnable) cat1);
        run((Runnable) dog1);
    }
}
