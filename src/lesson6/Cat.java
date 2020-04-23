package lesson6;


public class Cat extends Animal {
    private String name;
    public Cat(String name) {
        super(2, 0, 200);
        setName(name);
    }
    public Cat(String name,double jumpLimit,double runLimit) {
        super(jumpLimit, 0, runLimit);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
