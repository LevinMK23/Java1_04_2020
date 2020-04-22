package HW6;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        countCat++;
    }

    @Override
    void run(int distance) {
        distance = distance > 200 ? 200 : distance;
        System.out.println(getName() + " пробежал " + distance + " м.");
    }

    @Override
    void swim(int distance) {
        System.out.println(getName() + " не умеет плавать!");
    }
}
