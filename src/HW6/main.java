package HW6;

public class main {

    public static void main(String[] args) {
        Animal barsik = new Cat("Barsik");
        barsik.run(150);
        barsik.swim(5);
        Cat vaska = new Cat("Vaska");
        vaska.run(350);

        Dog bobik = new Dog("Bobik");
        bobik.run(444);
        bobik.swim(7);
        Dog tuzik = new Dog("tuzik");
        tuzik.run(1000);
        tuzik.swim(50);

        System.out.println(Animal.countCat);
        System.out.println(Animal.countDog);
        System.out.println(Animal.countAnimal);
    }


}
