package lesson6.Home_work_lesson_6;

public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println("Мяукает");
    }

    @Override
    public void run(int a) {
        if (a > 200) {
            System.out.println("Я кот, а не скаковая лошадь!");
        } else {
            System.out.println("Кот пробежал " + a + " м");
        }
    }

    public void swim(int b) {
        System.out.println("Я не умею плавать!");
    }

    public  void nameInfo(){
        System.out.println("Имя кота: " + name);
    }


}
