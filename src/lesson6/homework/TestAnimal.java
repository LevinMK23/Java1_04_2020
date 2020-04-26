package lesson6.homework;

import java.util.Scanner;

public class TestAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distRun = Math.random() * 500;
        double distJump = Math.random() * 3;
        double distSwim = Math.random() * 0;
        Cat cat = new Cat(distRun, distJump, distSwim);

        distRun = Math.random()*2000;
        distJump = Math.random()*2;
        distSwim = Math.random()*100;
        Dog dog = new Dog(distRun, distJump, distSwim);

        //run
        System.out.println(
            "The distance a cat can run: " + cat.getDistRun() + "m \n" +
            "The distance a dog can run: " + dog.getDistRun() + "m"
        );
        System.out.println("Enter your running distance:");
        double distance = scanner.nextDouble();
        System.out.println(
            "The cat tried to run(" + distance + "). " +
            "Result: " + cat.run(distance)
        );
        System.out.println(
            "The dog tried to run(" + distance + "). " +
            "Result: " + dog.run(distance)
        );
        System.out.println();
        //jump
        System.out.println(
            "A cat can jump: " + cat.getDistJump() + "m\n" +
            "A dog can jump: " + dog.getDistJump() + "m"
        );
        System.out.println("Enter the height of an obstacle:");
        distance = scanner.nextDouble();
        System.out.println(
            "The cat tried to jump(" + distance + "). " +
            "Result: " + cat.jump(distance)
        );
        System.out.println(
            "The dog tried to jump(" + distance + "). " +
            "Result: " + dog.jump(distance)
        );
        System.out.println();
        //swim
        System.out.println(
            "A cat can swim: " + cat.getDistSwim() + "m\n" +
            "A dog can swim: " + dog.getDistSwim() + "m"
        );
        System.out.println("Enter your swimming distance:");
        distance = scanner.nextDouble();
        System.out.println(
            "The cat tried to swim(" + distance + "). " +
            "Result: " + cat.swim(distance)
        );
        System.out.println(
            "The dog tried to swim(" + distance + "). " +
            "Result: " + dog.swim(distance)
        );
    }
}
