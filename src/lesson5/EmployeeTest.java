package lesson5;

class EmployeeTest {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[4];
        empArray[0] = new Employee("James Hetfield","lead guitar","james@metallica.com","123456789",50000,56);
        empArray[1] = new Employee("Lars Ulrich","drums","lars@metallica.com","123456789",50000,56);
        empArray[2] = new Employee("Kirk Hammet","solo guitar","kirk@metallica.com","123456789",50000,57);
        empArray[3] = new Employee("Robert Trujillo","bass guitar","james@metallica.com","123456789",50000,55);
        for (Employee emp:empArray) {
            if (emp.getAge() > 40) System.out.println(emp);
        }
    }
}