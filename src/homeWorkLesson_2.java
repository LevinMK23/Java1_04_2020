import java.util.Arrays;

public class homeWorkLesson_2 {
    public static void main(String[] args) {
        task1();
        enter();

        task2();
        enter();

        task3();
        enter();

        task4();
        enter();

        task5();
        enter();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(task6(arr));
        enter();

        task7(arr, -3);
        enter();

        task7(arr,3);

    }

    public static void task1() {
        int[] task1 = {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1};
        for (int i = 0; i < task1.length; i++) {
            if (task1[i] == 0) {
                task1[i] = 1;
            } else {
                task1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(task1));
    }

    public static void task2() {
        int[] task2 = new int[8];
        int x = 0;
        for (int i = 0; i < task2.length; i++) {
            task2[i] = x;
            x += 3;
        }
        System.out.println(Arrays.toString(task2));
    }

    public static void task3() {
        int[] task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < task3.length; i++) {
            if (task3[i] < 6) {
                task3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(task3));
    }

    public static void task4() {
        int task4[][] = new int[5][5];
        int count = 0;
        int countM = task4[task4.length - 1].length - 1;
        for (int i = 0; i < task4.length; i++) {
            for (int j = 0; j < task4[i].length; j++) {
                task4[i][count] = 1;
                task4[i][countM] = 1;
                System.out.print(task4[i][j] + " ");
            }
            count++;
            countM--;
            System.out.println();
        }
    }

    public static void task5() {
        int[] task5 = new int[10];
        for (int i = 0; i < task5.length; i++) {
            task5[i] = (int) (Math.random() * 100);
        }

        int max = task5[0];
        int min = task5[0];

        for (int i = 0; i < task5.length; i++) {
            if (min > task5[i]) {
                min = task5[i];
            }
            if (max < task5[i]) {
                max = task5[i];
            }
        }
        System.out.println(Arrays.toString(task5));
        System.out.println("min = " + min);
        System.out.println("max = " + max);

    }

    public static boolean task6(int[] arr) {
        int left = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int right = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                right = right + arr[j];
                if (left == right) {
                    System.out.println(left + " + " + right);
                    return true;
                }
            }
            left = left + arr[i];
        }
        return false;
    }


    public static int[] task7(int[] arr, int x) {
        System.out.println(Arrays.toString(arr));
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                int count = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[arr.length - j - 1] = arr[arr.length - j - 2];
                }
                arr[1] = count;
            }
            System.out.println(Arrays.toString(arr));
        } else {
           for (int i = 0; i > x; i--) {
                int count = arr[arr.length - 1];
                for (int j = 1; j < arr.length - 1; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 2] = count;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
    public static void enter(){
        System.out.println();
    }
}

