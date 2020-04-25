package lesson6.homework;

public class Animal {

    private static int counter = 0;
    private int id;

    public Animal() {
        counter++;
        id = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }
}
