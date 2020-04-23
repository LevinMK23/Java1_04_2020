package lesson6.homework;

public class Dog extends Animal {
    private int runLimit = 500;
    private int swimLimit = 10;

    public Dog(String type, String name) {
        super(type, name);
    }

    @Override
    public void run(int distance) {
        if (runLimit >= distance) {
            super.run(distance);
        } else System.out.println(getType() + " " + getName() + "  says: This is a very long distance for me\nWoof!!!");
    }

    @Override
    public void swim(int distance) {
        if (swimLimit >= distance) {
            super.swim(distance);
        } else System.out.println(getType() + " " + getName() + " says: This is a very long distance for me\nWoof!!!");
    }
}
