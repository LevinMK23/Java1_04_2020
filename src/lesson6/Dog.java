package lesson6;

public class Dog extends Animal {
    private String name;
    private String age;
    private String color;
    static int countDog;

    public Dog(String name, String age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
        countDog++;
    }

    public String getAge() {
        System.out.println("Возраст: " + age);
        return age;
    }
    public String getColor() {
        System.out.println("Цвет: " + color);
        return color;
    }

    public String getName() {
        System.out.println("Имя: " + name);
        return name;
    }

    public void Swim(int swimLimit) {
        getName();
        super.Swim(swimLimit);
        if (swimLimit > 10 || swimLimit < 1) {
            System.out.println("Sorry, i cant swim that distance");
        } else {
            System.out.println("Nice! I'm SWIMMING!!!");
        }
    }

    public void Run(int runLimit) {
        getName();
        super.Swim(runLimit);
        if (runLimit > 500 || runLimit < 1) {
            System.out.println("Sorry, i cant RUN that distance");
        } else {
            System.out.println("Nice! I'm RUNNING!!!");
        }
    }

    public void getCountDog(){
        System.out.println("Собак: " + countDog);
    }
}
