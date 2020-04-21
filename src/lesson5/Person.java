package lesson5;

// Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;


public class Person {

    private String name, position, email, phone;
    private int gross, age;

    public Person(String name, String position, String email, String phone, int gross, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.gross = gross;
        this.age = age;
    }

    // Методы на запрос информации по каждой позиции отдельно

    public int getAgeFull() {
        System.out.println("Возраст " + getName() + ": " + age);
        return age;
    }

    public int getAge() {
        return age;
    }

    public int getGross(){
        return gross;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }


    // Вывод информации по сотруднику, общая

    public void persInfo(){
        System.out.println("=====================");
        System.out.println("Анкета сотрудника");
        System.out.println("Имя сотрудника: " + name + '\n' + "Должность: " + position + '\n' + "Эл. почта: "+ email + '\n' + "Телефон: " + phone + '\n' + "Зарплата: " + gross + '\n' + "Возраст: " + age);
        System.out.println("=====================");
    }




}
