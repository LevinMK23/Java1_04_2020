package HomeWork_L6;

import java.util.Random;

public class Cat extends Animal {

    private static Random rnd = new Random();
    private double jumpLimit;
    private int runLimit;

    public Cat() {
        setTypeAnimal("Cat");
        runLimit = 1 + rnd.nextInt(200);
        jumpLimit = rnd.nextInt(3);
    }


    @Override
    public void say() {
        System.out.println("Meow");
    }

    @Override
    public void swim() {
        System.out.println("I con't swimming!!");
    }

    @Override
    public void swim(int limit) {

    }

    @Override
    public void jump(double limit) {
        if (jumpLimit > limit) {
            System.out.println("I'm jumped " + limit + " meters, but my limit " + jumpLimit + " meters");
        } else {
            System.out.println("I can't jump " + limit + " meters, my limit " + jumpLimit + " meters");
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
