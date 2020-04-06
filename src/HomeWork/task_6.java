package HomeWork;
//Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное.

public class task_6 {
    public static void main(String[] args) {
        int a = -8;
        System.out.println(isNegative(a));
    }
    private static boolean isNegative(int x){
        if (x < 0) return true;
        else return false;
    }
}
