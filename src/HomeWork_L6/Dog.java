package HomeWork_L6;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Dog extends Animal {
    private static Random rnd = new Random();
    private double jumpLimit;
    private double n = 0.5;
    private int runLimit, swimLimit;

    public Dog() {
        setTypeAnimal("Dog");
        runLimit = 1 + rnd.nextInt(rnd.nextInt(800));
        jumpLimit = 0.1 + rnd.nextDouble();

        swimLimit = rnd.nextInt(10);
    }


    @Override
    public void say() {
        System.out.println("Wow");

    }

    @Override
    public void swim() {

    }


    @Override
    public void swim(int limit) {
        if (swimLimit > limit) {
            System.out.println("I'm swimming " + limit + " meters, but my limit " + swimLimit + " meters");
        } else {
            System.out.println("I can't run " + limit + " meters, my limit " + swimLimit + " meters");
        }

    }


    @Override
    public void jump(double limit) {

        ;
        if (jumpLimit > limit) {
            System.out.println("I jumped " + limit + " meters, but my limit " + String.format("%8.2f", jumpLimit));

        } else {

            System.out.println("I can't run " + limit + " meters, my limit " + String.format("%8.2f", jumpLimit) + " meters");
        }

    }


    @Override
    public void run(int limit) {
        if (runLimit > limit) {
            System.out.println("I'm running " + limit + " meters, but my limit " + runLimit + " meters");
        } else {
            System.out.println("I can't run " + limit + " meters, my limit " + runLimit + " meters");
        }

    }
}
