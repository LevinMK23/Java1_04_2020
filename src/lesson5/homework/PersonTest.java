package lesson5.homework;

import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {
        Person[] employee = new Person[5];

        //Заполнение на каждого сотрудника через консоль
//        for (int i = 0; i < employee.length; i++) {
//            employee[i] = new Person();
//        }

        // Заполнение данных сотрудников готовыми значениями
        employee[0] = new Person("Иванов Иван Иванович","Главный инженер", "iivanov@company.ru", 89139139139L, 60000, 25, 01, 1975);
        employee[1] = new Person("Петров Пётр Петрович","Инженер отдела эксплуатации", "ppetrov@company.ru", 89239239239L, 40000, 11, 04, 1985);
        employee[2] = new Person("Сидоров Сидор Сидорович","Монтажник подключения", "ssidorov@company.ru", 89131234567L, 35000, 21, 07, 1995);
        employee[3] = new Person("Андреев Андрей Андреевич","Менеджер по работе с клиентами", "aandreev@company.ru", 89139876543L, 30000, 14, 11, 1982);
        employee[4] = new Person("Васильев Василий Васильевич","Начальник службы технической поддержки", "vvasiljev@company.ru", 89536874581L, 40000, 18, 05, 1971);

        for (int i = 0; i < 5; i++) {
            System.out.println(employee[i]);
        }

        //Фильтрация сотрудников по возрасту
        int age;
        System.out.println("Выборка сотрудников старше определённого возраста");
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите требуемый возраст:");
            try {
               age = in.nextInt();
            } catch(Exception e) {
                System.err.println("Введены некорректные данные");
                continue;
            }
            break;
        }
        for (int i = 0; i < employee.length; i++) {
            if(employee[i].getAge() >= age) { System.out.println(employee[i]); }
        }
    }
}
