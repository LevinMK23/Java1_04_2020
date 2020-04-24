package ru.geekbrains.catch_the_drop;

public class Cat extends Animal {
    static int cats;

    public Cat() {
        cats++;
        setType("Cat");
    }

    @Override
    public void run(int dist) {
        int maxRunDist = 200;
        if (dist < maxRunDist){
            System.out.printf("\n" +getName() + " говорит, что пробежал + %d метров", dist);
        } else {
            System.out.printf("\n" +getName() + " говорит, что не может пробежать так много и хочет спать..., чертов кот...");
        }
    }

    @Override
    public void swim(int dist) {
        System.out.println("\n" + getName() + " говорит, что не может плавать..., бесполезное создание)");
    }
}
