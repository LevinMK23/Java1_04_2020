package lesson5;

/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;  - Done
 * Конструктор класса должен заполнять эти поля при создании объекта;   - Done
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;   - Done
 * Создать массив из 5 сотрудников   - Done
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * <p>
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;   - Done
 **/

public class Homework1 {

    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivan Ivanov", "Driver", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Andrey", "Janitor", "petand@mailbox.com", "892312313", 15000, 25);
        persArray[2] = new Person("Galochkin Anton", "Tester", "galant@mailbox.com", "892312314", 40000, 27);
        persArray[3] = new Person("Putin Vladimir", "Director", "putvla@mailbox.com", "892312315", 60000, 50);
        persArray[4] = new Person("Medvedev Dmitry", "Engineer", "meddmi@mailbox.com", "892312316", 55000, 45);

        /**
          Доступные методы для сотрудников:
          .persInfo - Вывод Анкеты сотрудника
          .getAgeFull - "Возраст %имя%: %возраст%
          .getAge - Возраст сотрудника
          .getName - Имя сотрудника
         .getPhone, getEmail, getPosition, getGross - вывод другой сопутствующей информации по сотруднику
         **/

        persArray[1].getAgeFull();
        persArray[1].persInfo();


        for (int i = 0; i < 5; i++) {
            if (persArray[i].getAge() > 40) {
                System.out.println("Обнаружен сотрудник старше 40 лет: " + persArray[i].getName() + "." + "\nЕго возраст " + persArray[i].getAge() + " лет.");
            }
        }
    }
}
