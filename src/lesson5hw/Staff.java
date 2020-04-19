package lesson5hw;

public class Staff {
    private String fullName;
    private String position;
    private String email;
    private String mobile;
    private int salary;
    private int age;

    public Staff(String fullName, String position, String email, String mobile, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.mobile = mobile;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public void info() {
        System.out.println("Сотрудник ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("E-mail: " + email);
        System.out.println("Телефон: " + mobile);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println("---");
    }

    public static void main(String[] args) {
        Staff[] staffArray = new Staff[5];
        staffArray[0] = new Staff("Иванов Иван Иванович", "Менеджер продаж", "ivanov@company.ru", "89892334234", 40000, 32);
        staffArray[1] = new Staff("Чернов Алексей Алексеевич", "Продавец", "chernov@company.ru", "89892334234", 30000, 41);
        staffArray[2] = new Staff("Козлов Алексей Антонович", "Инженер", "kozlov@company.ru", "8900000012", 35000, 45);
        staffArray[3] = new Staff("Петров Артем Алексеевич", "Курьер", "petrov@company.ru", "89892334234", 20000, 21);
        staffArray[4] = new Staff("Сидоров Дмитрий Александрович", "Директор", "sidorov@company.ru", "89892334234", 80000, 50);

        for (Staff person: staffArray) {
            if (person.age > 40) person.info();
        }
    }
}
