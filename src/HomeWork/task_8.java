package HomeWork;
//*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
// Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

public class task_8 {
    public static void main(String[] args) {
        int year = 2020;
        isLeap(year);
    }
    private static void isLeap(int year){
        if(year % 4 == 0 && year % 100 !=0 ) System.out.println("This year is leap");
        else if (year % 400 == 0) System.out.println("This year is leap");
        else System.out.println("This year is ordinary");
    }
}
