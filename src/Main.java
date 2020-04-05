public class Main {
    //psvm public static void main
    public static void main(String[] args) {
        //sout
        //System.out.println("Hello world");

        System.out.println(""+Task_3(1,2,10,3));
        System.out.println(""+Task_4(7,4));
        Task_5(-4);
        System.out.println(""+Task_6(-7));
        Task_7("Александр");
        System.out.println(""+Task_8(2303));
    }

    static  double Task_3(double a, double b, double c, double d)
    {
        return a * (b + (c / d)) ;
    }

    static  boolean Task_4(int a, int b)
    {
        int sum = a+b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    static  void Task_5(int a)
    {
        if (a >= 0 ) {
            System.out.println("Число положительное");
        }
        else {
            System.out.println("Число отрицательное");
        }
    }

    static  boolean Task_6(int a)
    {
        if (a >= 0 ) {
           return false;
        }
        else {
            return true;
        }
    }

    static  void Task_7(String Name)
    {
        System.out.println("Привет, " + Name);
    }

    static  boolean Task_8(double a)
    {
        double result_400 = a/400;
        double result_100 = a/100;
        double result_4 = a/4;

        if ((result_400 - Math.floor(result_400)) == 0) {
            return true;
        }
        else if ((result_100 - Math.floor(result_100)) == 0){
            return false;
        }
        else if ((result_4 - Math.floor(result_4)) == 0){
            return true;
        }
        else {
            return false;
        }
    }


}
