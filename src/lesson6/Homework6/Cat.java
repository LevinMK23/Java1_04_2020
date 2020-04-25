package lesson6.Homework6;

public class Cat extends Animal {
    static int catCount;

    public Cat () {
        catCount++;
        setType("Cat");
        setName("BingoBom");


    }

    @Override
    public void running(int distance) {
        int maxRunningDistance = 200;
        if (distance < maxRunningDistance) {
            System.out.println(getName() + " say: I run " + distance + "m! Meow!");
        } else {
            System.out.println(getName() + " say: I'm a cat! I can't! I went to sleep!");
        }
    }

    @Override
    public void swimming(int distance) {
        System.out.println(getName() + " say: I cant swim! Meow!");
    }
}
