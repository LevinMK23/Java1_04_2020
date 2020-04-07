package lesson1;

public class HW_3 {
    public static void main(String []args) {
//метод напечатает результат в консоль
        System.out.println(result(2,1,5,7));
    }
//метод вернет число float
    public static float result(float a,float b, float c,float d) {

        return a * (b + (c / d));
    }

}


