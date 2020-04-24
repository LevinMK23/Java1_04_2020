package LessonOOP;

public class Dog extends Animal {
    @Override
    public boolean jump(int a) {
        return a > 0.5;
    }

    @Override
    public boolean run(int a) {
        return a > 500;
    }

    @Override
    public boolean swim(int a) {
        return a > 10;
    }
}
