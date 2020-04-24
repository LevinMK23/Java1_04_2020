package ru.geekbrains.catch_the_drop;

import java.util.*;

public class Dog extends Animal{
    static int dogs;

    public Dog(){
        dogs++;
        setType("Dog");
    }



    @Override
    public void run(int dist) {
        int maxRunningDistance = 500;
        if (dist < maxRunningDistance) {
            System.out.printf("\n" + getName() + " говорит, что пробежал %d метров, вот молодец, нужно дать ему вкусняшку!", dist);
        } else {
            System.out.println(getName() + " говорит, что он устал и хочет спать, бедный песик, не загоняй его так...");
        }
    }

    @Override
    public void swim(int dist) {
        int maxSwimmingDistance = 10;
        if (dist < maxSwimmingDistance) {
            System.out.printf("\n" + getName() + " говорит, что проплыл %d метров, вот молодец, нужно дать ему вкусняшку!", dist);
        } else {
            System.out.println(getName() + " говорит, что это слишком большая дистанция для него!");
        }
    }
}

