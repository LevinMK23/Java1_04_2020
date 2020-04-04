package lesson1;

public class Homework {
    static int task3(int a, int b, int c, int d){
        if (d==0) {
            System.out.println(" division by zero");
            return 0;
        }
        return a*(b +(c/d));
    }

    static  boolean task4(int a, int b){
        return (10 <= a+b && a+b <= 20);
    }

    static void task5(int a){
        if (task6(a)) {
            System.out.println("Отрицательное");
        }else{
            System.out.println("Положительное");
        }
    }

    static boolean task6(int a){
        return (a<0);
    }

    static void task7(String str){
        System.out.println("Привет "+str);
    }

    static   void task8(int year){
        if ((year % 4 == 0) && (!(year % 100 == 0) || (year % 400 == 0))){
            System.out.println("Високосный");
        }else{
            System.out.println("Не високосный");
        }
    }

    public static void main(String[] args) {
        //sout

        System.out.println(task3(1, 2, 3, 4));

        if (task4(6,4)){
            System.out.println("in range" );
        }else{
            System.out.println("out of range");
        }

        task5(10);
        task5(-10);

        task7("ты");

        task8(1900);
    }
}
