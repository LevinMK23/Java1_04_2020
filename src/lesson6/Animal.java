package lesson6;

public class Animal {
    private String name;
    protected int barrierLenght;
    private static int countAnimal = 0;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public String getName() {
        return name;
    }

    public void run(int barrierLenght) {
        this.barrierLenght = barrierLenght;
    }

    public void printCount() {

        System.out.printf("Кол-во животных: %d. ", countAnimal);
    }
}
