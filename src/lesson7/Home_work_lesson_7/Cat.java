package lesson7.Home_work_lesson_7;

public class Cat{
    private String name;
    private int appetite;

    public Cat (String name, int appetite) {
        if (appetite < 0) {
            appetite = 0;
        }
        this.name = name;
        this.appetite = appetite;
    }


    public void infoCat() {
        System.out.println("Имя кота: " + name + " |" + " Вместимость желудка: " + appetite);
    }

    public void eat (Plate p) {
        p.decreaseFood(appetite);
    }


}
