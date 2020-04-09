package lesson2;

import java.util.Arrays;

public class HomeTask2 {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        task5();
        System.out.println(task6());
        int[] arr = {1, 2, 0, 3};
        System.out.println(task6_1(arr));
        int[]array7 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        task7(array7, 2);


    }

    public static void task1() {
        int array[] = {0, 0, 0, 1, 1, 1, 0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }

    }

    public static void task2() {
        int[] array = new int[8];
        for (int j = 0; j < array.length; j++) {
            array[j] = j * 3;
            System.out.print(array[j] + " ");
        }
    }

    public static void task3() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int k = 0; k < array.length; k++) {
            if (array[k] < 6) {
                array[k] *= 2;
            }
            System.out.print(array[k] + " ");

        }
    }

    public static void task4() {
        int[][] array = new int[4][4];
        for (int z = 0; z < array.length; z++) {
            for (int c = 0; c < array[z].length; c++) {
                array[z][c] = 1;
                System.out.print(array[z][c] + " ");
            }
            System.out.println();
        }
    }

    public static void task5() {
        int array[] = {12, 4, -6, 7, 14, 2, 5};
        int max = array[6], min = array[6];
        for (int f = 0; f < array.length; f++) {
            if (array[f] > max) {
                max = array[f];
            } else if (array[f] < min) {
                min = array[f];
            }
        }
        System.out.println("max: " + max + " " + "min: " + min);

    }

    public static boolean task6() {
        int[] array = {1, 2, 3, 1, 5};
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < array.length - 2; i++) {
            sum1 += array[i];
        }
        for (int j = 3; j < array.length; j++) {
            sum2 += array[j];
        }
        if (sum1 == sum2) {
            return true;
        } else return false;
    }

    public static boolean task6_1(int[] arr) {
        int sum1, sum2;
        for (int i = 0; i < arr.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                sum2 += arr[j];
            }
            if (sum1 == sum2) return true;
        }
        return false;
    }

    public static void task7(int[] array7, int n) {
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                for (int j = array7.length - 1; j > 0; j--) {
                    array7[j] = array7[j - 1];
                }
            }
        } else {
            for (int i = 0; i > n; i--) {
                for (int j = 0; j < array7.length - 1; j++) {
                    array7[j] = array7[j + 1];
                }
            }
        }
        System.out.println(Arrays.toString(array7));
    }
}







