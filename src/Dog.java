public class Dog extends Animal {

    public Dog(String type, String name) { super(type, name); }

    @Override
    public void run(int distance) {
        int runLimit = 500;
        if (runLimit <= distance) System.out.println(getType() + " " + getName() + ": Нет");
        else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        int swimLimit = 10;
        if (swimLimit <= distance) System.out.println(getType() + " " + getName() + ": Нет");
        else super.swim(distance);
    }
}