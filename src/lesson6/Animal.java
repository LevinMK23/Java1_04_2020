package ru.geekbrains.catch_the_drop;

public abstract class Animal {
    private String type;
    private String name;
    static int animals;

    public Animal(){
        animals++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void run(int dist);
    public abstract void swim(int dist);
}
