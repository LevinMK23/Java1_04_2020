package lesson5.Home_Work_lesson_5;

public class Worker {
    private String name, post, email, phoneNumber;
    private int wages;
    private int age;

    public Worker(String name, String post, String email, String phoneNumber, int wages, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wages = wages;
        this.age = age;
    }

    public void info() {
        System.out.println("Имя: " + name + ";\nДолжность: " + post + ";\nПочта: " + email +
                ";\nНомер телефона: " + phoneNumber + ";\nЗаработная плата: " + wages + " руб." +
                ";\nВозраст: " + age);
    }


    public static void main(String[] args) {


        Worker[] array = new Worker[5];
        array[0] = new Worker("Трутнев Прокастинатор Оболтусович", "надсмоторщик - шеф",
                "oboltus52@mail.ru", "+7911 284-36-45", 230000, 52);
        array[1] = new Worker("Дурьева Мигера Истеридовна", "любовница шефа",
                "migera25@mail.ru", "+7911 356-84-79", 200000, 25);
        array[2] = new Worker("Мордоворотов Костолом Выбейглазович", "охранник",
                "ему не нужна", "+7911 666-13-13", 50000, 43);
        array[3] = new Worker("Подхалимов Хитрован Лизопопович, +7965 756-45-65", "замшефа",
                "hitriyliz32@mail.ru", "+7965 567-28-39", 150000, 32);
        array[4] = new Worker("Работягин Пахарь Трудолюбович", "рядовой сотрудник",
                "trudolubovich30@mail.ru", "+7965 443-25-63", 20000, 30);

        array[0].info();
        System.out.println("-----------------------------------------");
        array[1].info();
        System.out.println("-----------------------------------------");
        array[2].info();
        System.out.println("-----------------------------------------");
        array[3].info();
        System.out.println("-----------------------------------------");
        array[4].info();
        System.out.println("-----------------------------------------");

        System.out.println("\nКОМУ БОЛЬШЕ 40 ЛЕТ\n");
        for (int i=0; i < array.length; i++)
            if (array[i].age > 40) {
                array[i].info();
                System.out.println("-----------------------------------------");
            }

    }



}
