public class Employee {
    private String userName;
    private String position;
    private String email;
    private String mobileNumber;
    private int salary;
    private int age;

public Employee(String userName, String position, String email, String mobileNumber, int salary, int age){
    this.userName = userName;
    this.position = position;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.salary = salary;
    this.age = age;
}

    public void printInfo(){
        System.out.println("ФИО: " + userName + "; Должность: " + position + "; Почтовый адрес: " + email + "; Мобильный телефон: " + mobileNumber + "; Зарплата:" + salary + "; Возраст: " + age);
    }

    public int getAge(){
    return age;
    }

public class EmployeeTest {


    public static void main(String[] args) {
        Employee employee1 = new Employee("Василий Васильевич Васильев", "Менеджер по продажам", "sales@mail.ru","89146667722", 50000, 35);
        Employee employee2 = new Employee("Иванов Петр Алексеевич", "Коммерческий директор", "сommercial@mail.ru", "89317772233", 100000, 57);
        Employee employee3 = new Employee("Игнатенко Нина Геннадьевна", "Бухгалтер", "finance@mail.ru", "89413338899", 45000, 42);
        Employee employee4 = new Employee("Прокофьев Андрей Анатольевич", "Специалист по логистике", "logist@mail.ru", "89413338899", 60000, 45);
        Employee employee5 = new Employee("Астешенко Ольга Васильевна", "Офис-менеджер", "info@mail.ru", "89319994411", 40000, 29);
        Employee[] employeeList = {employee1, employee2, employee3, employee4, employee5};

        for (int i = 0; i < employeeList.length ; i++) {
            if((employeeList[i].getAge()) > 40){
                employeeList[i].printInfo();
            }
        }
    }

}
