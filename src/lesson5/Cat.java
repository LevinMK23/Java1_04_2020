package lesson5;

import java.util.Random;

public class Cat {

    private String name;
    private CatColor color;
    private int age, runLimit, jumpLimit;
    private final static Random rnd = new Random();

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", age=" + age +
                ", runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
        age = 0;
        color = CatColor
                .values()[rnd.nextInt(CatColor.values().length)];
        runLimit = 100 + rnd.nextInt(1000);
        jumpLimit = 1 + rnd.nextInt(4); // [0; 3]
    }



    void live() {
        age++;
    }

    public void say() {
        System.out.println("MEOW");
    }

    public void run(int limit) {
        if (runLimit > limit) {
            System.out.println("Я пробежал " + limit + " метров!");
        }
    }

    public void jump(int limit) {
        if (jumpLimit > limit) {
            System.out.println("Я прыгнул на " + limit + " метров!");
        }
    }

    public void mstitVtapki() {

    }

}
