package lesson6;


public class Cat extends Animal{

    public static int countCat;
    private String name;
    private String age;
    private String color;

    public Cat(String name, String age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
        countCat++;
    }

    public void getCountCat(){
        System.out.println("Котов: " + countCat);
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

    @Override
    public void Swim(int swimLimit) {
        getName();
        super.Swim(swimLimit);
        System.out.println("I'm Cat, I cant swim");
    }

    public void Run(int runLimit) {
        getName();
        super.Swim(runLimit);
        if (runLimit > 200 || runLimit < 1) {
            System.out.println("Sorry, i cant RUN that distance");
        } else {
            System.out.println("Nice! I'm RUNNING!!!");
        }
    }

}
