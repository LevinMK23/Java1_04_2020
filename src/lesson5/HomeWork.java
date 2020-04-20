package lesson5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HomeWork {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan Ivanovich", "Director", "ivanov@qwerty.com", "9876543210", 300000, 43);
        employees[1] = new Employee("Petrov Petr Petrovich", "Head of IT", "petrov@qwerty.com", "1234567890", 200000, 35);
        employees[2] = new Employee("Antonov Anton Antonovich", "Lawyer", "antonov@qwerty.com", "2345678901", 200000, 41);
        employees[3] = new Employee("Andreev Andrey Andreevich", "Sales manager", "andreev@qwerty.com", "3456789012", 100000, 26);
        employees[4] = new Employee("Glebov Gleb Glebovich", "Cleaner", "glebov@qwerty.com", "4567890123", 60000, 55);

        // Basic variant
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee.toString());
            }
        }

        // Alternative variant
        Arrays.stream(employees)
                .filter(employee -> employee.getAge() > 40)
                .forEach(employee -> System.out.println(employee.toString()));
    }


}
