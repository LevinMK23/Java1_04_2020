package LessonOOP;

public class Cat extends Animal {
    @Override
    public boolean jump(int a) {
        return a > 2;
    }

    @Override
    public boolean run(int a) {
        return a > 200;
    }

    @Override
    public boolean swim(int a) {
        return false;
    }
}
