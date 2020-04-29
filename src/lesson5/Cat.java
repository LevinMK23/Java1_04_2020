package Lesson5;

import java.util.Random;

public class Cat {
    private String name;
    private CatColor color;
    private int age, runLimit, jumpLimit, foodLimit, nascalVtapkiLimit;
    private final static Random rnd = new Random();

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", age=" + age +
                ", runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                ", foodLimit=" + foodLimit +
                ", nascalVtapkiLimit=" + nascalVtapkiLimit +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Cat(String name) {
        this.name = name;
        age = 1;
        color = CatColor.values()[rnd.nextInt(CatColor.values().length)];
        runLimit = rnd.nextInt(1000);
        jumpLimit = rnd.nextInt(5);
        foodLimit = rnd.nextInt(500);
        nascalVtapkiLimit = rnd.nextInt(5);
    }

    public void live() {
        age++;
    }

    public void say() {
        System.out.println("МААААААУ");
    }

    public void run(int limit) {
        if (runLimit < limit) {
            System.out.println("Я смОг пробежать " + runLimit + " метров!");
        }
    }

    public void jump(int limit) {
        if (jumpLimit < limit) {
            System.out.println("Я смОг прыгнуть на " + jumpLimit + " метров!");
        }
    }

    public void food(int limit) {
        if (foodLimit < limit) {
            System.out.println("И поэтому я съем " + foodLimit + " грамм вкусняшки !");
        }
    }

    public void nascalVtapki(int limit) {
        //new Cat("Laska") {
        if (nascalVtapkiLimit < limit) {
            System.out.println("А раз ты такой жмот я " + nascalVtapkiLimit + " раза нассу тебе в тапки :) ");
        }
    }
}


