package lesson6.homework;

import java.util.Scanner;

public class TestAnimals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distRun = Math.random() * 1000;
        double distJump = Math.random() * 3;
        double distSwim = Math.random() * 0; // some cats can swim, but not this =)
        Cat cat = new Cat(distRun, distJump, distSwim);

        distRun = Math.random() * 5000;
        distJump = Math.random() * 2;
        distSwim = Math.random() * 300;
        Dog dog = new Dog(distRun, distJump, distSwim);

        // Get max values to motions
        System.out.println(
                "The distance a cat can run: " + cat.getDistRun() + "m \n" +
                        "The distance a dog can run: " + dog.getDistRun() + "m"
        );

        System.out.println(
                "A cat can jump: " + cat.getDistJump() + "m\n" +
                        "A dog can jump: " + dog.getDistJump() + "m"
        );

        System.out.println(
                "A cat can swim: " + cat.getDistSwim() + "m\n" +
                        "A dog can swim: " + dog.getDistSwim() + "m"
        );

        // Trying to run
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

        // Trying to jump
        System.out.println("Enter the height to jump:");
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

        // Trying to swim
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
