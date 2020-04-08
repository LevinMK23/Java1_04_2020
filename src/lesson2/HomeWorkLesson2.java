package lesson2;

import java.util.Arrays;

public class HomeWorkLesson2 {

    public static void main(String[] args) {
        task4();
        task5();
        int[] arr = new int[]{1,2,3,4,   4,1,2,3};
        System.out.println(task6(arr));
        task7(arr, 2);
    }

    public static void task1(){

        int arr [] = new int [] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0  ? 1 : 0;
        }

    }

    public static void task2(){

        int arr [] = new int [8];
        int i = 0, n = 0;
        do {
            arr[i] = n;
            n += 3;
            i++;
        } while (i < arr.length);
    }

    public static void task3(){

        int arr [] = new int [] {1,2,3,4};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i]*=2;
        }
    }

    public static void task4(){

        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length-1-i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    public static void task5(){

        int[] arr = new int[] {1,2,3,4,5};
        int min = 0, max = 0;

        for (int i : arr) {
            if (min > i)
                min = i;
            if (max < i)
                max = i;
        }
        System.out.println("min = " + min + ", max = " + max);
    }

    public static boolean task6 (int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int left = 0, right = 0;

            for (int j = 0; j < i ; j++) {
                left+= arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                right+= arr[j];
            }

            if (left == right)
                return true;
        }
        return false;
    }

    public static void task7(int[] arr, int n){

        for (int i = 0; i < n; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (j-1 >= 0)
                    arr[j] = arr[j-1];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
