package HW6;

public abstract class Animal {

    public static int countCat;
    public static int countDog;
    public static int countAnimal;

    private String name;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public String getName() {
        return name;
    }

    abstract void run(int distance);

    abstract void swim(int distance);

}
