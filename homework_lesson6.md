public class Animal {
    String name;
    private int age;
    private int runDistance;
    private int swimDistance;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void run (int runDistance){
        System.out.println("Животное пробежало " + runDistance + " метров");
    }

    public void swim(int swimDistance){
        System.out.println("Животное проплыло " + swimDistance + " метров");
    }
}

public class Cat extends Animal {
    private String color;
    private int runLimit = 200;

    public Cat(String name, int age, String color){
        super(name, age);
        this.color = color;
    }

    @Override
    public void run(int runDistance) {
        if (runLimit > runDistance) {
            System.out.println("Кот " + name + " пробежал " + runDistance + " метров");
        } else {
            System.out.println("Коты не могут пробежать дистанцию свыше " + runLimit + " метров");
        }
    }

    @Override
    public void swim(int swimDistance){
        System.out.println("Коты не умеют плавать");
    }
}

public class Dog extends Animal {
    private String color;
    private int runLimit = 500;
    private int swimLimit = 10;

    public Dog(String name, int age, String color){
        super(name, age);
        this.color = color;
    }

    @Override
    public void run(int runDistance) {
        if (runLimit > runDistance){
            System.out.println("Собака " + name + " пробежала " + runDistance + " метров");
        } else {
            System.out.println("Собаки не могут пробежать дистанцию свыше " + runLimit + " метров");
        }
    }

    @Override
    public void swim(int swimDistance) {
        if(swimLimit > swimDistance) {
            System.out.println("Собака " + name + " проплыла " + swimDistance + " метров");
        } else {
            System.out.println("Собаки не могут проплыть дистанцию свыше " + swimLimit + " метров");
        }
    }
}

public class AnimalsApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 2, "серый");
        cat1.run(150);
        cat1.swim(200);
        Cat cat2 = new Cat("Снежок", 1, "белый");
        Dog dog1 = new Dog("Бобик", 6, "чёрный");
        dog1.run(700);
        dog1.swim(50);
    }
}



