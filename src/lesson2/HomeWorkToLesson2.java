
public class HomeWorkToLesson2 {

    public static void Task1 () {
        int[] a = {1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0};
        for (int i : a) {
           if (i == 0) a[i] = 1;
           else a[i] = 0;
        }
    }

    public static void Task2 () {
        int[] a = new int[8];
        int n = 0;
        for (int i = 0; i < a.length ; i++) {
            a[i] = n;
            n += 3;
        }
    }

    public static void Task3 () {
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) a[i] *= 12;
        }
    }

    public static void Task4() {
        int[][] a = new int[5][5];
        int n = 0;
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                a[i][n] = 1;
                System.out.printf("%4d",a[i][j]);
            }
            System.out.println();
            n++;
        }
    }

    public static void Task5 () {
        int[] a = {23, 44, 3, 22, 1001, 5, 100, 7, 8, 9};
        int min = 99, max = 0;
        for (int value : a) {
            if (value > max) max = value;
            else if (value < min) min = value;
        }
        System.out.println(max + " " + min);
    }

    public static boolean Task6 (int[] a){
        int sum1 = 0, sum2 = 0;
        for (int value : a) {// запускаем с начала
            sum2 += value;
            for (int j = a.length - 1; j != 0; j--) { // запускаем с конца
                sum1 += a[j]; // считаем
                if (sum1 == sum2) return true;
            }
            sum1 = 0; // если if не сработал, тогда обнуляем
        }
        return false;
    }

//    public static int[] Task7 (int[] a, int n) {
//    Эту задачку я не смог осилить
//    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2, 1, 2, 2, 10, 1};
        Task1();
        Task2();
        Task3();
        Task4();
        Task5();
        System.out.println(Task6(a));
    }
}
