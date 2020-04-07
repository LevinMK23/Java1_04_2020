package lesson1;

public class HW_8 {
    public static void main(String[] args) {
        int a = 20400;
        int b = 4;
        int c = 100;
        int d = 400;
        //проверка кратности 100 и некратности 400
        if (a % c == 0 && a % d != 0) {
            System.out.println("Год невисокосный");
        } else {
            //проверка кратности 4
            if (a % b == 0) {
                System.out.println("Год високосный");
            }
            else {
                System.out.println("Год невисокосный");
            }

        }
    }
}




