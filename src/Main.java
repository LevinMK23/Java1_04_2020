public class Main {
    //psvm public static void main
    public static void main(String[] args) {
        //sout
        System.out.println("Hello world");
        System.out.println(functionOne(24, 24, 26, 8));
        System.out.println(trueOrFalse(6,8));
        System.out.println(numberFive(5));
        System.out.println(numberSix(-5));
        yourName("Вася");
        year(2020);
    }
}
public static int functionOne (int a, int b, int c, int d) {
        int firstNumber = a * (b + (c / d));
        return firstNumber;
    }
    public static boolean trueOrFalse (int a, int b){
        if (a + b <= 20 && a + b >= 10){
            return true;
        } else {
            return false;
        }
    }
    public static String numberFive (int a){
        if( a >= 0){
            return a + " Больше нуля";
        } else {
            return a + " Меньше нуля";
        }
    }
    public static boolean numberSix (int a){
        if (a < 0){
            return true;
        } else {
            System.out.println("Чтобы вернулось значение true необходимо ввести отрицательное число");
            return false;
        }
    }
    public static void yourName (String name){
        System.out.println("Привет " + name + "!");
    }
    public static void year ( int thisYear) {
        if ( thisYear % 400 == 0){
            System.out.println("Год является високосным");
        } else if (thisYear % 100 == 0){
            System.out.println("Год является невисокосным");
        } else if (thisYear % 4 == 0){
            System.out.println("Год является високосным");
        } else {
            System.out.println("Год является невисокосным");
        }
    }
