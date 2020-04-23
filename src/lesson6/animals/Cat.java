package lesson6.animals;

public class Cat extends Animal implements Runnable, Jumpable {

    public Cat() {
        setType("Cat");
    }

    @Override
    public void swim() {
        throw new RuntimeException("I'm cat! Fuck of!!!");
    }

    @Override
    public void say() {
        System.out.println("MEOW");
    }

    @Override
    public void jump() {
        System.out.println("I jump");
    }

    @Override
    public void run() {
        System.out.println("I'm running");
    }

    


}
