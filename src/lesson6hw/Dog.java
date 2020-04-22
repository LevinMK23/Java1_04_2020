package lesson6hw;

public class Dog extends Animal{
    static int dogsCount = 0;
    public Dog (String name) {
        super(name);
        setRunLimit(500);
        setSwimLimit(10);
        dogsCount++;
    }

    @Override
    void count() {
        System.out.println("Total dogs count: " + dogsCount);
    }
}
