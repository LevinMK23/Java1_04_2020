package lesson6.homework;

public class Animal {
    private String type, name;
    protected static int animalCounter = 0;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
        animalCounter++;
    }


    public String getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public void run(int distance) {
        System.out.println(getType() + " " + getName() + " ran" + " " + distance + "m");
    }

    public void swim(int distance) {
        System.out.println(getType() + " " + getName() + " swam" + " " + distance + "m");
    }
}

