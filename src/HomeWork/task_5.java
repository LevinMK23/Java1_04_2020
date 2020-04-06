package HomeWork;
//Написать метод, которому в качестве параметра передается целое число, метод должен
// напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

public class task_5 {
    public static void main(String[] args) {
        int a = 0;
        checkNumber(a);
    }
    private static void checkNumber(int x){
        if (x < 0) System.out.println("Number is negative");
        else System.out.println("Number is positive");
    }
}
