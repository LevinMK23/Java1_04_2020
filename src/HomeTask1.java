import java.util.Scanner;

public class HomeTask1 {

    public static void main(String[] args) {
        System.out.println(task3(1, 2, 6, 2));
        System.out.println(task4(3, 12));
        task5(5);
        System.out.println(task6(4));
        task7("Никита");
        name1 = "Андрей";
        System.out.println("Привет, "+ name1+ "!");
        task8();


    }

    public static int task3(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean task4(int e, int f) {
        int sum = e + f;
        boolean s = (sum >= 10 && sum <= 20);
        return s;
    }

    public static void task5(int k) {
        if (k < 0) {
            System.out.println("Число отрицательное!");
        } else {
            System.out.println("Число положительное!");

        }
    }

    public static boolean task6(int z) {
        if (z >= 0) {
            boolean r = false;
            return r;
        } else {
            boolean d = true;
            return d;
        }
    }

    public static void task7(String name) {
        System.out.println("Здравствуй, " + name + "!");
    }

    public static String name1;

    public static void task8(){
        Scanner x = new Scanner(System.in);
        System.out.println("Укажите год (проверим его на 'високосность'):");
        int y = x.nextInt();
        if(y % 4 == 0 && y % 100 !=0){
            System.out.println("Год високосный!");
        }else if(y % 400 == 0){
            System.out.println("Год високосный!");
        }else{
            System.out.println("Год невисокосный!");
        }
    }

    }

