package HomeWork.lesson_6;

public class Dog extends Animal {
    private String name;
    private static int dogCount = 0;

    public Dog(String name) {
        this.name = name;
        setType("Dog");
        setRunLimit(500);
        setSwimLimit(10);
        dogCount++;
    }
    public static int getDogCount(){return dogCount;}

    @Override
    public String toString() {
        return name;
    }
}
