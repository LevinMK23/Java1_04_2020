package lesson2;

import java.util.Arrays;

public class HomeWork_02 {

    public static void main(String[] args) {


        int[] arr_01 = {1, 1, 1, 0, 0, 1, 1, 0, 1, 0}; //Задание № 1
        System.out.println("Задание № 1\nМассив: " + Arrays.toString(arr_01));
        for (int i = 0; i < arr_01.length; i++) {
            if (arr_01[i] == 1) {
                arr_01[i] = 0;
            } else {
                arr_01[i] = 1;
            }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr_01));


        int[] arr_02 = new int[8]; //Задание № 2
        for (int i = 0; i < arr_02.length; i++) {
            arr_02[i] = i * 3;
        }
        System.out.println("Задание № 2\nМассив: " + Arrays.toString(arr_02));


        int[] arr_03 = {1,5,3,2,11,4,5,2,4,8,9,1}; //Задание № 3
        System.out.println("Задание № 3\nМассив: " + Arrays.toString(arr_03));
        for (int i = 0; i < arr_03.length; i++) {
            if (arr_03[i] < 6) {
                arr_03[i] *= 2;
            }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr_03));


        int[][] arr_04 = new int[5][5]; //Задание № 4
        int x = 1;
        int y = 0;
        System.out.println("Задание № 4\nДвумерный массив:");
        for (int i = 0; i < arr_04.length ; i++) {
            for (int j = 0; j < arr_04.length; j++) {
                if (i == j || i+j == 4){
                    arr_04[i][j] = x;
                }
                else {
                    arr_04[i][j] = y;
                }
                System.out.print(arr_04[i][j] + "  ");
            }
            System.out.println();
        }


        int[] arr_05 = {3,21,10,47,5,25,58,14,95,86}; //Задание № 5
        System.out.println("Задание № 5\nМассив: " + Arrays.toString(arr_05));
        int max = -1000000;
        int min = 1000000;
        for (int i = 0; i < arr_05.length; i++) {
            if (arr_05[i] < min) {
                min = arr_05[i];
            }
            else if (arr_05[i] > max) {
                max = arr_05[i];
            }
        }
        System.out.println("Максимальное число массива: " + max + "\nМинимальное число массива: " + min);

        int[] arr_06 = {2,3,7,6,2,4,9,7}; //К заданию № 6
        arrayMethod(arr_06);
    }


    public static void arrayMethod(int[] arr_06) { //Задание № 6
        System.out.println("Задание № 6\nМассив: " + Arrays.toString(arr_06));
        int sum = 0;
        int halfSum = 0;
        for (int i = 0; i < arr_06.length ; i++) {
            sum += arr_06[i];
        }
        sum /= 2;
        for (int i = 0; i < arr_06.length; i++) {
            halfSum += arr_06[i];
            if (halfSum == sum ) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}

