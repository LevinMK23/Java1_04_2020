package HomeWork_L6;

public abstract class Animal {
    private String typeAnimal;

    protected void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public abstract void say();

    public abstract void swim();

    public abstract void swim(int limit);

    public abstract void jump(double limit);

    public abstract void run(int limit);
}
