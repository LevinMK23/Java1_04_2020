package lesson6.animals;

public abstract class Animal {

    private String type;

    protected void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void say();

    public abstract void swim();
}
