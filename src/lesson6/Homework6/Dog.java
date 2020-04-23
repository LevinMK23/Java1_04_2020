package lesson6.Homework6;

public class Dog extends Animal {
    static int dogCount = 0;

    public Dog () {
        setType("Dog");
        setName("BangoBom");
        dogCount++;
    }

    @Override
    public void running(int distance) {
        int maxRunningDistance = 500;
        if (distance < maxRunningDistance) {
            System.out.println(getName() + " say: I run " + distance + "m! Bark!");
        } else {
            System.out.println(getName() + " say: I'm a dog! I can't! I went to sleep!");
        }
    }

    @Override
    public void swimming(int distance) {
        int maxSwimmingDistance = 10;
        if (distance < maxSwimmingDistance) {
            System.out.println(getName() + " say: I swim " + distance + "m! Bark!");
        } else {
            System.out.println(getName() + " say: Too far for me!");
        }
    }
}
