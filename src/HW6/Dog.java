package HW6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    void run(int distance) {
        distance = distance > 500 ? 500 : distance;
        System.out.println(getName() + " пробежал " + distance + " м.");
    }

    @Override
    void swim(int distance) {
        distance = distance > 10 ? 10 : distance;
        System.out.println(getName() + " проплыл " + distance + " м.");
    }
}
