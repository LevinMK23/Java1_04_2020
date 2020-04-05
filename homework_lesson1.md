public class Main {

    static float task3 (float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    static boolean task4(int a, int b){
        boolean condition = (a + b) >= 10 && (a + b) <= 20;
        if(condition){
            return true;
        } else {
            return false;
        }
    }


    static void task5(int a){
        if(a >= 0){
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    static boolean task6(int c){
        boolean condition = c >= 0;
        if (!condition){
            return true;
        } else {
            return false;
        }
    }

    static void task7(String name){
        System.out.println("Привет, " + name);
    }

    static void task8(int a){
        boolean condition = a % 100 == 0;
        if (!condition){
            if(a % 4 == 0){
                System.out.println("Год високосный");
            } else {
                System.out.println("Год невисокосный");
            }
        } else {
            if(a % 400 == 0) {
                System.out.println("Год високосный");
            } else {
                System.out.println("Год невисокосный");
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(task3(3.67f, 45.23f, 34.25f, 5.78f));
        System.out.println(task4(17, 3));
        task5(-78);
        System.out.println(task6(0));
        task7("Андрей");
        task8(1900);


    }
}
