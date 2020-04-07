package lesson1;

public class HW_4 {
    public static void main(String []args) {
        //метод напечатает в консоль значение boolean
        System.out.println(HW4(5,15));
    }
    //вернется значение boolean после проверки условия
    public static boolean HW4(int a,int b) {

        if (a + b >= 10 && a + b <= 20) {
            return true;
        }
            else { return false;

            }

    }

}

