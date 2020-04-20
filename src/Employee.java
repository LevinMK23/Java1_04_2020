public class Employee {
    private String fullName, position, email, mobileNumber;
    private int salary, age;

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "fullName='" + fullName + '\'' +
//                ", position='" + position + '\'' +
//                ", email='" + email + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", salary=" + salary +
//                ", age=" + age +
//                '}';
//    }

    public int getAge() {
        return age;
    }

    public Employee(String fullName, String position, String email, String mobileNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
        this.age = age;
    }

    public void showMeta() {
        System.out.println("ФИО сотрудника:" + fullName + "\nДолжность:" + position + "\nE-mail:" + email + "\nТелефон:"
                + mobileNumber + "\nЗарплата:" + salary + "\nВозраст:" + age + "\n-------------------------------------");
    }
}
