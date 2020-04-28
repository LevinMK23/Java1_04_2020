package lesson6;

public abstract class Animal{

    static int animalCount;

    public Animal(){
        animalCount++;
    }

    public void getAnimalCount(){
        System.out.println("Всего животных: " + animalCount);
    }

    public void Swim(int swimLimit) {
        System.out.println("Дистаниция: " + swimLimit);

    }

    public void Run(int runLimit) {

        System.out.println("Дистаниция: " + runLimit);

    }

}
