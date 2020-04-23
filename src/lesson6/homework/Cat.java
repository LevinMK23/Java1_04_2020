package lesson6.homework;

public class Cat extends Animal {
    private int runLimit = 200;

    public Cat(String type, String name) {
        super(type, name);
    }

    @Override
    public void run(int distance) {
        if (runLimit >= distance) {
            super.run(distance);
        } else System.out.println(getType() + " " + getName() + "  says: This is a very long distance for me\nMeow!!!");
    }

    @Override
    public void swim(int distance) {
        System.out.println(getType() + " " + getName() + " says: Unfortunately, cats doesn't swim");
    }
}
