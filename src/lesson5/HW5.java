package lesson5;



public class HW5 {
    public static void main(String[] args)  {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee();
        employees[0].setName("Ivanov Ivan");
        employees[0].setAge(20);
        employees[0].setMail("ivanov@mail.ru");
        employees[0].setPhoneNumber("89225448521");
        employees[0].setPosition("Customer");
        employees[0].setSalary(2000);

        employees[1] = new Employee();
        employees[1].setName("Elena Modnica");
        employees[1].setAge(45);

        employees[2] = new Employee();
        employees[2].setName("Boris Britva");
        employees[2].setAge(50);

        employees[3] = new Employee();
        employees[3].setName("Dmitriy Kozyavkin");
        employees[3].setAge(33);

        employees[4] = new Employee();
        employees[4].setName("Merunes Dagon");
        employees[4].setAge(27);


        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].getInfo();;
            }
        }
    }


}
