package lesson2;

import java.util.Arrays;

public class Homework_2 {

    public static void task1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task2() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task4() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
                if (i == j) {
                    arr[i][j] = 1;
                }
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println("");
        }
    }

    public static void task5() {
        int[] arr = {9, 42, 17, -80, 197, 23, 6, 15};
        int max;
        int min;
        max = min = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }

    public static boolean task6(int[] arr) {
        int left, right, sum;
        left = right = sum = 0;
        for (int i : arr) {
            sum += i;
        }
        for (int i = 0; i < arr.length; i++) {
            left += arr[i];
            right = sum - left;
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    public static void task7(int[] arr, int n) { //смещение с потерей элементов массива
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
            }
        } else {
            for (int i = 0; i > n; i--) {
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task7_1(int[] arr, int n) { //смещение без потери элементов массива
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                for (int j = arr.length - 1; j > 0; j--) {
                    int c = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = c;
                }
            }
        } else {
            for (int i = 0; i > n; i--) {
                for (int j = 0; j < arr.length - 1; j++) {
                    int c = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = c;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        System.out.println(task6(new int[]{5, 8, 36, 15, 21}));
        System.out.println(task6(new int[]{3, 10, 15, 15, 13}));
        task7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        task7_1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2);
    }
}
