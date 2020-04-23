package lesson6;

public class Dog extends Animal{
    private String name;
    public Dog(String name) {
        super(0.5f, 10, 500);
    }

    public Dog(String name,double jumpLimit,double swimLimit, double runLimit) {
        super(jumpLimit, swimLimit, runLimit);
        setName(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
