package HomeWork5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;
    private int   age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println(this.toString());
    }

    public Employee(String name,String position,String email,String phoneNumber,float salary,int age){

        this.name        = name;
        this.position    = position;
        this.email       = email;
        this.phoneNumber = phoneNumber;
        this.salary      = salary;
        this.age         = age;

    }

    public boolean checkAge(int A){
        if (age > A) return true;

        return false;

    }



}
