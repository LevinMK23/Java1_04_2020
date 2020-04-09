package lesson1;

public class Lesson {

    //Студент Романенко Денис выполнил
    // Домашнее задание к уроку 1 Java. Уровень 1
    //Задание 3: Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float.

    public static double lesson(float a, float b, float c, float d) {
        float e = a * (b + (c / d));
        return e;
    }
    // Задание 4: Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

    public static boolean sumResult(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(lesson(2, 3, 6, 9));
        System.out.println(sumResult(14, 10));
        positiveOrNegative(-4);
        System.out.println(negativeNumber(6));
        helloName("Михаил");
        leapYears(2012);

    }

    //Задание 5: Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void positiveOrNegative(int num) {
        if (num >= 0) {
            System.out.println("Число " + num + " является положительным");
        } else {
            System.out.println("Число " + num + " является отрицательным");
        }
    }

    //Задание 6:Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное.
    public static boolean negativeNumber(int num) {
        if (num < 0) {
            return true;
        }else{
            return false;
        }
    }

    //Задание 7: Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!»

    public static void helloName(String name){
        System.out.println("Привет, " + name + "!");
    }

    //Задание8: Написать метод, который определяет, является ли год високосным,
    // и выводит сообщение в консоль. Каждый 4-й год является високосным,
    // кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void leapYears(int year){
        if(year % 4 == 0 & year % 100 != 0 | year % 4 == 0 & year % 400 == 0){
            System.out.println("Високосный год");
        } else{
            System.out.println("Не является високосным");
        }
    }

 }
