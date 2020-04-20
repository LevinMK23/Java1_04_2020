package HomeWork;

import java.util.Random;

public class Disney {

        private String name;
        private String position;
        private String email;
        private String phone;
        private int payroll;
        private int age;
        private final static Random rnd = new Random();

        public Disney(String name, int age, String position, String email, String phone) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.age = age;
            this.phone = phone;
            this.payroll = rnd.nextInt(1000)*10;
        }

        public int getAge(){
            return age;
        }

        @Override
        public String toString(){
            return "Сотрудник{" +
                    "имя=" + name +
                    ", должность=" + position +
                    ", возраст=" + age +
                    ", зарплата=" + payroll +
                    "$, телефон=" + phone +
                    ", почта=" + email +
                    '}';
        }


    }

