package lesson6.Home_work_lesson_6;

public class AnimalTest {
    public static void main(String[] args) {
        int counterCat = 0;
        int counterDog = 0;

        Cat cat1 = new Cat("Барсик"); counterCat++;
        Cat cat2 = new Cat("Мурзик"); counterCat++;
        Cat cat3 = new Cat("Клепа"); counterCat++;

        Dog dog1 = new Dog("Шарик"); counterDog++;
        Dog dog2 = new Dog("Рекс"); counterDog++;

        cat1.nameInfo();
        cat1.voice();
        cat1.run(50);
        cat1.swim(10);

        System.out.println("------------------------");

        cat2.nameInfo();
        cat2.voice();
        cat2.run(150);
        cat2.swim(15);

        System.out.println("------------------------");

        cat3.nameInfo();
        cat3.voice();
        cat3.run(250);
        cat3.swim(20);

        System.out.println("------------------------");

        dog1.nameInfo();
        dog1.voice();
        dog1.run(300);
        dog1.swim(15);

        System.out.println("------------------------");

        dog1.nameInfo();
        dog1.voice();
        dog1.run(600);
        dog1.swim(7);

        System.out.println("------------------------");

        System.out.println("Всего котов: " + counterCat + " ;" + " Всего собак: " + counterDog);


    }
}
