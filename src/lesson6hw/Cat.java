package lesson6hw;

public class Cat extends Animal {
    static int catsCount = 0;
    public Cat (String name) {
        super(name);
        setRunLimit(220);
        catsCount++;
    }

    @Override
    void swim(int swimDist) {
        System.out.println("Коты не умеют плавать!");
    }

    @Override
    void count() {
        System.out.println("Total cats count: " + catsCount);;
    }
}
