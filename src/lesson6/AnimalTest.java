package lesson6;

class AnimalTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Coco", 8, 5);
        cat1.swim(150);
        cat1.run(60);
        cat1.jump(5);
        Dog dog1 = new Dog("Kiki", 2, 12, 100);
        dog1.swim(6);
        dog1.run(400);
        dog1.jump(1);
    }
}