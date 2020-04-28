package HomeWork6;

public abstract class Animal {
    static int animalCount;
    private String type;
    private String name;

    public Animal() {
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public abstract void running(int distance);

    public abstract void swimming(int distance);
}
