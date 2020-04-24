package LessonOOP;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        System.out.println(cat1.jump(200));
        System.out.println(cat1.run(300));
        System.out.println(cat1.swim(200));
        System.out.println(dog1.run(200));
        System.out.println(dog1.jump(200));
        System.out.println(dog1.swim(200));
    }
}
