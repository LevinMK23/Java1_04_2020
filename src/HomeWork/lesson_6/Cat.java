package HomeWork.lesson_6;


public class Cat extends Animal {
    private String name;
    private static int catCount = 0;

    public Cat(String name) {
        this.name = name;
        setType("Cat");
        setRunLimit(200);
        setSwimLimit(0);
        catCount++;
    }
    public static int getCatCount(){return catCount;}

    @Override
    public void swim(int swimLength) {
        System.out.println(" не умеет плавать!");
    }

    @Override
    public String toString() {
        return name;
    }
}
