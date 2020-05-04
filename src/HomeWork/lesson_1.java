package HomeWork;

public class lesson_1 {

    public static void main(String[] args) {
       System.out.println(findResult(12.3f,2.24f, 1.2f,5.1f));

        System.out.println(checkSumm(5, 3));

        checkNumber(-2);

        System.out.println(isNegative(-8));

        String name = "Михаил Константинович";
        printHello(name);

        int year = 2020;
        isLeap(year);

    }
    //task_3
    private static float findResult(float a, float b, float c, float d){
        return (a * (b + (c / d)));
    }

    //task_4
    //Написать метод, принимающий на вход два целых
    // числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false
    private static boolean checkSumm(int a, int b){
        if (a + b >= 10 && a + b <=20) return true;
        else return false;
    }

    //task_5
    //Написать метод, которому в качестве параметра передается целое число, метод должен
    // напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    private static void checkNumber(int x){
        if (x < 0) System.out.println("Number is negative");
        else System.out.println("Number is positive");
    }

    //task_6
    //Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное.
    private static boolean isNegative(int x){
        if (x < 0) return true;
        else return false;
    }

    //task_7
    //Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    private static void printHello(String name){
        System.out.println("Привет, " + name + "!");
    }

    //task_8
    //*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static void isLeap(int year){
        if(year % 4 == 0 && year % 100 !=0 ) System.out.println("This year is leap");
        else if (year % 400 == 0) System.out.println("This year is leap");
        else System.out.println("This year is ordinary");
    }

}
