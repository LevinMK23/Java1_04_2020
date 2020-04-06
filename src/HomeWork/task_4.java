package HomeWork;
//Написать метод, принимающий на вход два целых
// числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false

public class task_4 {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println(checkSumm(a, b));
    }

    private static boolean checkSumm(int a, int b){
        if (a + b >= 10 && a + b <=20) return true;
        else return false;
    }
}
