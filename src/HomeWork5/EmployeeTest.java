package HomeWork5;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee[] persArray = new Employee[5]; // Вначале объявляем массив объектов
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 42);
        persArray[1] = new Employee("Petrov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[2] = new Employee("Sidorov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 65);
        persArray[3] = new Employee("Anya", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[4] = new Employee("Ivanov Vasya", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 18);

        for (int i = 0; i < persArray.length; i++) {
           if ( persArray[i].checkAge(40)){
               persArray[i].show();
           }
        }
    }

}
