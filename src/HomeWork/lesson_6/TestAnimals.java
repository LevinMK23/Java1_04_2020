package HomeWork.lesson_6;

public class TestAnimals {
    private static void getNameAndRun(Animal animal, int runLength){
        System.out.print(animal.getType() + " " + animal);
        animal.run(runLength);
    }
    private static void getNameAndSwim(Animal animal, int swimLength){
        System.out.print(animal.getType() + " " + animal);
        animal.swim(swimLength);
    }

    public static void main(String[] args) {

        Animal cat1 = new Cat("Vasya");
        Dog dog1 = new Dog("Sharik");
        Animal cat2 = new Cat("Ivan");
        Cat cat3 = new Cat("Жорик");

        getNameAndRun(cat1, 450);
        getNameAndRun(cat2, 150);
        getNameAndRun(dog1,65);

        getNameAndSwim(cat1, 45);
        getNameAndSwim(cat3, 3);
        getNameAndSwim(dog1, 50);

        System.out.println("У нас всего " + Cat.getCatCount() + " кошек.");
        System.out.println("У нас всего " + Dog.getDogCount() + " собак.");
        System.out.println("А всего животных: " + (Dog.getDogCount() + Cat.getCatCount()) + ".");

    }
}
