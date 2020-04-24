package HW_Lesson6;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Васька");
        Cat cat2 = new Cat("Билл");

        cat1.swim(15);
        cat2.swim(5);
        cat1.run(300);
        cat2.run(200);
        cat1.jump(2);
        cat2.jump(3);

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");

        dog1.swim(15);
        dog2.swim(5);
        dog1.run(620);
        dog2.run(450);
        dog1.jump(0.4);
        dog2.jump(0.64);


        cat1.printCount();
        cat1.printCountCat();
        dog1.printCountDog();
    }
}