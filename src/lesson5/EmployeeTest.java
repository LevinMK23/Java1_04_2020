package lesson5;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Юбко Алёна Александровна", "Финансовый менеджер", "Alena@mail.ru", "+7-816-648-65-48", 42000, 35);
        employees[1] = new Employee("Варганов Андрей Александрович", "Руководитель финансового департамента", "Andrew@mail.ru", "+7-825-548-35-14", 100, 50);
        employees[2] = new Employee("Кокорина Надежда Ивановна", "Аналитик", "Nadejda@mail.ru", "+7-825-156-38-87", 35, 24);
        employees[3] = new Employee("Кретова Татьяна Сергеевна", "Руководитель отдела кадров", "Tanya@mail.ru", "+7-825-457-31-73", 50, 42);
        employees[4] = new Employee("Арсентьева Дарья Ивановна", "Финансовый менеджер", "Daria@mail.ru", "+7-825-164-91-46", 35, 24);

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                System.out.println(employee);
            }
        }
    }
}
