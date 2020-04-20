public class Main {
    //psvm public static void main
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employee[1] = new Employee("Ivanov Ivan 1", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 41);
        employee[2] = new Employee("Ivanov Ivan 2", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 69);
        employee[3] = new Employee("Ivanov Ivan 3", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 43);
        employee[4] = new Employee("Ivanov Ivan 4", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 21);

        for (Employee value : employee) {
            if (value.getAge() > 40)
//                System.out.println(value);
                value.showMeta();
        }
    }
}
