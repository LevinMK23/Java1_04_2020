package lesson5;

public class Employee {
    private String fullName, position, email, telephone;
    private int salary, age;

    public Employee(String fullName, String position, String email, String telephone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("ФИО: " + fullName + " Должность: " + position + ". Email: " + email +
                ". Tелефон: " + telephone + ". Зарплата: " + salary + ". Bозраст: " + age + ".");
    }

    public void getInfoForty() {
        System.out.println("ФИО: " + fullName + " Bозраст: " + age + ".");
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Пушкин А.С.", "Sales manager", "pushka@mail.ru",
                "+ 972 678 67 66", 4000, 37);
        employee1.getInfo();

        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Федоров А.А.", 27);
        employeesArray[1] = new Employee("Степанов Б.Б.", 45);
        employeesArray[2] = new Employee("Иванов В.В.", 53);
        employeesArray[3] = new Employee("Сидоров Г.Г.", 32);
        employeesArray[4] = new Employee("Смирнов Д.Д.", 41);

        for (Employee overForty : employeesArray) {
            if (overForty.age > 40) overForty.getInfoForty();
        }

    }
}
