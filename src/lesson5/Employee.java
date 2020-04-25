package lesson5;


public class Employee {
    private String name, position, mail, phoneNumber;
    private int age, salary;


    public void setName(String name) {
        if (name.matches("^\\D+")) {
            this.name = name;
        } else {
            System.out.println("ФИО введенно некорректно.");
        }
    }

    public void setAge(int age) {
        if (age > 16 && age < 100) {
            this.age = age;
        } else {
            System.out.println("Возраст сотрудника ме может быть меньше 16 лет или больше 100.");
        }
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMail(String mail) {
        if (mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") && !mail.isEmpty()) {
            this.mail = mail;
        } else {
            System.out.println("Некорректный адрес e-mail.");
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Неверный номер телефона");
        }
    }

    public void getInfo() {
        System.out.println("ФИО сотрудника: " + getName() +
                "\nВозраст сотрудника: " + getAge());
    }

    public void getAllInfo() {
        System.out.println("ФИО сотрудника: " + getName() +
                "\nДолжность сотрудника: " + getPosition() +
                "\nВозраст сотрудника: " + getAge() +
                "\nНомер телефона: " + getPhoneNumber() +
                "\nЭлектронная почта: " + getMail() +
                "\nЗаработная плата: " + getSalary());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getMail() {
        return mail;
    }

    public int getSalary() {
        return salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
