package lesson6.animals;

public class Dog extends Animal implements Runnable, Jumpable {

    public Dog() {
        setType("Dog");
    }

    @Override
    public void say() {
        System.out.println("WOW");
    }

    @Override
    public void swim() {
        System.out.println("I'm swimming");
    }

    @Override
    public void jump() {
        System.out.println("I'm lazy dog");
    }

    @Override
    public void run() {
        System.out.println("I'm sleeping");
    }
}
