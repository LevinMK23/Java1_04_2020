package lesson6.Homework6;

public abstract class Animal {
    private String type;
    private String name;
    static int animalCount;

    public Animal() {
        animalCount++;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void running(int distance);

    public abstract void swimming(int distance);
}
